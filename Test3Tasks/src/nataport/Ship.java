package nataport;

import java.util.ArrayList;
import java.util.Random;

public class Ship extends Thread {
	private ArrayList<Pratka> pratki;
	private String name;
	private int id;
	private static int ID = 0;
	private static Pristanishte pristanishte;
	private Dock dock;

	public Ship(String name, Pratka... pratka) {
		ID++;
		if (name != null && name.length() > 0) {
			this.name = "Ship "+name;
		} else {
			id = ID;
			this.name = "Ship " + id;
		}

		for (Pratka pr : pratka) {
			this.pratki.add(pr);
		}
	}

	@Override
	public void run() {
		pristanishte.getRandomDock();
		while (true){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//pristanishte.raztovari(getTimeToRaztovarq());
		//notifyAll();
	}

	private int getTimeToRaztovarq(){
		return pratki.size()*2*1_000;
	}
	
	private void receiveRandomDock(){
		Random r = new Random();
		int x = r.nextInt(pristanishte.getDocks().size());
		this.dock = pristanishte.getDock(x);
	}
	
	public void setPristanishte(Pristanishte pristan){
		pristanishte= pristan;
	}
//	public Pristanishte getPristanishte(){
//		return pristanishte;
//	}
}
