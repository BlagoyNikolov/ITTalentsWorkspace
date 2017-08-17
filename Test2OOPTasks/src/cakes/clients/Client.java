package cakes.clients;

import java.util.ArrayList;

import cakes.bakery.Bakery;
import cakes.cake.Cake;

public abstract class Client {
	protected String name;
	private String phone;
	protected Bakery bakery;
	protected ArrayList<Cake> cakes;
	protected double money;
	protected double payedMoney;
	
	public Client(String name, Bakery bakery, double money) {
		this.name = name;
		this.bakery = bakery;
		this.cakes = new ArrayList<Cake>();
		this.money = money;
	}
	
	public void addCake(Cake c) {
		this.cakes.add(c);
	}
	
	public double getPayedMoney() {
		return payedMoney;
	}
	
	public void payMoney(double money) {
		this.money -= money;
	}
	
	public abstract void makeOrder();
	public abstract double getDiscount();
	
}
