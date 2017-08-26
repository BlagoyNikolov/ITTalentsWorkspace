package cakes.cake;

import java.util.Random;

public abstract class Cake /*implements Comparable<Cake>*/ {
	public enum Type {
		STANDARD, WEDDING, SPECIAL, JUVENILE;
	}

	protected String name;
	protected String description;
	protected double price;
	protected int pieces;
	protected Type type;
	protected IKind kind;
	
	public Cake() {
		this.setPrice(new Random().nextDouble() * 100);
		this.setPieces(new Random().nextInt(8) + 1);
		this.setRandomKind();
	}
	
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
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	public void setKind(IKind kind) {
		this.kind = kind;
	}

	//public abstract Cake getRandomCake();
	public abstract String toString();
	public abstract void setRandomKind();
}
