package postoffice.shipments;

import postoffice.Citizen;

public abstract class Shipment {
	protected Citizen sender;
	protected Citizen receiver;
	
	public Shipment(Citizen sender, Citizen receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	
	
}
