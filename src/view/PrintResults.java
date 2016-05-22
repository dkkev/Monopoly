package view;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import model.Board;
import model.Player;
import model.PlayerSpaceStatistics;
import model.SpaceStatistic;

public class PrintResults {

	private final Board board;
	private final int numOfTopSpacesToPrint;
	private final DecimalFormat df;
	
	public PrintResults(Board board, int numOfTopSpacesToPrint){
		this.board = board;
		
		if(numOfTopSpacesToPrint<1) numOfTopSpacesToPrint = 1;
		if(numOfTopSpacesToPrint>40) numOfTopSpacesToPrint = 40;
		this.numOfTopSpacesToPrint = numOfTopSpacesToPrint;
		
		df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
	}
	
	public void print(){
		printPlayerStats();
		printBoardStats();
	}
	
	private void printPlayerStats(){
		int playerNum = 0;
		System.out.println("==========================");
		System.out.println("Individual Player Results:");
		System.out.println("==========================");
		for(Player player : board.getPlayers()){
			playerNum++;
			PlayerSpaceStatistics mySpaceStatistics = player.getSpaceStatistics();
			System.out.println("---------");
			System.out.println("Player " + playerNum + ":");
			System.out.println("---------");
			List<SpaceStatistic> topLandedSpaces = mySpaceStatistics.getTopLandedSpaces(numOfTopSpacesToPrint);
			printStatLine(topLandedSpaces);
		}
	}
	
	private void printBoardStats(){
		PlayerSpaceStatistics overallGameStatistics = board.getOverallGameStatistics();
		System.out.println("\n================");
		System.out.println("Overall Results:");
		System.out.println("================");				
		List<SpaceStatistic> topLandedSpaces = overallGameStatistics.getTopLandedSpaces(numOfTopSpacesToPrint);
		printStatLine(topLandedSpaces);
	}
	
	private void printStatLine(List<SpaceStatistic> topLandedSpaces){
		int rank = 0;
		for(SpaceStatistic topSpace : topLandedSpaces){
			rank ++;
			System.out.print(rank+".  \t"+df.format(topSpace.getSpaceRelFreq()*100) + "%      \t");
			System.out.println(topSpace.getSpaceName() + "   \t");
		}
	}
}
