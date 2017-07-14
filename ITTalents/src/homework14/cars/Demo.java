package homework14.cars;

public class Demo {
	public static void main(String[] args) {
		Car bmw = new Car("BMW", "320", true, "white", 6500);
		Car passat = new Car("VW", "Passat", false, "black", 9800);
		Car fabia = new Car("Skoda", "Fabia", false, "black", 23000);
		Car golf = new Car("VW", "Golf", false, "black", 12000);
		
		System.out.println(bmw.isMoreExpensive(passat));
		System.out.println(passat.isMoreExpensive(bmw));
		
		System.out.println(passat.calculateCarPriceForScrap(0.5));
		System.out.println(bmw.calculateCarPriceForScrap(0.5));
		
		CarShop shop = new CarShop(5);
		shop.addCar(bmw);
		shop.addCar(passat);
		shop.addCar(fabia);
		shop.addCar(golf);
		
		shop.showAllCarsInTheShop();
		
		Person pesho = new Person("pesho", 940120654, true);
		pesho.setMoney(10000);
		shop.sellNextCar(pesho);
		
		shop.showAllCarsInTheShop();
	}
}
