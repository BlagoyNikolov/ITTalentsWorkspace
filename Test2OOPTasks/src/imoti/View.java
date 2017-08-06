package imoti;

import java.time.LocalDate;

public class View {
	private Imot imot;
	private Agent agent;
	private Buyer buyer;
	private LocalDate date;
	
	public Imot getImot() {
		return imot;
	}
	
	public View(Imot imot, Agent agent, Buyer buyer, LocalDate date) {
		this.imot = imot;
		this.agent = agent;
		this.buyer = buyer;
		this.date = date;
	}
	
	
}
