package postoffice.post;

import java.util.HashSet;
import postoffice.shipments.Letter;

public class Gatherer extends MailMan {
	private MailBox box;
	private HashSet<Letter> letters;
	private int completedShipments = 0;

	public Gatherer(String name, String lastname, int experience, MailBox box) {
		super(name, lastname, experience);
		this.box = box;
		this.letters = new HashSet<>();
	}
	
	public void getBoxContent() {
		Letter l = box.getRandomLetter();
		this.letters.add(l);
		System.out.println(this.name + " got the letter : " + l.toString());
	}
	
	public HashSet<Letter> giveLettersToStation() {
		HashSet<Letter> letters = new HashSet<Letter>();
		letters.addAll(this.letters);
		this.letters.clear();
		return letters;
	}

}
