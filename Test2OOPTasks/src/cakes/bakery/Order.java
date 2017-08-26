package cakes.bakery;

import java.time.LocalDate;
import java.util.ArrayList;

import cakes.cake.Cake;
import cakes.clients.Client;

public class Order {
	private Client client;
	private double price;
	private String address;
	private ArrayList<Cake> cakes;
	private LocalDate date;
	private double discount;
	
	public Order(Client client, double discount, ArrayList<Cake> cakes, LocalDate date) {
		this.client = client;
		this.discount = discount;
		this.cakes = cakes;
		this.date = date;
		this.price = calculateOrderPrice(cakes);
	}
	
	public double getPrice() {
		return price;
	}
	
	public ArrayList<Cake> getCakes() {
		return cakes;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double calculateOrderPrice(ArrayList<Cake> cakes) {
		double sum = 0;
		for (Cake cake : cakes) {
			sum += cake.getPrice();
		}
		//System.out.println("SUM " + sum);
		double finalSum = calculatePricePlusDiscount(sum);
		//System.out.println("FINALSUM " + finalSum);
		return finalSum;
	}
	
	public double calculatePricePlusDiscount(double money){
		return money - this.discount * money;
	}
}
