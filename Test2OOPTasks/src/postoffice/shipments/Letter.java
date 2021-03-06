package postoffice.shipments;

import postoffice.Citizen;

public class Letter extends Shipment {
	private double price;
	
	public Letter(Citizen sender, Citizen receiver) {
		super(sender, receiver);
		this.price = 0.5;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		Citizen sender = this.sender;
		Citizen receiver = this.receiver;
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sender.hashCode();
		result = prime * result + receiver.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)/* && !this.sender.equals(other.sender) && !this.receiver.equals(other.receiver)*/)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Letter [price=" + price + ", sender=" + sender + ", receiver=" + receiver + "]";
	}
	
	
	
}
