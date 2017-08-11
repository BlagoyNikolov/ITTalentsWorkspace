package traders.suppliers;

public abstract class Supplier {
	private String name;
	private String address;
	private int workingHours;
	
	public Supplier(String name, String address, int workingHours) {
		this.name = name;
		this.address = address;
		this.workingHours = workingHours;
	}
	
	public abstract double makeDiscount(double amount);
	public abstract double getDiscount();
}
