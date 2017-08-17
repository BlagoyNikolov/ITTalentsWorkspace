package cakes.cake;

public abstract class Cake {
	protected String name;
	protected String description;
	protected double price;
	protected int pieces;
	
	public double getPrice() {
		return price;
	}
	
	public Cake(double price, int pieces) {
		this.price = price;
		this.pieces = pieces;
	}
	
	public Cake(String name, String description, double price, int pieces) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.pieces = pieces;
	}
	
	//public abstract Cake getRandomCake();
	public abstract String toString();
}
