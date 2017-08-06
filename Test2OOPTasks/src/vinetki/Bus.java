package vinetki;

import vinetki.Vinette.VehicleType;

public class Bus extends Vehicle {

	public Bus(String brand, String model, Vinette vinette, int year) {
		super(brand, model, vinette, year);
	}
	
	@Override
	public VehicleType getType() {
		return this.vinette.getType();
	}
	
	@Override
	public String toString() {
//		return getBrand() + " " + getModel() + " " + getVinette().toString() + " " + getYear();
		return getBrand() + " " + getModel() + " " + getYear() + " has vinette " + hasVinette();
	}
}
