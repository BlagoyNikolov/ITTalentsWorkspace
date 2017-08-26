package cakes.bakery;

import java.util.HashSet;

public class Supplier {
	private String name;
	private String phone;
	private HashSet<Order> orders;
	private double money;
	private int orderCount = 0;
	
	public Supplier(String name) {
		this.name = name;
		this.orders = new HashSet<>();
	}
	
	public HashSet<Order> getOrders() {
		return orders;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public int getOrderCount() {
		return orderCount;
	}
	
	public void addMoney(double money) {
		this.money += money;
	}
	
	public void addOrder(Order o) {
		this.orders.add(o);
	}
	
	public void increaseOrderCount() {
		this.orderCount++;
	}

	@Override
	public String toString() {
		return "Supplier [name=" + name + "] orders: " + this.orderCount;
	}
}
