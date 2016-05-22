package model;

class Card {
	private final CardType cardType;
	private final int moveNum;
	
	Card(CardType cardType){
		this.cardType = cardType;
		this.moveNum = 0;
	}	
	
	Card(CardType cardType, int moveNum){
		this.cardType = cardType;
		if(cardType == CardType.MOVE_BACK || cardType == CardType.MOVE_TO){
			this.moveNum = moveNum;
		}else{
			this.moveNum = 0;
		}
	}
	
	final CardType getCardType(){
		return cardType;
	}
	
	final int getMoveNum(){
		return moveNum;
	}
}

