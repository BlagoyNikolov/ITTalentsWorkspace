package postoffice.post;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Map.Entry;

import postoffice.shipments.Colette;
import postoffice.shipments.Letter;
import postoffice.shipments.Shipment;

import java.util.TreeMap;

public class MailStation {
	private HashSet<MailBox> mailBoxes;
	private TreeMap<LocalDate, TreeMap<LocalTime, Shipment>> archive;
	private HashSet<Shipment> repository;
	private HashSet<Gatherer> gatherers;
	private int allShipmentsNumber = 0;
	private int numberOfColettes = 0;
	private int numberOfLetters = 0;
	private int numberOfFrigileColettes = 0;
	
	public MailStation(HashSet<MailBox> mailBoxes) {
		this.mailBoxes = mailBoxes;
		this.archive = new TreeMap<>();
		this.repository = new HashSet<>();
		this.gatherers = new HashSet<>();
	}
	
	public void addGatherer(Gatherer g) {
		this.gatherers.add(g);
	}

	public void receiveLetter(Letter l) {
		this.repository.add(l);
		if (this.archive.get(LocalDate.now()) == null) {
			this.archive.put(LocalDate.now(), new TreeMap<>());
			for (Iterator<Entry<LocalDate, TreeMap<LocalTime, Shipment>>> iterator = archive.entrySet().iterator(); iterator.hasNext();) {
				Entry<LocalDate, TreeMap<LocalTime, Shipment>> entry = iterator.next();
				entry.getValue().put(LocalTime.now(), l);
				this.allShipmentsNumber++;
				this.numberOfLetters++;
			}
		} else {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.archive.containsKey(LocalDate.now())) {
				for (Iterator<Entry<LocalDate, TreeMap<LocalTime, Shipment>>> iterator = archive.entrySet().iterator(); iterator.hasNext();) {
					Entry<LocalDate, TreeMap<LocalTime, Shipment>> entry = iterator.next();
					entry.getValue().put(LocalTime.now(), l);
					this.allShipmentsNumber++;
					this.numberOfLetters++;
				}
			}
			
		}
	}
	
	public void receiveColette(Colette c) {
		this.repository.add(c);
		if (this.archive.get(LocalDate.now()) == null) {
			this.archive.put(LocalDate.now(), new TreeMap<>());
			for (Iterator<Entry<LocalDate, TreeMap<LocalTime, Shipment>>> iterator = archive.entrySet().iterator(); iterator.hasNext();) {
				Entry<LocalDate, TreeMap<LocalTime, Shipment>> entry = iterator.next();
				entry.getValue().put(LocalTime.now(), c);
				this.allShipmentsNumber++;
				this.numberOfColettes++;
				if (c.isFragile()) {
					this.numberOfFrigileColettes++;
				}
			}
		} else {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.archive.containsKey(LocalDate.now())) {
				for (Iterator<Entry<LocalDate, TreeMap<LocalTime, Shipment>>> iterator = archive.entrySet().iterator(); iterator.hasNext();) {
					Entry<LocalDate, TreeMap<LocalTime, Shipment>> entry = iterator.next();
					entry.getValue().put(LocalTime.now(), c);
					this.allShipmentsNumber++;
					this.numberOfColettes++;
					if (c.isFragile()) {
						this.numberOfFrigileColettes++;
					}
				}
			}
			
		}
	}
	
	public MailBox getRandomBox() {
		int i = 0;
		int index = new Random().nextInt(this.mailBoxes.size());
		for (Iterator<MailBox> iterator = this.mailBoxes.iterator(); iterator.hasNext();) {
			MailBox box = iterator.next();
			if (index == i) {
				return box;
			}
			i++;
		}
		return null;
	}
	
	public void printRepository() {
		System.out.println("-----REPOSITORY-----");
		for (Shipment s : repository) {
			System.out.println(s.toString());
		}
	}
	
	public void printArchive() {
		System.out.println("-----ARCHIVE-----");
		for (Iterator<Entry<LocalDate, TreeMap<LocalTime, Shipment>>> iterator = archive.entrySet().iterator(); iterator.hasNext();) {
			Entry<LocalDate, TreeMap<LocalTime, Shipment>> entry = iterator.next();
			System.out.println(entry.getKey());
			for (Iterator<Entry<LocalTime, Shipment>> iterator2 = entry.getValue().entrySet().iterator(); iterator2.hasNext();) {
				Entry<LocalTime, Shipment> smallEntry = iterator2.next();
				System.out.println(smallEntry.getKey());
				System.out.println(smallEntry.getValue().toString());
			}
		}
	}
	
	public void printMailBoxesContent() {
		System.out.println("-----MAIL BOXES-----");
		for (MailBox mailBox : mailBoxes) {
			mailBox.printBoxContent();
		}
	}
	
	public void addGathererLettersToStation() {
		for (Gatherer g : gatherers) {
			HashSet<Letter> lettersGathered = g.giveLettersToStation();
			for (Letter letter : lettersGathered) {
				this.receiveLetter(letter);
			}
		}
	}
	
	public void printMailStationStats() {
		System.out.println(numberOfLetters + " " + allShipmentsNumber);
		System.out.printf("percent of Letters / all shipments: %.2f\n", 100 * numberOfLetters / (double)allShipmentsNumber);
		System.out.printf("percent of Fragile Colettes / all colettes: %.2f\n", 100 * numberOfFrigileColettes / (double)numberOfColettes);
	}
}
