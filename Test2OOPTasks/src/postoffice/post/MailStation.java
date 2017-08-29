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
	
	public MailStation(HashSet<MailBox> mailBoxes) {
		this.mailBoxes = mailBoxes;
		this.archive = new TreeMap<>();
		this.repository = new HashSet<>();
	}

	public void receiveLetter(Letter l) {
		this.repository.add(l);
		if (this.archive.get(LocalDate.now()) == null) {
			this.archive.put(LocalDate.now(), new TreeMap<>());
			for (Iterator<Entry<LocalDate, TreeMap<LocalTime, Shipment>>> iterator = archive.entrySet().iterator(); iterator.hasNext();) {
				Entry<LocalDate, TreeMap<LocalTime, Shipment>> entry = iterator.next();
				entry.getValue().put(LocalTime.now(), l);
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
				iterator.remove();
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
}
