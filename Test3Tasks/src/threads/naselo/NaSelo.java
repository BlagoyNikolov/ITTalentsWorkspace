package threads.naselo;

public class NaSelo {
	public static void main(String[] args) {
		Gurne g = new Gurne();
		Thread b = new Baba(g);
		Thread v = new Vnuche(g);
		
		b.start();
		v.start();
	}
}
