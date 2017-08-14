package warehouse;

import java.util.ArrayList;

public class Warehouse extends ProductContainer {
	private String name;
	
	@Override
	public ArrayList<Product> getProducts() {
		return super.getProducts();
	}
	
	public Warehouse(String name) {
		this.name = name;
	}
	
	public void fillWarehouse() {
		for (Product product : this.getProducts()) {
			if (product.getAvailability() < 10) {
				product.setAvailability(product.getAvailability() + 25);
			}
		}
	}
	
	public int giveProducts(String name) {
//		ArrayList<Product> products = new ArrayList<>();
		for (Product product : this.getProducts()) {
			if (product.getName().equals(name)) {
//				for (int i = 0; i < 5; i++) {
//					products.add(product);
//				}
				product.setAvailability(product.getAvailability() - 5);
			}
		}
		return 5;
	}
}
