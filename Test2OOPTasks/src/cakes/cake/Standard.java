package cakes.cake;

import java.util.Random;

public class Standard extends Cake implements Comparable<Standard> {
	private boolean isWithSyrop;
	//private StandardCakeType standardCakeType;
	
	public enum StandardCakeType implements IKind {
		BISCUIT, ECLAIRE, FRUIT, CHOCOLATE;
	}
	
	public Standard() {
		super();
		this.type = Cake.Type.STANDARD;
		//this.setRandomKind();
	}
	
	public Standard(double price, int pieces, StandardCakeType standardCakeType) {
		super(Cake.Type.STANDARD, standardCakeType, price, pieces);
	}

	public Standard(String name, String description, double price, int pieces, boolean isWithSyrop, StandardCakeType standardCakeType) {
		super(name, description, price, pieces);
		this.isWithSyrop = isWithSyrop;
		//this.standardCakeType = standardCakeType;
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
	
	public void setRandomKind() {
		int x = new Random().nextInt(4);
		switch (x) {
		case 0:
			this.kind = StandardCakeType.BISCUIT;
			break;
		case 1:
			this.kind = StandardCakeType.ECLAIRE;
			break;
		case 2:
			this.kind = StandardCakeType.FRUIT;
			break;
		case 3:
			this.kind = StandardCakeType.CHOCOLATE;
			break;
		}
	}
	
//	public static Standard getRandomStandardCake() {
//		return new Standard(new Random().nextDouble() * 100 , new Random().nextInt(8) + 1, getRandomStandardCakeType());
//	}

	@Override
	public String toString() {
		return "Standard [isWithSyrop=" + isWithSyrop + ", standardCakeType=" + this.kind + ", price=" + price
				+ "]\n";
	}
	
	@Override
	public int compareTo(Standard o) {
		if (this.getKind().equals(o.getKind())) {
			return Double.compare(o.getPrice(), this.getPrice());
		}
		return Double.compare(o.getPrice(), this.getPrice());
	}
}
