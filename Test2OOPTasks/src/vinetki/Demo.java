package vinetki;

import java.util.ArrayList;
import java.util.Random;

import vinetki.Vinette.ValidPeriod;
import vinetki.Vinette.VehicleType;

public class Demo {
	public static void main(String[] args) {
		GasStation gs = new GasStation(); 
//		for(Vinette v : gs.getVinettes()) {
//			System.out.println(v.toString());
//		}
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		for (int i = 1; i <= 200; i++) {
			int number = new Random().nextInt(3);
			switch (number) {
			case 0:
				vehicles.add(new Car("CarBrand" + i, "carModel" + i, new Vinette(VehicleType.CAR), new Random().nextInt(27) + 1990));
				break;
			case 1:
				vehicles.add(new Bus("BusBrand" + i, "busModel" + i, new Vinette(VehicleType.BUS), new Random().nextInt(27) + 1990));
				break;
			case 2:
				vehicles.add(new Truck("TruckBrand" + i, "truckModel" + i, new Vinette(VehicleType.TRUCK), new Random().nextInt(27) + 1990));
				break;
			default:
				break;
			}
		}
		for (Vehicle vehicle : vehicles) {
			//System.out.println(vehicle.toString());
		}
		
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		for (int i = 0; i < 20; i++) {
			ArrayList<Vehicle> tenVehicles = new ArrayList<Vehicle>();
			for (int j = i * 10; j < i * 10 + 10; j++) {
				tenVehicles.add(vehicles.get(j));
			}
			drivers.add(new Driver("Driver" + i, tenVehicles, 10000 * new Random().nextDouble(), gs));
		}
		
		for (int i = 0; i < drivers.size(); i++) {
			if (i % 3 == 0) {
				for (int j = 0; j < 5; j++) {
					drivers.get(i).buyVinetteForASingleVehicle(j, Vinette.getRandomPeriod());
				}
			} else {
				drivers.get(i).buyVinettesForAllVehicles(Vinette.getRandomPeriod());
			}
		}
		
		for (Driver driver : drivers) {
			driver.printInfoForDriver();
		}
		
		System.out.println(gs.getVinettes().size());
		System.out.println(gs.getIncome());
	}
}
