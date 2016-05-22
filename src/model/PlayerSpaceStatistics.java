package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerSpaceStatistics {

	private final List<SpaceStatistic> spaceStatistics;
	private int totalNumSpacesLandedOn;
	
	PlayerSpaceStatistics() {
		spaceStatistics = new ArrayList<>(Space.values().length);
		totalNumSpacesLandedOn = 0;
		
		for(Space space : Space.values()){
			add(space);
		}
	}
	
	final List<SpaceStatistic> getSpaceStatistics(){
		return spaceStatistics;
	}
	
	private void add(Space space){
		spaceStatistics.add(new SpaceStatistic(space));
	}
	
	void increaseCounter(int spaceNum){
		totalNumSpacesLandedOn = totalNumSpacesLandedOn + 1;
		if(spaceStatistics.get(spaceNum).getSpaceNum() == spaceNum){ //this should always be true before sorting
			spaceStatistics.get(spaceNum).increaseCounter();
		}
	}
	
	void makeFinalCalculations(){
		calculateRelFrequencies();
		sort();
	}
	
	private void calculateRelFrequencies(){
		for(SpaceStatistic spaceStatistic : spaceStatistics){
			spaceStatistic.setRelFreq(totalNumSpacesLandedOn);
		}
	}
	
	private void sort(){
		Collections.sort(spaceStatistics, new SpaceStatisticComparator());
	}
	
	public List<SpaceStatistic> getTopLandedSpaces(int numOfSpacesToReturn){
		List<SpaceStatistic> returnList = new ArrayList<>(numOfSpacesToReturn);
		for(int i = 0; i<numOfSpacesToReturn; i++){
			returnList.add(spaceStatistics.get(i));
		}
		return returnList;
	}	
}
