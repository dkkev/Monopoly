package model;

class CommunityChestDeck extends Deck {

	CommunityChestDeck() {
		super();
	}
	
	@Override
	protected void addNewCards() {
		addCard(CardGenerator.addAdvanceToGo());
		addCard(CardGenerator.addGoToJail());
		
		int totalCommunityChestCards = 17; //info taken from wiki link on challenge page
		int cardsInvolvingMovement = 2;
		for(int i=0; i< totalCommunityChestCards - cardsInvolvingMovement; i++){
			addCard(CardGenerator.addNoMovementCard());
		}
	}
}
