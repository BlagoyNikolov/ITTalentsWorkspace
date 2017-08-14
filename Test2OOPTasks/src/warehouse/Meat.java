package warehouse;

public class Meat extends Product {
	public enum MeatType {
		Pork, Beef, Chicken;
	}
	
	MeatType meatType;

	public Meat(String name, int availability, MeatType type) {
		super(name, availability);
		this.meatType = type; 
	}

}
