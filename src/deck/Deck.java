package deck;

import javafx.scene.image.ImageView;

public class Deck{
	
	private int suit; //[0, 3]
	private int value; //[0, 12]
	private ImageView container; //ImageView

	public Deck() {
	}
	
	public Deck(int suit, int value, ImageView container) {
		this.suit = suit;
		this.value = value;
		this.container = container;
	}
	
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ImageView getContainer() {
		return container;
	}
	public void setContainer(ImageView container) {
		this.container = container;
	}
}
