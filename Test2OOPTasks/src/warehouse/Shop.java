package warehouse;

import java.util.ArrayList;
import java.util.Random;

public class Shop extends ProductContainer {
	private String name;
	private Warehouse warehouse;
	private ArrayList<Client> clients;
	
	@Override
	public ArrayList<Product> getProducts() {
		return super.getProducts();
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	public ArrayList<Client> getClients() {
		return clients;
	}
	
	public Shop(String name, Warehouse warehouse) {
		this.clients = new ArrayList<Client>();
		this.name = name;
		this.warehouse = warehouse;
	}
	
	public void fillShop() {
		for (Product product : this.getProducts()) {
			if (product.getAvailability() < 10) {
				product.setAvailability(product.getAvailability() + this.getWarehouse().giveProducts(product.getName()));
			}
		}
	}
	
	public Product getRandomProduct() {
		int index = new Random().nextInt(this.getProducts().size() - 1);
		return this.getProducts().get(index);
	}
	
	public void viewAvailability() {
		for (Product p : this.getProducts()) {
			p.viewData();
		}
	}
}
