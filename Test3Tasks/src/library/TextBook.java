package library;

import java.time.LocalDate;
import java.util.Random;

public class TextBook extends Reading implements Comparable<TextBook>, Takeable {
	public enum Theme implements IKind {
		HISTORY, PROGRAMMING;
	}
	
	private String author;
	private LocalDate date;
	private String izdatelstvo;
	private final double price = 3;

	public TextBook(String name, String author, LocalDate date, String izdatelstvo, Theme t) {
		super(name, ReadingType.TEXTBOOK);
		this.author = author;
		this.date = date;
		this.izdatelstvo = izdatelstvo;
		//this.setRandomTheme();
		this.kind = t;
	}
	
	private void setRandomTheme() {
		int x = new Random().nextInt(2);
		switch (x) {
		case 0:
			this.kind = Theme.HISTORY;
			break;
		case 1:
			this.kind = Theme.PROGRAMMING;
			break;
		default:
			break;
		}
	}

	@Override
	public int compareTo(TextBook o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "TextBook [author=" + author + ", date=" + date + ", izdatelstvo=" + izdatelstvo + ", name=" + name
				+ ", kind=" + kind + ", type=" + type + ", history=" + history + "]";
	}

	@Override
	public double getPrice() {
		return price;
	}
}
