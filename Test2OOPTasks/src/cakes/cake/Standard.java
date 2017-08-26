package cakes.cake;

import java.util.Random;

import imoti.estates.Imot;

public class Standard extends Cake {
	private boolean isWithSyrop;
	private StandardCakeType standardCakeType;
	
	public enum StandardCakeType implements IKind {
		BISCUIT, ECLAIRE, FRUIT, CHOCOLATE;
	}
	
	public Standard(double price, int pieces, StandardCakeType standardCakeType) {
		super(Cake.Type.STANDARD, standardCakeType, price, pieces);
	}

	public Standard(String name, String description, double price, int pieces, boolean isWithSyrop, StandardCakeType standardCakeType) {
		super(name, description, price, pieces);
		this.isWithSyrop = isWithSyrop;
		this.standardCakeType = standardCakeType;
	}

	public static StandardCakeType getRandomStandardCakeType() {
		int x = new Random().nextInt(4);
		switch (x) {
		case 0:
			return StandardCakeType.BISCUIT;
		case 1:
			return StandardCakeType.ECLAIRE;
		case 2:
			return StandardCakeType.FRUIT;
		case 3:
			return StandardCakeType.CHOCOLATE;
		}
		return null;
	}
	
	public static Standard getRandomStandardCake() {
		return new Standard(new Random().nextDouble() * 100 , new Random().nextInt(8) + 1, getRandomStandardCakeType());
	}

	@Override
	public String toString() {
		return "Standard [isWithSyrop=" + isWithSyrop + ", standardCakeType=" + standardCakeType + ", price=" + price
				+ "]\n";
	}
	
	@Override
	public int compareTo(Cake o) {
		return Double.compare(o.getPrice(), this.getPrice());
	}
}
