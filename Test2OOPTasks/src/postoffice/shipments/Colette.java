package postoffice.shipments;

import postoffice.Citizen;

public class Colette extends Shipment {
	private double price;
	private int width;
	private int height;
	private int length;
	private boolean isFragile;
	private boolean obremenitelen;
	
	public Colette(Citizen sender, Citizen receiver, int width, int height, int length, boolean isFragile) {
		super(sender, receiver);
		this.width = width;
		this.height = height;
		this.length = length;
		this.isFragile = isFragile;
		this.price = 2;
		
		if (this.width > 60 || this.height > 60 || this.length > 60) {
			this.price += (0.5 * price);
			this.obremenitelen = true;
		}
		
		if (this.isFragile) {
			this.price += (0.5 * price);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + (isFragile ? 1231 : 1237);
		result = prime * result + length;
		result = prime * result + (obremenitelen ? 1231 : 1237);
		result = prime * result + width;
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
		Colette other = (Colette) obj;
		if (height != other.height)
			return false;
		if (isFragile != other.isFragile)
			return false;
		if (length != other.length)
			return false;
		if (obremenitelen != other.obremenitelen)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Colette [price=" + price + ", width=" + width + ", height=" + height + ", length=" + length
				+ ", isFragile=" + isFragile + ", obremenitelen=" + obremenitelen + ", sender=" + sender + ", receiver="
				+ receiver + "]";
	}

	

}
