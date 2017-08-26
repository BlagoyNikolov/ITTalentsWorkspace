package imoti.estates;

import imoti.agency.Agent;
import imoti.clients.Seller;

public abstract class Imot implements Comparable<Imot> {
	public enum Category {
		APARTAMENT, HOUSE, PARCEL
	}

	public  enum BuildType {
		EPK, BRICK, PANEL, KIRPICH
	}
	
	private Category category;
	private String description;
	private String address;
	protected double price;
	protected IType type;
	protected int area;
	private Agent agent;
	private Seller seller;
	
	public Imot(Category category, String description, String address) {
		this.category = category;
		this.description = description;
		this.address = address;
	}

	public Category getCategory() {
		return category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
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
	
	public abstract String imotInfo(); 	
	
	@Override
	public int compareTo(Imot o) {
		return Double.compare(o.getPrice(), this.getPrice());
	}
}
