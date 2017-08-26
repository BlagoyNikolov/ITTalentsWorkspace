package cakes.cake;

public abstract class Cake implements Comparable<Cake> {
	public enum Type {
		STANDARD, WEDDING, SPECIAL, JUVENILE;
	}

	protected String name;
	protected String description;
	protected double price;
	protected int pieces;
	private Type type;
	private IKind kind;
	
	public Cake(Type type, IKind kind, double price, int pieces) {
		this.type = type;
		this.kind = kind;
		this.price = price;
		this.pieces = pieces;
	}
	
	public Cake(String name, String description, double price, int pieces) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.pieces = pieces;
	}
	
	public Type getType() {
		return type;
	}
	
	public IKind getKind() {
		return kind;
	}
	
	public double getPrice() {
		return price;
	}
	
	//public abstract Cake getRandomCake();
	public abstract String toString();
}
