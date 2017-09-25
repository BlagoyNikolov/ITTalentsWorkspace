package pivovana;

public class Demo {

	public static void main(String[] args) {
		
		Pivovarna p = new Pivovarna("NqkvaPivovarna", 10000);
		Thread naPivovarnata = new Thread(p);
		
		Magazin m = new Magazin("Nqkyv magazin", p, 1000000);
		
		Thread client1 = new Thread(new Client("Pancho", 10000, m));
		Thread client2 = new Thread(new Client("Tancho", 10000, m));
		Thread client3 = new Thread(new Client("Rancho", 10000, m));
		Thread client4 = new Thread(new Client("Dancho", 10000, m));
		Thread client5 = new Thread(new Client("Kotkarcho", 10000, m));
		
		naPivovarnata.start();
		client1.start();
		client2.start();
		client3.start();
		client4.start();
		client5.start();
	}
}
