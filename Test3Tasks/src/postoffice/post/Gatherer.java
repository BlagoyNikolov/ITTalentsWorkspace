package postoffice.post;

import java.util.HashSet;

import postoffice.shipments.Letter;
import postoffice.shipments.Colette;

public class Gatherer extends MailMan implements Runnable {
	private MailBox box;
	private static MailStation station;
	private HashSet<Letter> letters;
	private HashSet<Colette> colettes;
	private int completedShipments = 0;
	private boolean busy;
	private boolean isGiving;

	public Gatherer(String name, String lastname, int experience, MailBox box, MailStation station) {
		super(name, lastname, experience);
		this.box = box;
		Gatherer.station = station;
		this.letters = new HashSet<Letter>();
		this.colettes = new HashSet<Colette>();
	}
	
	public boolean isGiving() {
		return isGiving;
	}
	
	public void setGiving(boolean isGiving) {
		this.isGiving = isGiving;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
	public void addLetter(Letter l) {
		this.letters.add(l);
	}
	
	public void addColette(Colette c) {
		this.colettes.add(c);
	}
	
	public void getBoxContent() {
		Letter l = box.getRandomLetter();
		this.letters.add(l);
		System.out.println(this.name + " got the letter : " + l.toString());
	}
	
//	public HashSet<Letter> giveLettersToStation() {
//		HashSet<Letter> letters = new HashSet<Letter>();
//		letters.addAll(this.letters);
//		this.letters.clear();
//		return letters;
//	}

	@Override
	public void run() {
		while (true) {
			if (!isGiving) {
				this.getBoxContent();
				Gatherer.station.receiveFromGatherers(this.letters);
				try {
					Thread.sleep(2000);//2 hours
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			} else {
				station.sendGatherers();
			}
		}
	}
}
