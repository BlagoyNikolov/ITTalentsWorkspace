package imoti.estates;

import java.util.Random;

public class Appartment extends Imot {
	private AppartmentType type;
	private ConstructionType constructionType;
	
	public enum AppartmentType {
		STUDIO, GARCIONERA, DVUSTAEN, TRISTAEN, MAISONETTE;
	}
	
	public enum ConstructionType {
		EPK, BRICK, PANEL, KIRPICH;
	}
	
	public AppartmentType getType() {
		return type;
	}
	
	public ConstructionType getConstructionType() {
		return constructionType;
	}
	
	public Appartment(String description, String address, double price, int area, AppartmentType type, ConstructionType constructionType) {
		super(description, address, price, area);
		this.type = type;
		this.constructionType = constructionType;
	}

	public static AppartmentType getRandomType() {
		int x = new Random().nextInt(5);
		switch (x) {
		case 0:
			return AppartmentType.STUDIO;
		case 1:
			return AppartmentType.GARCIONERA;
		case 2:
			return AppartmentType.DVUSTAEN;
		case 3:
			return AppartmentType.TRISTAEN;
		case 4:
			return AppartmentType.MAISONETTE;
		}
		return null;
	}
	
	public static ConstructionType getRandomConstructiontype() {
		int x = new Random().nextInt(4);
		switch (x) {
		case 0:
			return ConstructionType.EPK;
		case 1:
			return ConstructionType.BRICK;
		case 2:
			return ConstructionType.PANEL;
		case 3:
			return ConstructionType.KIRPICH;
		}
		return null;
	}

	@Override
	public String imotInfo() {
		return "Type: " + this.getType() + " " + this.getConstructionType() + " Price: " + this.getPrice() + " Area: " + getArea() + " Seller: " + this.getSeller().getName();
	}
}
