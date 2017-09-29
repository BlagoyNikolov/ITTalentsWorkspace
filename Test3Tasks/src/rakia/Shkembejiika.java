package rakia;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Shkembejiika extends Thread {
	private Bidon bidon;
	private ZaharenZavod zavod;
	private StuklarskiCeh ceh;
	private Koop koop;
	private Shkembejiq shkembejiq;
	private int getGrozde = 50;
	private int getZahar = 10;
	private int burkani = 70;
	private int giveBurkaniKompot = 70;

	public Shkembejiika(Bidon bidon, Koop koop, ZaharenZavod zavod, StuklarskiCeh ceh, Shkembejiq shkembejiq, String name) {
		this.bidon = bidon;
		this.koop = koop;
		this.zavod = zavod;
		this.ceh = ceh;
		this.shkembejiq = shkembejiq;
		this.setName(name);
	}
	
	@Override
	public void run() {
		try {
			PrintStream ps = new PrintStream(new File("baba2.txt"));
			Thread lucifer = new Thread(()->{
				while(true){
					try {
						sleep(5000);
					} catch (Exception e) {
						System.out.println("Neka si pie");
					}
					
					ps.println("Stiga si pil prase takova! Veche " + 
							this.shkembejiq.getIzpitiButilki() + " butilki si izpil");
				
					System.out.println("Stiga si pil prase takova! Veche " + 
							this.shkembejiq.getIzpitiButilki() + " butilki si izpil");
				}
			});
			lucifer.setDaemon(true);
			lucifer.start();
		} catch (IOException e1) {
			System.out.println("Shte si pie spokoino.");
		}
		
		while (true) {
			this.bidon.removeFromBidona(this.getGrozde);
			this.zavod.removeFromZzgo(this.getZahar);
			this.ceh.removeBurkaniFromStuklarskiCeh(this.burkani);
			System.out.println(this.getName() + " vze " + this.getGrozde + "kg grozdence ot bidonq, " + this.getZahar + " ot zavoda i " + this.burkani + " ot ceha");
			try {
				System.out.println(this.getName() + " gotvi kompoti za 15s");
				Thread.sleep(15*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.koop.addKompotToKoop(this.giveBurkaniKompot);
			System.out.println(this.getName() + " dade " + this.giveBurkaniKompot + "burkani s kompot na magazinq");
		}
	}
}
