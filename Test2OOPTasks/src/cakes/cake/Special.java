package cakes.cake;

import java.util.Random;

import imoti.estates.Imot;

public class Special extends Cake {
	private String eventName;
	private SpecialCakeType specialCakeType;
	
	private enum SpecialCakeType implements IKind {
		ANNIVERSARY, CORPORATE, PROMOTIONAL;
	}
	
	public Special(double price, int pieces, SpecialCakeType specialCakeType) {
		super(Cake.Type.SPECIAL, specialCakeType, price, pieces);
	}

	public Special(String name, String description, double price, int pieces, String eventName, SpecialCakeType specialCakeType) {
		super(name, description, price, pieces);
		this.eventName = eventName;
		this.specialCakeType = specialCakeType;
	}

	public static SpecialCakeType getRandomSpecialCakeType() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return SpecialCakeType.ANNIVERSARY;
		case 1:
			return SpecialCakeType.CORPORATE;
		case 2:
			return SpecialCakeType.PROMOTIONAL;
		}
		return null;
	}
	
	public static Special getRandomSpecialCake() {
		return new Special(new Random().nextDouble() * 100 , new Random().nextInt(8) + 1, getRandomSpecialCakeType());
	}

	@Override
	public String toString() {
		return "Special [eventName=" + eventName + ", specialCakeType=" + specialCakeType + ", price=" + price + "]\n";
	}
	
	@Override
	public int compareTo(Cake o) {
		return Double.compare(o.getPrice(), this.getPrice());
	}
}
