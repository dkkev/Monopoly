package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private final int numOfRounds;
	private List<Player> players;
	private final int chancePlayerPaysOutOfJail;
	private final ChanceDeck chanceDeck;
	private final CommunityChestDeck communityChestDeck;
	private final PlayerSpaceStatistics overallGameStatistics;
	
	public Board(int numOfRounds, int numOfPlayers, int chancePlayerPaysOutOfJail){
		if(numOfRounds<1) numOfRounds = 1;
		this.numOfRounds = numOfRounds;
		
		this.chancePlayerPaysOutOfJail = chancePlayerPaysOutOfJail;
		chanceDeck = new ChanceDeck();
		communityChestDeck = new CommunityChestDeck();
		overallGameStatistics = new PlayerSpaceStatistics();
		
		if(numOfPlayers<2) numOfPlayers = 2;
		if(numOfPlayers>8) numOfPlayers = 8;
		addNewPlayers(numOfPlayers);
				
		conductSimulation();
	}
	
	private void conductSimulation(){
		for(int i = 0; i<numOfRounds; i++){
			runRound();
		}
		
		for(Player player : players){
			player.calculateEndGameStats();
		}
		
		overallGameStatistics.makeFinalCalculations();
	}
	
	private final void addNewPlayers(int numOfPlayers){
		players = new ArrayList<>(numOfPlayers);
		for(int i = 0; i<numOfPlayers; i++){
			players.add(new Player());
		}
	}
	
	private final void runRound(){
		for(Player player : players){
			runTurn(player);
		}
	}

	private void runTurn(Player player){
		
		//a player who gets out of jail by rolling doubles doesn't get an extra roll
		boolean extraTurnIfDoublesRolled = true; 
		
		if(player.isInJail()){
			if(Math.random()*100 <= ((double)chancePlayerPaysOutOfJail)){ 
				player.escapeJail(); 
			}
		}
		
		int[] dice = Player.rollDice();
		int diceSum = dice[0]+dice[1];
		
		if(player.isInJail()){
			//if doubles rolled and in jail, get out free
			//or, if doubles not rolled and third turn in jail, get out after rolling
			//otherwise, player stays in jail
			if(dice[0]==dice[1] ||  player.getConsecutiveTurnsInJail() == 2){ 
				player.escapeJail();
				extraTurnIfDoublesRolled = false;
			}else{
				player.anotherTurnInJail();
				updateBoardStatistics(player.getPosition());
			}
		}
		
		if(player.isInJail()==false){
			
			player.move(diceSum);
			updateBoardStatistics(player.getPosition());
			
			if(player.landedOnCommunityChest() || player.landedOnChance()){
				if(player.landedOnCommunityChest()){
					//update board stats if player movement impacted
					if(player.drawCard(communityChestDeck.getTopCard())==true){ 
						updateBoardStatistics(player.getPosition());
					}
				}else{ //player landed on chance
					if(player.drawCard(chanceDeck.getTopCard())==true){
						updateBoardStatistics(player.getPosition());
					}
				}
			}
			
			if(player.landedOnGoToJail()){
				player.goToJail();
				updateBoardStatistics(player.getPosition());
			}else if((dice[0] == dice[1]) && extraTurnIfDoublesRolled == true){
				player.rolledDoubles();
				if(player.getDoublesRolledInARow()<=2){
					runTurn(player);
				}else{
					player.goToJail();
					updateBoardStatistics(player.getPosition());
					player.resetDoublesRolledInARow();
				}
			}				
		}
	}
	
	//Call this method whenever a player's position on the board changes
	private void updateBoardStatistics(int newPlayerSpaceNum){
		overallGameStatistics.increaseCounter(newPlayerSpaceNum);
	}

	public final PlayerSpaceStatistics getOverallGameStatistics(){
		return overallGameStatistics;
	}
	
	public final List<Player> getPlayers(){
		return players;	
	}
}
