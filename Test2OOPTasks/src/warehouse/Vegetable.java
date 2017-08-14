package warehouse;

public class Vegetable extends Product {
	public enum VegetableType {
		Potato, Eggplant, Cucumber;
	}
	
	VegetableType vegetableType;

	public Vegetable(String name, int availability, VegetableType type) {
		super(name, availability);
		this.vegetableType = type; 
	}

}
