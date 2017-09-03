package library;

import java.time.LocalDate;
import java.util.Random;

public class Book extends Reading implements Comparable<Book>, Takeable {
	public enum Genre implements IKind {
		ROMAN, THRILLER;
	}
	
	private String author;
	private LocalDate date;
	private String izdatelstvo;
	private final double price = 2;

	public Book(String name, String author, LocalDate date, String izdatelstvo, Genre g) {
		super(name, Reading.ReadingType.BOOK);
		this.author = author;
		this.date = date;
		this.izdatelstvo = izdatelstvo;
		//this.setRandomGenre();
		this.kind = g;
	}

	private void setRandomGenre() {
		int x = new Random().nextInt(2);
		switch (x) {
		case 0:
			this.kind = Genre.ROMAN;
			break;
		case 1:
			this.kind = Genre.THRILLER;
			break;
		default:
			break;
		}
	}

	@Override
	public int compareTo(Book o) {
		if ( this.date.equals(o.date)) {
			return this.name.compareTo(o.name);
		}
		return o.date.compareTo(this.date);
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", date=" + date + ", izdatelstvo=" + izdatelstvo + ", name=" + name
				+ ", kind=" + kind + ", type=" + type + "]";
	}

	@Override
	public double getPrice() {
		return price;
	}
}
