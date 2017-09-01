package postoffice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import postoffice.post.MailBox;
import postoffice.post.MailStation;
import postoffice.shipments.Colette;
import postoffice.shipments.Letter;

public class Citizen {
	private String name;
	private String lastName;
	private String address;
	private HashSet<Letter> letters;
	private HashSet<Colette> colettes;
	
	public Citizen(String name, String lastName, String address) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.letters = new HashSet<>();
		this.colettes = new HashSet<>();
	}
	
	public void addLetter(Letter l) {
		this.letters.add(l);
	}
	
	public void addColette(Colette c) {
		this.colettes.add(c);
	}
	
	public void dropLetterInBox(MailBox box) {
		Letter l = this.getRandomLetter();
		box.receiveLetter(l);
	}
	
	public void dropLetterAtStation(MailStation station) {
		Letter l = this.getRandomLetter();
		station.receiveLetter(l);
	}
	
	public void dropColetteAtStation(MailStation station) {
		Colette c = this.getRandomColette();
		station.receiveColette(c);
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
	
	public Colette getRandomColette() {
		int i = 0;
		int index = new Random().nextInt(this.colettes.size());
		for (Iterator<Colette> iterator = this.colettes.iterator(); iterator.hasNext();) {
			Colette colette = iterator.next();
			if (index == i) {
				iterator.remove();
				return colette;
			}
			i++;
		}
		return null;
	}
	
	public void printLetters() {
		System.out.println(this.name + " Letters:");
		for (Letter letter : letters) {
			System.out.println(letter);
		}
	}
	
	public void printColettes() {
		System.out.println(this.name + " Colettes:");
		for (Colette colette : colettes) {
			System.out.println(colette);
		}
	}

	@Override
	public String toString() {
		return "Citizen [name=" + name + ", lastName=" + lastName + ", address=" + address + "]";
	}

	
}
