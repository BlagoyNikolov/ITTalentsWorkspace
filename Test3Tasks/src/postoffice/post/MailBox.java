package postoffice.post;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import postoffice.shipments.Letter;

public class MailBox extends Thread {
	private HashSet<Letter> letters;
	private String name;
	private Gatherer gath;

	public MailBox(String name, Gatherer gath) {
		this.letters = new HashSet<Letter>();
		this.name = name;
		this.gath = gath;
	}
	
	public void receiveLetter(Letter l) {
		this.letters.add(l);
	}
	
	@Override
	public void run() {
		while (true) {
			gath.addLetter(getRandomLetter());
		}
	}
	
	public Letter getRandomLetter() {
		int i = 0;
		int index = new Random().nextInt(this.letters.size());
		for (Iterator<Letter> iterator = this.letters.iterator(); iterator.hasNext();) {
			Letter letter = iterator.next();
			if (index == i) {
				iterator.remove();
				return letter;
			}
			i++;
		}
		return null;
	}
	
	public void printBoxContent() {
		System.out.println("-----"+this.name+" Content-----");
		for (Letter letter : letters) {
			System.out.println(letter.toString());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letters == null) ? 0 : letters.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailBox other = (MailBox) obj;
		if (letters == null) {
			if (other.letters != null)
				return false;
		} else if (!letters.equals(other.letters))
			return false;
		return true;
	}
}
