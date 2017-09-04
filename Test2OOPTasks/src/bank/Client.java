package bank;

import java.util.ArrayList;

public class Client implements Comparable<Client> {
	private String name;
	private String address;
	private double money;
	private double salary;
	private ArrayList<Deposit> deposits;
	private ArrayList<Credit> credits;
	private Bank bank;
	
	public Client(String name, double money, double salary, Bank bank) {
		this.name = name;
		this.money = money;
		this.salary = salary;
		this.deposits = new ArrayList<>();
		this.credits = new ArrayList<>();
		this.bank = bank;
	}
	
	public boolean openDeposit(Deposit d) {
		if (this.money > 0 && this.money > d.getValue()) {
			this.money -= d.getValue();
			this.bank.increaseBalance(d.getValue());
			this.deposits.add(d);
			System.out.println(this.name + " has made a deposit of " + d.getValue());
		} else {
			System.out.println("Not enough money!");
			return false;
		}
		return true;
	}
	
	public void askForCredit(Credit c) {
		if (c.getMonthlyVnoska() < 0.5 * this.salary) {
			if (this.bank.isCreditPossible(c)) {
				this.money += c.getValue();
				this.bank.decreaseBalance(c.getValue());
				this.credits.add(c);
			}
		}
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void addMoneyToCredit(double amount, Credit credit) {
		//TODO
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", money=" + money + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Client o) {
		return this.name.compareTo(o.name);
	}
}
