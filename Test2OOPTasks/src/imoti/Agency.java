package imoti;

import java.util.ArrayList;
import java.util.Random;

public class Agency {
	private String name;
	private String address;
	private String phone;
	private ArrayList<Agent> agents;
	private ArrayList<Imot> ads;
	private double balance;
	
	public ArrayList<Agent> getAgents() {
		return agents;
	}
	
	public ArrayList<Imot> getAds() {
		return ads;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Agency(String name, String address, String phone, ArrayList<Agent> agents, ArrayList<Imot> ads) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.agents = agents;
		this.ads = ads;
	}
	
	public Agent getRandomAgent() {
		return getAgents().get(new Random().nextInt(getAgents().size()));
	}
	
	public void addImotToAds(Imot imot) {
		if (imot != null) {
			this.ads.add(imot);
		} else {
			System.out.println("Invalid imot");
		}
	}
	
	public void addFundsToBalance(double amount, Agent agent) {
		agent.receiveMoney(amount / 2);
		this.setBalance(this.getBalance() + amount / 2);
	}
}
