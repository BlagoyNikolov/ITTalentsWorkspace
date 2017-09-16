package library;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import library.Book.Genre;
import library.Magazine.Category;
import library.Reading.ReadingType;
import library.TextBook.Theme;

public class Library {
	private String name;
	private double money;
	private int numberOfReadings;
	
	private TreeMap<Reading.ReadingType, TreeMap<IKind, TreeSet<Reading>>> allReadings;
	private TreeMap<Reading, PeriodOutOfLibrary> archive;
	private TreeSet<Reading> takenReadings;
	
	public Library(String name) {
		this.name = name;
		this.allReadings = new TreeMap<>();
		this.archive = new TreeMap<>();
		this.takenReadings = new TreeSet<Reading>((o1, o2) -> o1.getTaken().compareTo(o2.getTaken()));
		
		this.allReadings.put(ReadingType.BOOK, new TreeMap<>());
		this.allReadings.put(ReadingType.MAGAZINE, new TreeMap<>());
		this.allReadings.put(ReadingType.TEXTBOOK, new TreeMap<>());
		
		this.allReadings.get(ReadingType.BOOK).put(Genre.ROMAN, new TreeSet<Reading>());
		this.allReadings.get(ReadingType.BOOK).put(Genre.THRILLER, new TreeSet<Reading>());
		this.allReadings.get(ReadingType.MAGAZINE).put(Category.FASHION, new TreeSet<Reading>());
		this.allReadings.get(ReadingType.MAGAZINE).put(Category.SCIENCE, new TreeSet<Reading>());
		this.allReadings.get(ReadingType.TEXTBOOK).put(Theme.HISTORY, new TreeSet<Reading>());
		this.allReadings.get(ReadingType.TEXTBOOK).put(Theme.PROGRAMMING, new TreeSet<Reading>());
		
		TextBook t1 = new TextBook("atila", "txtbookauthor1", LocalDate.of(1954, 5, 21), "izd1",Theme.HISTORY);
		addReading(t1);
		TextBook t2 = new TextBook("java", "txtbookauthor1", LocalDate.of(1978, 5, 21), "izd1",Theme.PROGRAMMING);
		addReading(t2);
		TextBook t3 = new TextBook("ww2", "txtbookauthor1", LocalDate.of(1954, 5, 21), "izd1",Theme.HISTORY);
		addReading(t3);
		TextBook t4 = new TextBook("c#", "txtbookauthor1", LocalDate.of(1978, 5, 21), "izd1",Theme.PROGRAMMING);
		addReading(t4);
		Book b1 = new Book("podigoto", "bookauthor1", LocalDate.of(1987, 5, 21), "izd1",Genre.ROMAN);
		addReading(b1);
		Book b2 = new Book("voinaimir", "bookauthor2", LocalDate.of(1998, 5, 21), "izd1",Genre.THRILLER);
		addReading(b2);
		Book b3 = new Book("kapitannemo", "bookauthor1", LocalDate.of(1987, 5, 22), "izd1",Genre.ROMAN);
		addReading(b3);
		Book b4 = new Book("got", "bookauthor2", LocalDate.of(1998, 5, 23), "izd1",Genre.THRILLER);
		addReading(b4);
		Magazine m1 = new Magazine("grazia", 14, LocalDate.of(2012, 5, 21), "izd1",Category.FASHION);
		addReading(m1);
		Magazine m2 = new Magazine("cosmos", 34, LocalDate.of(1999, 5, 21), "izd1",Category.SCIENCE);
		addReading(m2);
		Magazine m3 = new Magazine("grazia", 19, LocalDate.of(2012, 5, 21), "izd1",Category.FASHION);
		addReading(m3);
		Magazine m4 = new Magazine("physcs", 34, LocalDate.of(1999, 5, 21), "izd1",Category.SCIENCE);
		addReading(m4);
	}
	
	public void addReading(Reading r) {
		if (allReadings.containsKey(r.getType())) {
			for (Entry<Reading.ReadingType, TreeMap<IKind, TreeSet<Reading>>> bigEntry : allReadings.entrySet()) {
				if (bigEntry.getKey().equals(r.getType())) {
					if (bigEntry.getValue().keySet().contains(r.getKind())) {
						for (Entry<IKind, TreeSet<Reading>> smallEntry : bigEntry.getValue().entrySet()) {
							if (smallEntry.getKey().equals(r.getKind())) {
								smallEntry.getValue().add(r);
								this.numberOfReadings++;
							}
						}
					} else {
						allReadings.get(r.getType()).put(r.getKind(), new TreeSet<Reading>());
						allReadings.get(r.getType()).get(r.getKind()).add(r);
						this.numberOfReadings++;
					}
				}
			}
		} else {
			allReadings.put(r.getType(), new TreeMap<IKind, TreeSet<Reading>>());
			allReadings.get(r.getType()).put(r.getKind(), new TreeSet<Reading>());
			allReadings.get(r.getType()).get(r.getKind()).add(r);
			this.numberOfReadings++;
		}
	}
	
	public void takeReading(Reading r) {
		if (allReadings.containsKey(r.getType())) {
			for (Entry<Reading.ReadingType, TreeMap<IKind, TreeSet<Reading>>> bigEntry : allReadings.entrySet()) {
				if (bigEntry.getKey().equals(r.getType())) {
					if (bigEntry.getValue().keySet().contains(r.getKind())) {
						for (Entry<IKind, TreeSet<Reading>> smallEntry : bigEntry.getValue().entrySet()) {
							if (smallEntry.getKey().equals(r.getKind())) {
								if (r instanceof Magazine) {
									System.out.println("Magazines cannot be taken home");
								} else if (r instanceof Book) {
									r.addTakenToHistory(LocalDateTime.now());
									this.takenReadings.add(r);
									smallEntry.getValue().remove(r);
									this.numberOfReadings--;
									this.archive.put(r, new PeriodOutOfLibrary(LocalDateTime.now(), LocalDateTime.now().plus(Duration.ofSeconds(300))));
									System.out.println(r.name + " has been taken home on the " + r.getPeriod().getTaken());
								} else if (r instanceof TextBook) {
									r.addTakenToHistory(LocalDateTime.now());
									this.takenReadings.add(r);
									smallEntry.getValue().remove(r);
									this.numberOfReadings--;
									this.archive.put(r, new PeriodOutOfLibrary(LocalDateTime.now(), LocalDateTime.now().plus(Duration.ofSeconds(150))));
									System.out.println(r.name + " has been taken home on the " + r.getPeriod().getTaken());
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void returnReading(Reading r) {
		if (allReadings.containsKey(r.getType())) {
			for (Entry<Reading.ReadingType, TreeMap<IKind, TreeSet<Reading>>> bigEntry : allReadings.entrySet()) {
				if (bigEntry.getKey().equals(r.getType())) {
					if (bigEntry.getValue().keySet().contains(r.getKind())) {
						for (Entry<IKind, TreeSet<Reading>> smallEntry : bigEntry.getValue().entrySet()) {
							if (smallEntry.getKey().equals(r.getKind())) {
								smallEntry.getValue().add(r);
								PeriodOutOfLibrary p = this.archive.get(r);
								if (LocalDateTime.now().isAfter(p.getReturned())) {
									//Period diff = Period.between(LocalDateTime.now(), p.getReturned());
									
								}
								System.out.println(r.name + " has been returned " + r.getPeriod().getReturned());
								this.takenReadings.remove(r);
								this.numberOfReadings++;
							}
						}
					}
				}
			}
		}
	}
	
	public void printTextBooksByType() {
		for (Entry<Reading.ReadingType, TreeMap<IKind, TreeSet<Reading>>> bigEntry : allReadings.entrySet()) {
			System.out.println("\n-----" + bigEntry.getKey() + "-----");
			for (Entry<IKind, TreeSet<Reading>> smallEntry : bigEntry.getValue().entrySet()) {
				System.out.println("~~~~~"+smallEntry.getKey()+"~~~~~");
				for (Reading reading : smallEntry.getValue()) {
					System.out.println(reading.toString());
				}
			}
		}
	}
	
	public void printTakenReadings() {
		System.out.println("\n*** Taken readings ***");
		for (Reading reading : takenReadings) {
			System.out.println(reading.toString());
		}
	}
	
	public void printNumberOfAllReadsInLibrary() {
		System.out.println("Number of all reads in Library: " + this.numberOfReadings);
	}
}
