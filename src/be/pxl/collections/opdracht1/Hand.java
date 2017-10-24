package be.pxl.collections.opdracht1;

import java.util.*;

public class Hand {
	private Deck deck = new Deck();
	private SortedSet<Card> cards = new TreeSet<>(Comparator
						.comparingInt((Card c) -> c.getColor().getOrder())
						.thenComparingInt((Card c) -> c.getValue().getOrder()));
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public void showHand(){
		
	}
	
	
}
