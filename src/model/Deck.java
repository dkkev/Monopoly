package model;

import java.util.Collections;
import java.util.LinkedList;

abstract class Deck {

	protected LinkedList<Card> deck;
	
	Deck(){
		deck = new LinkedList<>();
		addNewCards();
		Collections.shuffle(deck);
	}
	
	protected abstract void addNewCards();
	
	protected void addCard(Card card){
		deck.add(card);
	}
	
	Card getTopCard(){
		Card card = deck.pollFirst();
		deck.addLast(card);
		return card;
	}	
}
