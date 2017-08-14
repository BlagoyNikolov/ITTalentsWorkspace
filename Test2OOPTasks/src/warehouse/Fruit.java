package warehouse;

public class Fruit extends Product {
	public enum FruitType {
		Banana, Orange, Apple;
	}
	
	FruitType fruitType;

	public Fruit(String name, int availability, FruitType type) {
		super(name, availability);
		this.fruitType = type; 
	}

}
