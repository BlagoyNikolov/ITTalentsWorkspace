package test3lutenica.resources;

import test3lutenica.veggies.VegType;

public class Tava {
	private int quantity;
	private VegType vegtype;
	private String name;
	
	public Tava(String name, VegType vegtype) {
		this.name = name;
		this.vegtype = vegtype;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public VegType getVegtype() {
		return vegtype;
	}
	
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeQuantity(int quantity) {
		this.quantity -= quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vegtype == null) ? 0 : vegtype.hashCode());
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
		Tava other = (Tava) obj;
		if (vegtype != other.vegtype)
			return false;
		return true;
	}
}
