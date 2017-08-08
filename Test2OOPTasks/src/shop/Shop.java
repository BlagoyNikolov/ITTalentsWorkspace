package shop;

import java.util.ArrayList;

public class Shop {
	private String name;
	private String address;
	private double money;
	private ArrayList<Product> products;
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public Shop(String name, String address, double money, ArrayList<Product> products) {
		this.name = name;
		this.address = address;
		this.money = money;
		this.products = products;
	}
	
	public void shopInfo() {
		System.out.println("-----shop-----");
		for (Product product : getProducts()) {
			if (product instanceof Broika) {
				System.out.println(product.getName() + " " + ((Broika)product).getQuantity());
			} else {
				System.out.println(product.getName() + " " + ((Kilogram)product).getKilograms());
			}
		}
	}
}
