package warehouse;

import java.util.Random;

public class Client {
	private String name;
	private Shop shop;
	
	public Shop getShop() {
		return shop;
	}
	
	public Client(String name, Shop shop) {
		this.name = name;
		this.shop = shop;
	}
	
	public void buyProducts() {
		for (int i = 0; i < new Random().nextInt(4) + 1; i++) {
			Product p = this.getShop().getRandomProduct();
			for (Product product : this.getShop().getProducts()) {
				if (product.getName().equals(p.getName())) {
					product.setAvailability(product.getAvailability() - 1);
					System.out.println("Bought " + product.getName());
				}
			}
		}
	}
}
