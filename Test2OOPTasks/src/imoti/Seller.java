package imoti;

public class Seller extends Client {
	private Imot imot;
	
	public Imot getImot() {
		return imot;
	}
	
	public Seller(String name, String phone, Agency agency, Imot imot, double budget) {
		super(name, phone, agency, budget);
		this.imot = imot;
		this.imot.setAgent(this.getAgent());
		this.imot.setSeller(this);
	}

	public void registerImotForSale() {
		Agent a = this.getAgency().getRandomAgent();
		this.setAgent(a);
		a.getSellers().add(this);
		this.getAgency().addImotToAds(getImot());
	}
	
	public void sellerInfo() {
		System.out.println("-----Seller-----");
		System.out.println("Name: " + this.getName() + ", Agent: " + this.getAgent().getName() + ", Budget: " + this.getBudget());
		System.out.println("-----Seller Imot-----");
		System.out.println(this.getImot().imotInfo());
		System.out.println();
	}
}
