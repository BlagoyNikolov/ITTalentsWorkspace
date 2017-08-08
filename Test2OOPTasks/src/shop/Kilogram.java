package shop;

public class Kilogram extends Product {
	private double kilograms;
	
	public double getKilograms() {
		return kilograms;
	}
	
	public void setKilograms(double kilograms) {
		this.kilograms = kilograms;
	}
	
	public Kilogram(String name, double price, double kilograms) {
		super(name, price);
		this.kilograms = kilograms;
	}
}