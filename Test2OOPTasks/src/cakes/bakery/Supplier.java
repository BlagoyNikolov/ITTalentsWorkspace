package cakes.bakery;

import java.util.ArrayList;

public class Supplier {
	private String name;
	private String phone;
	private ArrayList<Order> orders;
	private double money;
	private int orderCount = 0;
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public Supplier(String name) {
		this.name = name;
		this.orders = new ArrayList<>();
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

	public int getOrderCount() {
		return orderCount;
	}
}
