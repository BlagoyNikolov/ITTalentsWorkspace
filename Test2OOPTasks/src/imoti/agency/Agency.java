package imoti.agency;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import imoti.estates.Imot;

import java.util.Iterator;

public class Agency {
	private String name;
	private String address;
	private String phone;
	private TreeSet<Agent> agents;
	private ArrayList<Imot> ads;
	private double balance;
	
	public TreeSet<Agent> getAgents() {
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
	
	public Agency(String name, String address, String phone, TreeSet<Agent> agents, ArrayList<Imot> ads) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.agents = agents;
		this.ads = ads;
	}
	
	public Agent getRandomAgent() {
		int r = new Random().nextInt(getAgents().size());
		int i = 0;
		for (Iterator iterator = getAgents().iterator(); iterator.hasNext();i++) {
			Agent a = (Agent) iterator.next();
			if (i == r) {
				return a;
			}
		}
		return null;
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
	
	public void printAgents() {
//		for (Agent a : getAgents()) {
//			a.printAgentInfo();
//		}
		
		System.out.println(agents);
	}
}
