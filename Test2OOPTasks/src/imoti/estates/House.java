package imoti.estates;

import java.util.Random;

public class House extends Imot {
	private BuildType buildType;
	private int parkoplaces;
	private double lawnArea;
	
	public enum HouseType implements IType {
		ETAJ, CQLA;
	}
	
	public House(String description, String address, BuildType buildType) {
		super(Imot.Category.HOUSE, description, address);
		this.buildType = buildType;
		this.setPrice(30000 * new Random().nextDouble() + 50000);
		this.setArea(new Random().nextInt(300) + 100);
		this.setParkoplaces(new Random().nextInt(3) + 1);
		this.setLawnArea(30 * new Random().nextDouble());
		this.setRandomKind();
	}
	
	public void setRandomKind() {
		int x = new Random().nextInt(2);
		switch (x) {
		case 0:
			this.type = HouseType.ETAJ;
			break;
		case 1:
			this.type = HouseType.CQLA;
			break;
		}
	}
	
	public IType getType() {
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
	
	public void setParkoplaces(int parkoplaces) {
		this.parkoplaces = parkoplaces;
	}
	
	public void setLawnArea(double lawnArea) {
		this.lawnArea = lawnArea;
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
		return "HOUSE Type: " + this.getType() + " " + this.getBuildType() + " Price: " + this.getPrice() + " Area: " + getArea() + " ParkoPlaces: " + this.parkoplaces + " Lawn area: " + this.lawnArea + " Seller: " + this.getSeller().getName();
	}
}
