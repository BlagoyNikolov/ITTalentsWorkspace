package imoti;

import java.util.ArrayList;

public class Agent {
	private String name;
	private String phone;
	private ArrayList<Seller> sellers;
	private ArrayList<Buyer> buyers;
	private ArrayList<View> views;
	private double money;
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Seller> getSellers() {
		return sellers;
	}
	
	public ArrayList<Buyer> getBuyers() {
		return buyers;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public Agent(String name, String phone, ArrayList<Seller> sellers, ArrayList<Buyer> buyers, ArrayList<View> views) {
		this.name = name;
		this.phone = phone;
		this.sellers = sellers;
		this.buyers = buyers;
		this.views = views;
	}
	
	public void addViewToViews(View view) {
		if (view != null) {
			this.views.add(view);
		} else {
			System.out.println("Invalid view");
		}
	}
	
	public void receiveMoney(double amount) {
		this.setMoney(this.getMoney() + amount);
	}
	
	public void agentInfo() {
		System.out.println("-----Agent-----");
		System.out.println("Name: " + this.getName() + ", Budget: " + this.getMoney());
	}
}
