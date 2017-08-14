package warehouse;

public abstract class Product {
	private String name;
	private int availability;
	
	public String getName() {
		return name;
	}
	
	public int getAvailability() {
		return availability;
	}
	
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	public Product(String name, int availability) {
		this.name = name;
		this.availability = availability;
	}

	public void viewData() {
		System.out.println(this.getName());
		System.out.println(this.getAvailability());
	}
	
}
