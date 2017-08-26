package imoti.clients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import imoti.agency.Agency;
import imoti.agency.Agent;
import imoti.estates.Imot;

public class Buyer extends Client implements IViewOperations {
	public static final double PERCENT = 0.03;
	private List<View> views;
	private Imot imot;
	
	public Buyer(String name, String phone, double budget, Agency agency) {
		super(name, phone, agency, budget);
		this.views = new ArrayList<>();
	}
	
	public List<View> getViews() {
		return Collections.unmodifiableList(views);
	}
	
	public void setImot(Imot imot) {
		if (imot != null) {
			this.imot = imot;
		} else {
			System.out.println("Invalid imot");
		}
	}
	
	public void addViewToViews(View view) {
		if (view != null) {
			this.views.add(view);
		} else {
			System.out.println("Invalid view");
		}
	}

	public void registerImotEnquiry() {
		Agent a = this.getAgency().getRandomAgent();
		this.setAgent(a);
		a.addBuyer(this);
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
//		int x = new Random().nextInt(this.getViews().size());
//		System.err.println(x);
//		View view = this.getViews().get(x);
		
		for (View view : this.getViews()) {
			Imot imot = view.getImot();
			this.setImot(imot);
			
			this.removeBudget(imot.getPrice());
			this.getAgency().addFundsToBalance((imot.getPrice() * PERCENT), this.getAgent());
			this.removeBudget(imot.getPrice() * PERCENT);
			
			this.getAgency().addFundsToBalance((imot.getPrice() * PERCENT), this.getAgent());
			imot.getSeller().removeBudget(imot.getPrice() * PERCENT);
			this.getAgency().removeImotFromCatalogue(imot);
			System.out.println("Success! " + this.getName() + " just bought a " + imot.imotInfo() + " remaining money: " + this.getBudget());
			break;
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
