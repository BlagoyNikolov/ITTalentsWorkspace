package traders.trader;

public class Product {
	private String name;
	private double price;
	
	public double getPrice() {
		return price;
	}
	
	public Product(String name, double price) {
		this.name = name;
		if (price >= 5 && price <= 15) {
			this.price = price;
		}
	}
}
