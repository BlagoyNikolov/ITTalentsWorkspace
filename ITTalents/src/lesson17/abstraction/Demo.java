package lesson17.abstraction;

public class Demo {

	public static void main(String[] args) {
		
		BoomShop boombg = new BoomShop();
		boombg.addExplodingDevice(new Nitro(500, "nitro"));
		boombg.blowAllUp();
		
	}
}
