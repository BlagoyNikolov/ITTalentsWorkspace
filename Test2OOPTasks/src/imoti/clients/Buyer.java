package imoti.clients;

import java.time.LocalDate;
import java.util.ArrayList;

import imoti.agency.Agency;
import imoti.agency.Agent;
import imoti.estates.Imot;

public class Buyer extends Client {
	private ArrayList<View> views;
	private Imot imot;
	
	public ArrayList<View> getViews() {
		return views;
	}
	
	public void setImot(Imot imot) {
		if (imot != null) {
			this.imot = imot;
		} else {
			System.out.println("Invalid imot");
		}
	}
	
	public Buyer(String name, String phone, double budget, Agency agency) {
		super(name, phone, agency, budget);
		this.views = new ArrayList<>();
	}

	public void registerImotEnquiry() {
		Agent a = this.getAgency().getRandomAgent();
		this.setAgent(a);
		// TODO fix dis
		a.getBuyers().add(this);
	}
	
	public void declareView(Imot imot) {
		if (this.getBudget() > imot.getPrice()) {
			View v = new View(imot, this.getAgent(), this, LocalDate.now());
			this.addViewToViews(v);
			this.getAgent().addViewToViews(v);
		} else {
			//System.out.println("Insufficient funds; " + this.getName() + " cannot buy " + imot.imotInfo() + "; current money " + this.getBudget());
		}
	}
	
	public void declarePurchase() {
		for (View view : this.getViews()) {
			Imot imot = view.getImot();
			this.setImot(imot);
			//TODO method pay
			this.setBudget(this.getBudget() - imot.getPrice());
			//TODO remove magic numbers
			this.getAgency().addFundsToBalance((imot.getPrice() * 0.03), this.getAgent());
			this.setBudget(this.getBudget() - (imot.getPrice() * 0.03));
			
			this.getAgency().addFundsToBalance((imot.getPrice() * 0.03), this.getAgent());
			imot.getSeller().setBudget(this.getBudget() - (imot.getPrice() * 0.03));
			this.getAgency().getAds().remove(imot);
			System.out.println("Success! " + this.getName() + " just bought a " + imot.imotInfo());
			break;
		}
	}
	
	public void addViewToViews(View view) {
		if (view != null) {
			this.views.add(view);
		} else {
			System.out.println("Invalid view");
		}
	}
	
	public void buyerInfo() {
		System.out.println("-----Buyer-----");
		System.out.println("Name: " + this.getName() + " Agent: " + this.getAgent().getName() + ", Budget: " + this.getBudget());
		System.out.println();
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + this.agency.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Buyer b = (Buyer) obj;
		return this.name.equals(b.name) && this.agency.equals(b.agency);
	}
}
