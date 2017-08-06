package imoti;

import java.time.LocalDate;
import java.util.ArrayList;

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
			this.setBudget(this.getBudget() - imot.getPrice());
			
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
}
