package rakia;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;

public class Logger extends Thread {
	private Bidon bidon;
	private Koop koop;
	private StuklarskiCeh ceh;
	private ZaharenZavod zavod;
	
	public Logger(Bidon bidon, Koop koop, StuklarskiCeh ceh, ZaharenZavod zavod) {
		this.bidon = bidon;
		this.koop = koop;
		this.ceh = ceh;
		this.zavod = zavod;
	}
	
	@Override
	public void run() {
		try {
			PrintStream ps = new PrintStream(new File("Log.txt"));
			while (true) {
				try {
					Thread.sleep(10*1000);
					String result = ("-----LOGGER-----\n" + this.bidon.printAvailability() + this.koop.printAvailability() + this.ceh.printAvailability() + this.zavod.printAvailability() + "----------------");
					ps.println(result);
					System.out.println(result);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
