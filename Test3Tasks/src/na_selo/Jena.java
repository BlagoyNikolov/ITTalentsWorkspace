package na_selo;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import na_selo.Store.Stoki;

public class Jena extends Person{
	private Bidon bidon;
	private Store magazin;
	private Piinqk muj;
	
	public Jena(String name, Bidon bidon, Store magazin, Piinqk muj) {
		super(name, 8);
		this.bidon = bidon;
		this.magazin = magazin;
		this.muj = muj;
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
							muj.getIzpitiButilki() + " butilki si izpil");
				
					System.out.println("Stiga si pil prase takova! Veche " + 
							muj.getIzpitiButilki() + " butilki si izpil");
				}
			});
			lucifer.setDaemon(true);
			lucifer.start();
		} catch (IOException e1) {
			System.out.println("Shte si pie spokoino.");
		}
		
		while (true){
			try {
				sleep(this.time * 1000);
			} catch (InterruptedException e) {
				System.out.println("nqmada se spi");
			}
			work();
		}
	}


	@Override
	void work() {
		this.bidon.get(10);
		this.magazin.add(Stoki.KOMPOT, 20);
	}



}
