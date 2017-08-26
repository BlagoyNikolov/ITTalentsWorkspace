package cakes.cake;

import java.util.Random;

public class Juvenile extends Cake implements Comparable<Juvenile> {
	private String childName;
	//private JuvenileCakeType juvenileCakeType;
	
	public enum JuvenileCakeType implements IKind {
		BIRTHDAY, CHRISTENRY, PROSHTAPULNIK;
	}
	
	public Juvenile() {
		super();
		this.type = Cake.Type.JUVENILE;
		//this.setRandomKind();
	}
	
	public Juvenile(double price, int pieces, JuvenileCakeType juvenileCakeType) {
		super(Cake.Type.JUVENILE, juvenileCakeType, price, pieces);
	}

	public Juvenile(String name, String description, double price, int pieces, String childName, JuvenileCakeType juvenileCakeType) {
		super(name, description, price, pieces);
		this.childName = childName;
		//this.juvenileCakeType = juvenileCakeType;
	}
	
//	public JuvenileCakeType getJuvenileCakeType() {
//		return juvenileCakeType;
//	}
	
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
	
	public void setRandomKind() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			this.kind = JuvenileCakeType.BIRTHDAY;
			break;
		case 1:
			this.kind = JuvenileCakeType.CHRISTENRY;
			break;
		case 2:
			this.kind = JuvenileCakeType.PROSHTAPULNIK;
			break;
		}
	}

	@Override
	public String toString() {
		return "Juvenile [childName=" + childName + ", juvenileCakeType=" + this.kind + ", price=" + price
				+ ", pieces=" + pieces + "]\n";
	}

	@Override
	public int compareTo(Juvenile o) {
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
