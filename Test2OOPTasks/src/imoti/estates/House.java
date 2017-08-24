package imoti.estates;

import java.util.Random;

import imoti.estates.Appartment.AppartmentType;
import imoti.estates.Appartment.ConstructionType;

public class House extends Imot {
	private HouseType type;
	private ConstructionType constructionType;
	private int parkoplaces;
	private double lawnArea;
	
	public enum HouseType {
		ETAJ, CQLA;
	}
	
	public enum ConstructionType {
		EPK, BRICK, PANEL, KIRPICH;
	}
	
	public HouseType getType() {
		return type;
	}
	
	public ConstructionType getConstructionType() {
		return constructionType;
	}
	
	public House(String description, String address, double price, int area, HouseType type, ConstructionType constructionType, int parkoplaces, double lawnArea) {
		super(description, address, price, area);
		this.type = type;
		this.constructionType = constructionType;
		this.parkoplaces = parkoplaces;
		this.lawnArea = lawnArea;
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
