package bank;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class Bank {
	private String name;
	private String address;
	private ArrayList<Product> products;
	private TreeMap<Client, Deposit> accounts;
	private double balance;
	private double reserve;
	
	public Bank(String name, String address) {
		this.name = name;
		this.address = address;
		this.products = new ArrayList<>();
		this.accounts = new TreeMap<>();
	}
	
	public void addToReserve(double value) {
		this.reserve += (0.9 * value);
	}
	
	public void addDepositToProducts(Deposit d) {
		this.products.add(d);
	}
	
	public void addCreditToProducts(Credit c) {
		this.products.add(c);
	}
	
	public Deposit getRandomDeposit() {
		ArrayList<Deposit> deposits = new ArrayList<Deposit>();
		for (Product p : products) {
			if (p instanceof Deposit) {
				deposits.add((Deposit)p);
			}
		}
		int x = new Random().nextInt(deposits.size());
		return deposits.get(x);
	}
	
	public Credit getRandomCredit() {
		ArrayList<Credit> credits = new ArrayList<Credit>();
		for (Product p : products) {
			if (p instanceof Credit) {
				credits.add((Credit)p);
			}
		}
		int x = new Random().nextInt(credits.size());
		return credits.get(x);
	}
	
	public void increaseBalance(double amount) {
		this.balance += amount;
		
	}
	
	public void decreaseBalance(double amount) {
		this.balance -= amount;
	}
	
	public void addInterestToDeposits() {
		for (Deposit d : accounts.values()) {
			d.addInterest(calculateDepositInterest(d));
		}
	}
	
	public double calculateDepositInterest(Deposit deposit) {
		double interest = deposit.getInterest();
		double value = deposit.getValue();
		double result = (interest * value);
		return result;
	}
	
	public void addToRegister(Client c, Deposit d) {
		this.accounts.put(c, d);
	}
	
	public void giveCredit() {
		//TODO get credit + check tam money
	}

	public boolean isCreditPossible(Credit c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void printRegister() {
		System.out.println("-----REGISTER----");
		for (Entry<Client, Deposit> deposits : accounts.entrySet()) {
			System.out.println(deposits.getKey() + " -> " + deposits.getValue());
		}
	}

	public void printBalanceAndReserve() {
		System.out.println("Bank balance: " + this.balance);
		System.out.println("Bank reserve: " + this.reserve);
	}
}
