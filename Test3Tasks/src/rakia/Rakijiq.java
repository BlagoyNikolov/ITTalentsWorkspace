package rakia;

import java.util.Random;

public class Rakijiq extends Thread {
	private Bidon bidon;
	private ZaharenZavod zavod;
	private StuklarskiCeh ceh;
	private Koop koop;
	private int getGrozde = 25;
	private int butilki = 30;
	private int giveRakia = 30;

	public Rakijiq(Bidon bidon, Koop koop, ZaharenZavod zavod, StuklarskiCeh ceh, String name) {
		this.bidon = bidon;
		this.koop = koop;
		this.zavod = zavod;
		this.ceh = ceh;
		this.setName(name);
	}
	
	@Override
	public void run() {
		while (true) {
			this.bidon.removeFromBidona(this.getGrozde);
			int amount = new Random().nextInt(15) + 10;
			this.zavod.removeFromZzgo(amount);
			this.ceh.removeButilkiFromStuklarskiCeh(this.butilki);
			System.out.println(this.getName() + " vze " + this.getGrozde + "kg grozdence ot bidonq, " + amount + "kg zahar i " + this.butilki + " butilki ot ceha");
			try {
				System.out.println(this.getName() + " pravi rakiq za 3s");
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.koop.addRakiaToKoop(this.giveRakia);
			System.out.println(this.getName() + " dade " + this.giveRakia + "butilki rakiq na magazinq");
		}
	}
}
