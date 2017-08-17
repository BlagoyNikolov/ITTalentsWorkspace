package cakes.clients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import cakes.bakery.Bakery;
import cakes.bakery.Order;
import cakes.bakery.Supplier;
import cakes.cake.Cake;

public class Private extends Client {
	private ArrayList<Coupon> coupons;

	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}
	
	@Override
	public double getDiscount() {
		return 0;
	}
	
	public Private(String name, Bakery bakery, double money) {
		super(name, bakery, money);
		int length = new Random().nextInt(4) + 1;
		this.coupons = new ArrayList<Coupon>();
		while (length != 0) {
			this.coupons.add(new Coupon(20 * new Random().nextDouble() + 10));
			length--;
		}
	}

	@Override
	public void makeOrder() {
		int numberOfCakes = new Random().nextInt(3) + 1;
		ArrayList<Cake> cakes = new ArrayList<Cake>();
		do {
			Cake cake = this.bakery.getRandomCakeFromBakery();
			if (this.bakery.isCakeAvailable(cake)) {
				cakes.add(cake);
				numberOfCakes--;
			}
		} while (numberOfCakes != 0);
		
		Order o = new Order(this, getDiscount(), cakes, LocalDate.now());
		Supplier s = this.bakery.getRandomSupplier();
		s.addOrder(o);
		payForOrder(s, o);
		
	}
	
	public void payForOrder(Supplier s, Order o){
		System.out.println("----ORDER----");
		double orderPrice = o.getPrice() - calculateCouponPrice();
		System.out.println("Order price: " + orderPrice);
		double tip = getOrderTip(orderPrice);
		System.out.println("Supplier tip: " + tip);
		System.out.println("Client money b4: " + this.money);
		this.payMoney(orderPrice + tip);
		this.payedMoney += (orderPrice + tip);
		System.out.println("Client money after: " + this.money);
		s.addMoney(tip);
		this.bakery.addMoney(orderPrice);
		this.cakes.addAll(o.getCakes());
		s.getOrders().remove(o);
	}
	
	private double getOrderTip(double price) {
		return 0.02 * price;
	}

	public double calculateCouponPrice() {
		double sum = 0;
		for (Coupon coupon : this.coupons) {
			sum += coupon.getPrice();
		}
		return sum;
	}

	@Override
	public String toString() {
		return "Private [name=" + name + ", calculateCouponPrice()=" + calculateCouponPrice() + " money payed: " + this.payedMoney + "]\n";
	}
}
