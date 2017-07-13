package homework14.cars;

public class Demo {
	public static void main(String[] args) {
		Car bmw = new Car("320", true, "blue");
		bmw.price = 6500;
		Car passat = new Car("Passat", false, "grey");
		passat.price = 9800;
		
		System.out.println(bmw.isMoreExpensive(passat));
		System.out.println(passat.isMoreExpensive(bmw));
	}
}
