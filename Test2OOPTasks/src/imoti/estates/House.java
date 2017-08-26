package imoti.estates;

import java.util.Random;

public class House extends Imot {
	private HouseType type;
	private BuildType buildType;
	private int parkoplaces;
	private double lawnArea;
	
	public enum HouseType implements IType {
		ETAJ, CQLA;
	}
	
	public House(String description, String address, double price, int area, HouseType type, BuildType buildType, int parkoplaces, double lawnArea) {
		super(Imot.Category.HOUSE, description, address, price, type, area);
		this.buildType = buildType;
		this.parkoplaces = parkoplaces;
		this.lawnArea = lawnArea;
	}
	
	public HouseType getType() {
		return type;
	}
	
	public BuildType getBuildType() {
		return buildType;
	}
	
	public static HouseType getRandomType() {
		int x = new Random().nextInt(2);
		switch (x) {
		case 0:
			return HouseType.ETAJ;
		case 1:
			return HouseType.CQLA;
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
		return "HOUSE Type: " + this.getType() + " " + this.getBuildType() + " Price: " + this.getPrice() + " Area: " + getArea() + " Seller: " + this.getSeller().getName();
	}
}
