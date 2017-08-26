package imoti.estates;

import java.util.Random;

public class Parcel extends Imot {
	private boolean isInRegulation;
	
	public enum ParcelType implements IType {
		NIVA, POLQNA, GORA;
	}
	
	public Parcel(String description, String address) {
		super(Imot.Category.PARCEL, description, address);
		this.setPrice(55000 * new Random().nextDouble() + 30000);
		this.setArea(new Random().nextInt(200) + 50);
		this.setInRegulation(new Random().nextBoolean());
		this.setRandomKind();
	}
	
	public void setRandomKind() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			this.type = ParcelType.NIVA;
			break;
		case 1:
			this.type = ParcelType.POLQNA;
			break;
		case 2:
			this.type = ParcelType.GORA;
			break;
		}
	}
	
	public IType getType() {
		return type;
	}
	
	@Override
	public void setPrice(double price) {
		super.setPrice(price);
	}
	
	@Override
	public void setArea(int area) {
		super.setArea(area);
	}
	
	public void setInRegulation(boolean isInRegulation) {
		this.isInRegulation = isInRegulation;
	}
	
	@Override
	public String imotInfo() {
		return "PARCEL Type: " + this.getType() + " Price " + this.getPrice() + " Area " + this.getArea() + " Is in regulation: "+ this.isInRegulation + " Seller: " + this.getSeller().getName();
	}
}
