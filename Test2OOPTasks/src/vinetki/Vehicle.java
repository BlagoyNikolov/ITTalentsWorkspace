package vinetki;

import vinetki.Vinette.VehicleType;

public abstract class Vehicle {
	protected String brand;
	protected String model;
	protected Vinette vinette;
	protected int year;
	
	public Vehicle(String brand, String model, Vinette vinette, int year) {
		this.brand = brand;
		this.model = model;
		this.vinette = vinette;
		this.year = year;
	}
	
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public Vinette getVinette() {
		return vinette;
	}

	public int getYear() {
		return year;
	}

	public void setVinette(Vinette vinette) {
		this.vinette = vinette;
	}
	
	public boolean hasVinette() {
		return this.vinette.isStuck();
	}
	
	public abstract VehicleType getType();
	
//	public VehicleType getType() {
//		return this.vinette.getType();
//	}
}
