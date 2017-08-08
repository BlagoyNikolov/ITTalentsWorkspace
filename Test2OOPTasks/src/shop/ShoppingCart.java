package shop;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Broika> productBroika;
	private ArrayList<Kilogram> productKilogram;
	
	public ArrayList<Broika> getProductBroika() {
		return productBroika;
	}
	
	public ArrayList<Kilogram> getProductKilogram() {
		return productKilogram;
	}
	
	public ShoppingCart() {
		this.productBroika = new ArrayList<Broika>();
		this.productKilogram = new ArrayList<Kilogram>();
	}
	
	public void shoppingCardInfo() {
		System.out.println("-----shopping cart-----");
		for (Broika broika : getProductBroika()) {
			System.out.println(broika.getName() + " " + broika.getQuantity());
		}
		for (Kilogram kilogram : getProductKilogram()) {
			System.out.println(kilogram.getName() + " " + kilogram.getKilograms());
		}
	}
}
