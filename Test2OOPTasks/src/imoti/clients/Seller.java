package imoti.clients;

import imoti.agency.Agency;
import imoti.agency.Agent;
import imoti.estates.Imot;

public class Seller extends Client {
	private Imot imot;
	
	public Seller(String name, String phone, Agency agency, Imot imot, double budget) {
		super(name, phone, agency, budget);
		this.imot = imot;
		this.imot.setAgent(this.getAgent());
		this.imot.setSeller(this);
	}
	
	public Imot getImot() {
		return imot;
	}

	public void registerImotForSale() {
		Agent a = this.getAgency().getRandomAgent();
		this.setAgent(a);
		a.addSeller(this);
		this.getAgency().addImotToCatalogue(getImot());
	}
	
	public void sellerInfo() {
		System.out.println("-----Seller-----");
		System.out.println("Name: " + this.getName() + ", Agent: " + this.getAgent().getName() + ", Budget: " + this.getBudget());
		System.out.println("-----Seller Imot-----");
		System.out.println(this.getImot().imotInfo());
		System.out.println();
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + this.agency.hashCode() + (int) (100 * this.budget);
	}
	
	@Override
	public boolean equals(Object obj) {
		Seller s = (Seller) obj;
		return this.name.equals(s.name) && this.agency.equals(s.agency) && (this.budget == s.budget);
	}
}
