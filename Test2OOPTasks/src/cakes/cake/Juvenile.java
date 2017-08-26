package cakes.cake;

import java.util.Random;

public class Juvenile extends Cake {
	private String childName;
	private JuvenileCakeType juvenileCakeType;
	
	private enum JuvenileCakeType implements IKind {
		BIRTHDAY, CHRISTENRY, PROSHTAPULNIK;
	}
	
	public Juvenile(double price, int pieces, JuvenileCakeType juvenileCakeType) {
		super(Cake.Type.JUVENILE, juvenileCakeType, price, pieces);
	}

	public Juvenile(String name, String description, double price, int pieces, String childName, JuvenileCakeType juvenileCakeType) {
		super(name, description, price, pieces);
		this.childName = childName;
		this.juvenileCakeType = juvenileCakeType;
	}
	
	public JuvenileCakeType getJuvenileCakeType() {
		return juvenileCakeType;
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
		return "Juvenile [childName=" + childName + ", juvenileCakeType=" + juvenileCakeType + ", price=" + price
				+ ", pieces=" + pieces + "]\n";
	}

	@Override
	public int compareTo(Cake o) {
		if (o instanceof Juvenile) {
			return this.pieces - o.pieces;
		}
		return Double.compare(o.getPrice(), this.getPrice());
	}
}
