package shop;

public class Broika extends Product {
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Broika(String name, double price, int quantity) {
		super(name, price);
		this.quantity = quantity;
	}

}
