package imoti.estates;

import java.util.Random;

public class Appartment extends Imot {
	private AppartmentType type;
	private BuildType buildType;
	
	public enum AppartmentType implements IType {
		STUDIO, GARCIONERA, DVUSTAEN, TRISTAEN, MAISONETTE;
	}
	
	public Appartment(String description, String address, double price, int area, AppartmentType type, BuildType buildType) {
		super(Imot.Category.APARTAMENT, description, address, price, type, area);
		this.buildType = buildType;
	}
	
	public IType getAppartmentType() {
		return type;
	}
	
	public BuildType getBuildType() {
		return buildType;
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
	
	public static BuildType getRandomConstructiontype() {
		int x = new Random().nextInt(4);
		switch (x) {
		case 0:
			return BuildType.EPK;
		case 1:
			return BuildType.BRICK;
		case 2:
			return BuildType.PANEL;
		case 3:
			return BuildType.KIRPICH;
		}
		return null;
	}

	@Override
	public String imotInfo() {
		return "APPARTMENT Type: " + this.getAppartmentType() + " " + this.getBuildType() + " Price: " + this.getPrice() + " Area: " + getArea() + " Seller: " + this.getSeller().getName();
	}
}
