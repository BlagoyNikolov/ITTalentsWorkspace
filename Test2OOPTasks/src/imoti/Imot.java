package imoti;

public abstract class Imot {
	private String description;
	private String address;
	private double price;
	private int area;
	private Agent agent;
	private Seller seller;
	
	public double getPrice() {
		return price;
	}
	
	public int getArea() {
		return area;
	}
	
	public Seller getSeller() {
		return seller;
	}
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public Imot(String description, String address, double price, int area) {
		this.description = description;
		this.address = address;
		this.price = price;
		this.area = area;
	}
	
	public Imot(String description, String address, double price, int area, Agent agent, Seller seller) {
		this.description = description;
		this.address = address;
		this.price = price;
		this.area = area;
		this.agent = agent;
		this.seller = seller;
	}

	
	public abstract String imotInfo(); 	
}
