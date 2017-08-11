package traders.trader;

import java.util.ArrayList;
import java.util.Random;

import traders.shops.TradeObject;
import traders.suppliers.Supplier;

public abstract class Trader {
	private String name;
	private String address;
	private double capital;
	// private ArrayList<TradeObject> tradeObjects;
	// private ArrayList<Supplier> suppliers;
	private ArrayList<Product> stock;

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public ArrayList<Product> getStock() {
		return stock;
	}

	public Trader(String name, String address, double capital) {
		this.name = name;
		this.address = address;
		this.capital = capital;
		// this.tradeObjects = new ArrayList<>();
		// this.suppliers = new ArrayList<>();
		this.stock = new ArrayList<>();
	}

	public void makeOrder(double price, Supplier supplier) {
		if (price < this.getCapital() / 2) {
			ArrayList<Product> products = new ArrayList<>();
			for (int i = 0; i < new Random().nextInt(20) + 10; i++) {
				if (price > 0) {
					double priceForProduct = 5 + 10 * new Random().nextDouble();
					products.add(new Product("Product" + i, priceForProduct));
					//price -= priceForProduct;
				}
			}
			this.getStock().addAll(products);
			//tradeObject.getProducts().addAll(products);
			this.setCapital(this.getCapital() - capculateOrderPrice(products) /** (1 - supplier.getDiscount())*/);
		}
	}

	public double capculateOrderPrice(ArrayList<Product> products) {
		double sum = 0;
		for (Product product : products) {
			sum += product.getPrice();
		}
		return sum;
	}

	public void sellItems() {
		double accumulatedProfit = 0;
		int number = new Random().nextInt(this.getStock().size());
		
		for (int i = 0; i < number; i++) {
			Product p = this.getStock().get(i);
			accumulatedProfit += p.getPrice();
			this.getStock().remove(p);
		}
		this.setCapital(getCapital() + 1.3 * accumulatedProfit);
	}
	
	public void payTax(TradeObject tradeObject) {
		this.setCapital(getCapital() - tradeObject.getTaxes()); 
	}
	
	public void getTraderInfo() {
		System.out.println("---TRADER INFO---");
		System.out.println("CAPITAL: " + this.getCapital());
	}
}
