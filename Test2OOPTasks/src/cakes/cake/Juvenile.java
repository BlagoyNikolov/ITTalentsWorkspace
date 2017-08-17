package cakes.cake;

import java.util.Random;

public class Juvenile extends Cake {
	private String childName;
	private JuvenileCakeType juvenileCakeType;
	
	private enum JuvenileCakeType {
		BIRTHDAY, CHRISTENRY, PROSHTAPULNIK;
	}
	
	public Juvenile(double price, int pieces, JuvenileCakeType juvenileCakeType) {
		super(price, pieces);
		this.juvenileCakeType = juvenileCakeType;
	}

	public Juvenile(String name, String description, double price, int pieces, String childName, JuvenileCakeType juvenileCakeType) {
		super(name, description, price, pieces);
		this.childName = childName;
		this.juvenileCakeType = juvenileCakeType;
	}
	
	public static JuvenileCakeType getRandomJuvenileCakeType() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return JuvenileCakeType.BIRTHDAY;
		case 1:
			return JuvenileCakeType.CHRISTENRY;
		case 2:
			return JuvenileCakeType.PROSHTAPULNIK;
		}
		return null;
	}
	
	public static Juvenile getRandomJuvenileCake() {
		return new Juvenile(new Random().nextDouble() * 100 , new Random().nextInt(8) + 1, getRandomJuvenileCakeType());
	}

	@Override
	public String toString() {
		return "Juvenile [childName=" + childName + ", juvenileCakeType=" + juvenileCakeType + ", price=" + price + "]\n";
	}
}
