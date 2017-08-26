package cakes.clients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import cakes.bakery.Bakery;
import cakes.bakery.Order;
import cakes.bakery.Supplier;
import cakes.cake.Cake;

public class Corporate extends Client {
	private static final double DISCOUNT = 0.1;
	
	@Override
	public double getDiscount() {
		return DISCOUNT;
	}

	public Corporate(String name, Bakery bakery, double money) {
		super(name, bakery, money);
	}

	@Override
	public void makeOrder() {
		int numberOfCakes = new Random().nextInt(3) + 3;
		ArrayList<Cake> cakes = new ArrayList<Cake>();
		do {
			Cake cake = this.bakery.getRandomCakeFromBakery();
			if (this.bakery.isCakeAvailable(cake)) {
				cakes.add(cake);
				this.bakery.removeCake(cake);
				numberOfCakes--;
			}
		} while (numberOfCakes != 0); 
		
		Order o = new Order(this, getDiscount(), cakes, LocalDate.now());
		Supplier s = this.bakery.getRandomSupplier();
		s.addOrder(o);
		payForOrder(s, o);
	}

	public void payForOrder(Supplier s, Order o){
		System.out.println("----ORDER (Corporate)----");
		double tip = getOrderTip(o.getPrice());
		System.out.println("Supplier tip: " + tip);
		double orderPrice = o.getPrice();
		System.out.println("Order price: " + orderPrice);
		System.out.println("Client money b4: " + this.money);
		this.payMoney(orderPrice + tip);
		this.payedMoney += (orderPrice + tip);
		System.out.println("Client money after: " + this.money);
		s.addMoney(tip);
		this.bakery.addMoney(orderPrice);
		this.cakes.addAll(o.getCakes());
		s.getOrders().remove(o);
		s.increaseOrderCount();
	}
	
	private double getOrderTip(double price) {
		return 0.05 * price;
	}

	@Override
	public String toString() {
		return "Corporate [name=" + name + ", getDiscount()=" + getDiscount() + " money payed: " + this.payedMoney + "]\n";
	}
}
