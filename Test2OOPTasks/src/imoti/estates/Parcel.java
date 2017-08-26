package imoti.estates;

import java.util.Random;

public class Parcel extends Imot {
	ParcelType type;
	private boolean isInRegulation;
	
	public enum ParcelType implements IType {
		NIVA, POLQNA, GORA;
	}
	
	public Parcel(String description, String address, double price, int area, ParcelType type, boolean isInRegulation) {
		super(Imot.Category.PARCEL, description, address, price, type, area);
		this.isInRegulation = isInRegulation;
	}
	
	public ParcelType getType() {
		return type;
	}
	
	public static ParcelType getRandomType() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return ParcelType.NIVA;
		case 1:
			return ParcelType.POLQNA;
		case 2:
			return ParcelType.GORA;
		}
		return null;
	}
	
	@Override
	public String imotInfo() {
		return "PARCEL Type: " + this.getType() + " Price " + this.getPrice() + " Area " + this.getArea() + " Seller: " + this.getSeller().getName();
	}
}
