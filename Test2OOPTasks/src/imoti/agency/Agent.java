package imoti.agency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import imoti.clients.Buyer;
import imoti.clients.IViewOperations;
import imoti.clients.Seller;
import imoti.clients.View;

public class Agent implements Comparable<Agent>, IViewOperations {
	private String name;
	private String phone;
	private Set<Seller> sellers;
	private Set<Buyer> buyers;
	private ArrayList<View> views;
	private double money;
	
	public Agent(String name) {
		this.name = name;
		this.sellers = new HashSet<Seller>();
		this.buyers = new HashSet<Buyer>();
		this.views = new ArrayList<View>();
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Seller> getSellers() {
		return Collections.unmodifiableSet(sellers);
	}
	
	public Set<Buyer> getBuyers() {
		return Collections.unmodifiableSet(buyers);
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public void addSeller(Seller s) {
		if (s != null) {
			this.sellers.add(s);
		} else {
			System.out.println("Invalid Seller");
		}
	}
	
	public void addBuyer(Buyer b) {
		if (b != null) {
			this.buyers.add(b);
		} else {
			System.out.println("Invalid Buyer");
		}
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
		return (int) ((100 * this.getMoney()) - (100 * agent.getMoney()));
//		return Double.compare(this.getMoney(), agent.getMoney());
	}
}
