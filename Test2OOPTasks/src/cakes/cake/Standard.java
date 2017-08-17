package cakes.cake;

import java.util.Random;

public class Standard extends Cake {
	private boolean isWithSyrop;
	private StandardCakeType standardCakeType;
	
	public enum StandardCakeType {
		BISCUIT, ECLAIRE, FRUIT, CHOCOLATE;
	}
	
	public Standard(double price, int pieces, StandardCakeType standardCakeType) {
		super(price, pieces);
		this.standardCakeType = standardCakeType;
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
}
