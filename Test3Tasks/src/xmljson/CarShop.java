package xmljson;

import java.util.ArrayList;
import java.util.List;

public class CarShop {
	private String carShopName;
	private String address;
	private List<Car> cars;
	
	public CarShop(String carShopName, String address) {
		this.carShopName = carShopName;
		this.address = address;
		this.cars = new ArrayList<Car>();
	}
	
	public void addCar(Car c) {
		if (c != null) {
			this.cars.add(c);
		} else {
			System.out.println("Invalid car");
		}
	}
}
