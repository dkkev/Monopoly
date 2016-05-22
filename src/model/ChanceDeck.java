package model;

class ChanceDeck extends Deck {

	ChanceDeck(){
		super();
	}
	
	@Override
	protected void addNewCards() { 
		addCard(CardGenerator.addAdvanceToGo());
		addCard(CardGenerator.addAdvanceToIllinoisAve());
		addCard(CardGenerator.addAdvanceToNearestRailroad());
		addCard(CardGenerator.addAdvanceToNearestUtility());
		addCard(CardGenerator.addAdvanceToStCharlesPlace());
		addCard(CardGenerator.addGoBackThreeSpaces());
		addCard(CardGenerator.addGoToJail());
		addCard(CardGenerator.addTakeAWalkOnTheBoardWalk());
		addCard(CardGenerator.addTakeTripOnReadingRailroad());
		
		int totalChanceCards = 16; //info taken from wiki link on challenge page
		int cardsInvolvingMovement = 9;
		for(int i=0; i< totalChanceCards - cardsInvolvingMovement; i++){
			addCard(CardGenerator.addNoMovementCard());
		}
	}
}
