package model;

public class SpaceStatistic {

	private final int spaceNum;
	private int spaceCounter;
	private double spaceRelFreq;
	private final Space space;
	
	SpaceStatistic(Space space){
		this.space = space;
		spaceNum = space.getSpaceNum();
		spaceCounter = 0;
	}
	
	void increaseCounter(){
		spaceCounter++;
	}
	
	void setRelFreq(int totalNumSpacesLandedOn){
		spaceRelFreq = ((double)spaceCounter) / ((double)totalNumSpacesLandedOn);
	}
	
	public final double getSpaceRelFreq(){
		return spaceRelFreq;
	}
	
	final int getSpaceNum(){
		return spaceNum;
	}
	
	public final String getSpaceName(){
		return space.getSpaceName();
	}
}
