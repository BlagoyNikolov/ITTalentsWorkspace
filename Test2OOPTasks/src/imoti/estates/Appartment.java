package imoti.estates;

import java.util.Random;

public class Appartment extends Imot {
	private BuildType buildType;
	
	public enum AppartmentType implements IType {
		STUDIO, GARCIONERA, DVUSTAEN, TRISTAEN, MAISONETTE;
	}
	
	public Appartment(String description, String address, BuildType buildType) {
		super(Imot.Category.APARTAMENT, description, address);
		this.buildType = buildType;
		this.setPrice(80000 * new Random().nextDouble() + 70000);
		this.setArea(new Random().nextInt(200) + 50);
		this.setRandomKind();
	}
	
	public void setRandomKind() {
		int x = new Random().nextInt(5);
		switch (x) {
		case 0:
			this.type = AppartmentType.STUDIO;
			break;
		case 1:
			this.type = AppartmentType.GARCIONERA;
			break;
		case 2:
			this.type = AppartmentType.DVUSTAEN;
			break;
		case 3:
			this.type = AppartmentType.TRISTAEN;
			break;
		case 4:
			this.type = AppartmentType.MAISONETTE;
			break;
		}
	}
	
	public IType getAppartmentType() {
		return type;
	}
	
	public BuildType getBuildType() {
		return buildType;
	}
	
	@Override
	public void setPrice(double price) {
		super.setPrice(price);
	}
	
	@Override
	public void setArea(int area) {
		super.setArea(area);
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
