package model;

class CardGenerator {

	static final Card addNoMovementCard(){
		return new Card(CardType.NO_MOVEMENT);
	}
	
	private static final Card addMoveToCard(Space space){
		return new Card(CardType.MOVE_TO, space.getSpaceNum());
	}
	
	static final Card addAdvanceToGo(){ //in both decks
		return new Card(CardType.MOVE_TO, Space.GO.getSpaceNum());
	}
	
	static final Card addGoToJail(){ //in both decks
		return addMoveToCard(Space.JAIL);
	}
	
	static final Card addAdvanceToIllinoisAve(){ //in chance
		return addMoveToCard(Space.ILLINOIS_AVENUE);
	}
	
	static final Card addAdvanceToStCharlesPlace(){ //in chance
		return addMoveToCard(Space.ST_CHARLES_PLACE);
	}
	
	static final Card addTakeTripOnReadingRailroad(){ //in chance
		return addMoveToCard(Space.READING_RAILROAD);
	}
	
	static final Card addTakeAWalkOnTheBoardWalk(){ //in chance
		return addMoveToCard(Space.BOARDWALK);
	}
	
	static final Card addGoBackThreeSpaces(){ //in chance
		return new Card(CardType.MOVE_BACK, -3);
	}
	
	static final Card getOutOfJailFree(){ //in both
		return new Card(CardType.GET_OUT_OF_JAIL_FREE);
	}
	
	static final Card addAdvanceToNearestUtility(){ //in chance
		return new Card(CardType.ADVANCE_TO_NEAREST_UTILITY);
	}
	
	static final Card addAdvanceToNearestRailroad(){ //in chance
		return new Card(CardType.ADVANCE_TO_NEAREST_RAILROAD);
	}
}
