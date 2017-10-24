package be.pxl.collections.opdracht1;

import java.util.*;

public class Deck {
	private Deque<Card> cardGame;
	
	public Deck(){
		List<Card> cards= new ArrayList<>(52);
	
	    for (Color color: Color.values()){
	    	 for (Value value: Value.values()){
	    		 cards.add(new Card(color, value));
	    	 }       
	    }
	    Collections.shuffle(cards);
	    cardGame = new ArrayDeque<>(cards);
	}
	
	public int getDeckSize(){
		return cardGame.size();
	}
	
	public Card dealCard(){
		return cardGame.pollLast();
	}

}
