package crossroads;

public class Demo {
	public static void main(String[] args) {
		Cross c = new Cross();
		
		Traveller t1 = new Traveller(c);
		t1.start();
		Traveller t2 = new Traveller(c);
		t2.start();
		Traveller t3 = new Traveller(c);
		t3.start();
		Traveller t4 = new Traveller(c);
		t4.start();
	}
}
