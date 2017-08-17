package cakes.bakery;

import java.util.ArrayList;
import java.util.Random;

import cakes.cake.Cake;
import cakes.cake.Juvenile;
import cakes.cake.Special;
import cakes.cake.Standard;
import cakes.cake.Wedding;

public class Bakery {
	private String name;
	private String address;
	private String phone;
	private ArrayList<Cake> cakes;
	private ArrayList<Supplier> suppliers;
	private double money;
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public Bakery(String name, String address, ArrayList<Cake> cakes, ArrayList<Supplier> suppliers) {
		this.name = name;
		this.address = address;
		this.cakes = cakes;
		this.suppliers = suppliers;
	}
	
	public void addMoney(double money) {
		this.money += money;
	}
	
	public boolean isCakeAvailable(Cake cake) {
		return cakes.contains(cake);
	}
	
	public Cake getRandomCakeFromBakery() {
		return this.cakes.get(new Random().nextInt(this.cakes.size()));
	}
	
	public Supplier getRandomSupplier() {
		return this.suppliers.get(new Random().nextInt(this.suppliers.size()));
	}

	public void removeCake(Cake cake) {
		this.cakes.remove(cake);
	}
	
	public int getAllAvailableCakes() {
		int counter = 0;
		for (Cake cake : cakes) {
			counter++;
			System.out.print(cake.toString());
		}
		return counter;
	}
}
