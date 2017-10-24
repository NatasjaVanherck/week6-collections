package be.pxl.collections.opdracht1;

import java.util.*;

public class Hand {
	private SortedSet<Card> cards = new TreeSet<>(Comparator
						.comparingInt((Card c) -> c.getColor().getOrder())
						.thenComparingInt((Card c) -> c.getValue().getOrder()));
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public String showHand(){
		String output = cards.stream()
							 .map(s -> s.getColor().toString() + s.getValue().toString())
							 .reduce("", (acc, el) -> acc + el);
		return output;
	}
	
	public boolean hasColor(Color color){
		 long aantal = cards.stream().filter(s -> (s.getColor().getOrder() == color.getOrder()))
				 .count();
		 
		 if(aantal > 1){
			 return true;
		 } else {
			 return false;
		 }
	}
	
	
	
	
}
