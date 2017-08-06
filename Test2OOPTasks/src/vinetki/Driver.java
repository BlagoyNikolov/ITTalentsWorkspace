package vinetki;

import java.time.LocalDate;
import java.util.ArrayList;

import vinetki.Vinette.ValidPeriod;

public class Driver {
	private String name;
	private ArrayList<Vehicle> vehicles;
	private double money;
	private GasStation gasStation;

	public Driver(String name, ArrayList<Vehicle> vehicles, double money, GasStation gasStation) {
		this.name = name;
		this.vehicles = vehicles;
		this.money = money;
		this.gasStation = gasStation;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}

	public GasStation getGasStation() {
		return gasStation;
	}

	public void addVehicle(Vehicle v) {
		this.getVehicles().add(v);
	}
	
	public void buyVinettesForAllVehicles(ValidPeriod period) {
		for (int i = 0; i < this.getVehicles().size(); i++) {
			buyVinetteForASingleVehicle(i, period);
		}
	}

	public void buyVinetteForASingleVehicle(int index, ValidPeriod period) {
		Vinette v = getGasStation().sellVinette(getVehicles().get(index).getType(), period);
		if (this.getMoney() > v.getPrice()) {
			this.setMoney(this.getMoney() - v.getPrice());
			this.getVehicles().get(index).setVinette(v);
			this.getVehicles().get(index).getVinette().stickOnGlass(v);
		} else {
			System.out.println("Insufficient funds of driver " + this.getName());
		}
	}
	
	public ArrayList<Vinette> getExpiredVinettes(LocalDate date) {
		ArrayList<Vinette> vinettes = this.getGasStation().getVinettes();
		ArrayList<Vinette> expired = new ArrayList<Vinette>();
		for (Vinette vinette : vinettes) {
			
		}
		return expired;
	}
	
	public void printInfoForDriver() {
		System.out.println("---Info---");
		System.out.println(this.getName() + " drives: " + getVehicles().size() + " vehicles.");
		System.out.println("List of vehicles:");
		for (Vehicle vehicle : getVehicles()) {
			System.out.println(vehicle.toString());
		}
		System.out.println("Current money: " + this.getMoney() + " lv.");
	}
}
