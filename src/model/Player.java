package model;

import java.util.Random;

public class Player {
	
	private int position; //tracks what board space number the player is on
	private int doublesRolledInARow;
	private boolean inJail;
	private int consecutiveTurnsInJail;
	
	private final PlayerSpaceStatistics mySpaceStatistics; 
	
	Player(){
		mySpaceStatistics = new PlayerSpaceStatistics();
		position = Space.GO.getSpaceNum();
		doublesRolledInARow = 0;
		inJail = false;
		consecutiveTurnsInJail = 0;
	}
	
	void move(int numOfSpaces){
		position = position + numOfSpaces;
		if(position > 39){
			position = position%40;
		}
		updateSpaceStatistics();
	}
	
	void moveTo(int spaceNumber){
		position = spaceNumber;
		updateSpaceStatistics();
	}
	
	void moveTo(Space space){
		moveTo(space.getSpaceNum());
	}
	
	static int[] rollDice(){
		Random rand = new Random();
		int die1 = (rand.nextInt(6)+1);
		int die2 = (rand.nextInt(6)+1);		
		int[] dieNums = {die1, die2};
		return dieNums;
	}
	
	void rolledDoubles(){
		doublesRolledInARow++;
	}
	
	final int getDoublesRolledInARow(){
		return doublesRolledInARow;
	}
	
	void resetDoublesRolledInARow(){
		doublesRolledInARow = 0;
	}
	
	//return true if card impacts movement
	boolean drawCard(Card card){
		return reactToCard(card);
	}
	
	//return true if card impacts movement
	private boolean reactToCard(Card card){
		if(card.getCardType() == CardType.MOVE_TO){
			moveTo(card.getMoveNum());
			return true;
		}else if(card.getCardType() == CardType.MOVE_BACK){
			move(card.getMoveNum());
			return true;
		}else if(card.getCardType() == CardType.ADVANCE_TO_NEAREST_UTILITY){
			if(getPosition() < Space.ELECTRIC_COMPANY.getSpaceNum()){
				moveTo(Space.ELECTRIC_COMPANY);
			}else if(getPosition() < Space.WATER_WORKS.getSpaceNum()){
				moveTo(Space.WATER_WORKS);
			}else if(getPosition() < Space.BOARDWALK.getSpaceNum()){ //this covers the case where the player is past water works but before Go
				moveTo(Space.ELECTRIC_COMPANY);		
			}
			return true;
		}else if(card.getCardType() == CardType.ADVANCE_TO_NEAREST_RAILROAD){
			if(getPosition() < Space.READING_RAILROAD.getSpaceNum()){
				moveTo(Space.READING_RAILROAD);
			}else if(getPosition() < Space.PENNSYLVANIA_RAILROAD.getSpaceNum()){
				moveTo(Space.PENNSYLVANIA_RAILROAD);
			}else if(getPosition() < Space.BO_RAILROAD.getSpaceNum()){
				moveTo(Space.BO_RAILROAD);
			}else if(getPosition() <Space.SHORT_LINE.getSpaceNum()){
				moveTo(Space.SHORT_LINE);
			}else if(getPosition() <= Space.BOARDWALK.getSpaceNum()) //this covers the case where player is past short line but before Go
				moveTo(Space.READING_RAILROAD);
			return true;
		}else{ //only remaining option is that card doesn't impact movement
			return false;
		}
	}

	boolean landedOnCommunityChest(){
		if(position == Space.FIRST_COMMUNITY_CHEST.getSpaceNum() ||
		   position == Space.SECOND_COMMUNITY_CHEST.getSpaceNum() ||
		   position == Space.THIRD_COMMUNITY_CHEST.getSpaceNum())
		{
			return true;
		}else{
			return false;
		}
	}
	
	boolean landedOnChance(){
		if(position == Space.FIRST_CHANCE.getSpaceNum() ||
		   position == Space.SECOND_CHANCE.getSpaceNum() ||
		   position == Space.THIRD_CHANCE.getSpaceNum())
		{
			return true;
		}else{
			return false;
		}
	}
	
	boolean landedOnGoToJail(){
		if(position == Space.GO_TO_JAIL.getSpaceNum()){
			return true;
		}else{
			return false;
		}
	}
	
	void goToJail(){
		moveTo(Space.JAIL);
		inJail = true;
	}
	
	void escapeJail(){
		inJail = false;
		consecutiveTurnsInJail = 0;
	}
	
	final boolean isInJail(){
		return inJail;
	}
	
	final int getPosition(){
		return position;
	}
	
	private void updateSpaceStatistics(){
		mySpaceStatistics.increaseCounter(position);
	}

	final int getConsecutiveTurnsInJail() {
		return consecutiveTurnsInJail;
	}

	void anotherTurnInJail() {
		consecutiveTurnsInJail++;
		updateSpaceStatistics();
	}
	
	final public PlayerSpaceStatistics getSpaceStatistics(){
		return mySpaceStatistics;
	}
	
	void calculateEndGameStats(){
		mySpaceStatistics.makeFinalCalculations();
	}
}
