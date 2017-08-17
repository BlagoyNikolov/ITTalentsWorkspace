package cakes.cake;

import java.util.Random;

public class Wedding extends Cake{
	private int numberOfLevels;
	private WeddingCakeType weddingCakeType;
	
	public enum WeddingCakeType {
		BIG, SMALL, MEDIUM;
	}
	
	public Wedding(double price, int pieces, WeddingCakeType weddingCakeType) {
		super(price, pieces);
		this.weddingCakeType = weddingCakeType;
	}

	public Wedding(String name, String description, double price, int pieces, int numberOfLevels, WeddingCakeType weddingCakeType) {
		super(name, description, price, pieces);
		this.numberOfLevels = numberOfLevels;
		this.weddingCakeType = weddingCakeType;
	}

	public static WeddingCakeType getRandomWeddingCakeType() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return WeddingCakeType.BIG;
		case 1:
			return WeddingCakeType.SMALL;
		case 2:
			return WeddingCakeType.MEDIUM;
		}
		return null;
	}
	
	public static Wedding getRandomWeddingCake() {
		return new Wedding(new Random().nextDouble() * 100 , new Random().nextInt(8) + 1, getRandomWeddingCakeType());
	}

	@Override
	public String toString() {
		return "Wedding [numberOfLevels=" + numberOfLevels + ", weddingCakeType=" + weddingCakeType + ", price=" + price
				+ "]\n";
	}
}
