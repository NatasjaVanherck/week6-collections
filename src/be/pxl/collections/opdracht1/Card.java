package be.pxl.collections.opdracht1;

public class Card {
	private Color color;
	private Value value;
	
	public Card(Color color, Value value){
		this.color = color;
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public Value getValue() {
		return value;
	}

	public int compareTo(Card c2) {
		if(this.color.compareTo(c2.color) == 0){
			if(this.value.compareTo(c2.value) < 0){
				return -1;
			} else{
				return 1;
			}
		} else {
			if (this.color.compareTo(c2.color) > 0){
				return 1;
			} else {
				return -1;
			}
		}
	}
}
