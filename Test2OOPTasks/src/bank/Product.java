package bank;

public abstract class Product {
	protected String name;
	protected double interest;
	protected int period;
	protected double value;
	
	public Product(String name, double interest) {
		this.name = name;
		this.interest = interest;
	}
	
	public Product(String name, double interest, int period) {
		this.name = name;
		this.interest = interest;
		this.period = period;
	}
	
	public Product(String name, double interest, int period, double value) {
		this.name = name;
		this.interest = interest;
		this.period = period;
		this.value = value;
	}
	
	public double getInterest() {
		return interest;
	}
	
	public int getPeriod() {
		return period;
	}
	
	public double getValue() {
		return value;
	}
	
	public abstract void setValue(double value);
}
