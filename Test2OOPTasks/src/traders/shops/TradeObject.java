package traders.shops;

import java.util.ArrayList;

import traders.trader.Product;

public abstract class TradeObject {
	private String address;
	private int workingHours;
	private int area;
	private double taxes;
	private ArrayList<Product> products;
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public double getTaxes() {
		return taxes;
	}
	
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public TradeObject(String address, int workingHours) {
		this.address = address;
		this.workingHours = workingHours;
		//this.area = area;
		//this.taxes = taxes;
	}
}
