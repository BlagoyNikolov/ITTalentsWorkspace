package imoti;

public class Parcel extends Imot {
	private boolean isInRegulation;
	
	public Parcel(String description, String address, double price, int area, boolean isInRegulation) {
		super(description, address, price, area);
		this.isInRegulation = isInRegulation;
	}
	
	@Override
	public String imotInfo() {
		return "Type: Parcel Price: " + this.getPrice() + " Area " + this.getArea() + " Seller: " + this.getSeller().getName();
	}
}
