package cakes.cake;

import java.util.Random;

public class Wedding extends Cake implements Comparable<Wedding> {
	private int numberOfLevels;
	//private WeddingCakeType weddingCakeType;
	
	public enum WeddingCakeType implements IKind {
		BIG, SMALL, MEDIUM;
	}
	
	public Wedding() {
		super();
		this.type = Cake.Type.WEDDING;
		//this.setRandomKind();
	}
	
	public Wedding(double price, int pieces, WeddingCakeType weddingCakeType) {
		super(Cake.Type.WEDDING, weddingCakeType, price, pieces);
	}

	public Wedding(String name, String description, double price, int pieces, int numberOfLevels, WeddingCakeType weddingCakeType) {
		super(name, description, price, pieces);
		this.numberOfLevels = numberOfLevels;
		//this.weddingCakeType = weddingCakeType;
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
	
	public void setRandomKind() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			this.kind = WeddingCakeType.BIG;
			break;
		case 1:
			this.kind = WeddingCakeType.SMALL;
			break;
		case 2:
			this.kind = WeddingCakeType.MEDIUM;
			break;
		}
	}
	
	public static Wedding getRandomWeddingCake() {
		return new Wedding(new Random().nextDouble() * 100 , new Random().nextInt(8) + 1, getRandomWeddingCakeType());
	}

	@Override
	public String toString() {
		return "Wedding [numberOfLevels=" + numberOfLevels + ", weddingCakeType=" + this.kind + ", price=" + price
				+ " Pieces: " + this.pieces + "]\n";
	}
	
	@Override
	public int compareTo(Wedding o) {
		if (this.getKind().equals(o.getKind())) {
			return Double.compare(o.getPrice(), this.getPrice());
		} else {
			if ((this.pieces - o.pieces) != 0) {
				return this.pieces - o.pieces;
			}
		}
		return Double.compare(o.getPrice(), this.getPrice());
	}
}
