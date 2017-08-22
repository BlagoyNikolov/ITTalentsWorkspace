package imoti;

import java.util.ArrayList;
import java.util.HashSet;

public class Agent implements Comparable<Agent> {
	private String name;
	private String phone;
	private HashSet<Seller> sellers;
	private HashSet<Buyer> buyers;
	private ArrayList<View> views;
	private double money;
	
	public String getName() {
		return name;
	}
	
	public HashSet<Seller> getSellers() {
		return sellers;
	}
	
	public HashSet<Buyer> getBuyers() {
		return buyers;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public Agent(String name, HashSet<Seller> sellers, HashSet<Buyer> buyers, ArrayList<View> views) {
		this.name = name;
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
		this.money += amount;
	}
	
	@Override
	public String toString() {
		return "-----Agent-----\nName: " + this.getName() + ", Budget: " + this.getMoney() + "\n";
	}

	@Override
	public int compareTo(Agent agent) {
		if (this.getMoney() == agent.getMoney()) {
			return this.getName().compareTo(agent.getName());
		}
		return (int)(this.getMoney() - agent.getMoney());
	}
	

}
