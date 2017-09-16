package library;

import java.time.LocalDate;
import java.util.Random;

public class Magazine extends Reading implements Comparable<Magazine> {
	public enum Category implements IKind {
		FASHION, SCIENCE;
	}
	
	private int issueNumber;
	private LocalDate date;
	private String izdatelstvo;
	
	public Magazine(String name, int issueNumber, LocalDate date, String izdatelstvo, Category c) {
		super(name, ReadingType.MAGAZINE);
		this.issueNumber = issueNumber;
		this.date = date;
		this.izdatelstvo = izdatelstvo;
		//this.setRandomCategory();
		this.kind = c;
	}
	
	private void setRandomCategory() {
		int x = new Random().nextInt(2);
		switch (x) {
		case 0:
			this.kind = Category.FASHION;
			break;
		case 1:
			this.kind = Category.SCIENCE;
			break;
		default:
			break;
		}
	}

	@Override
	public int compareTo(Magazine o) {
		if (this.name.equals(o.name)) {
			return this.issueNumber - o.issueNumber;
		}
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Magazine [issueNumber=" + issueNumber + ", date=" + date + ", izdatelstvo=" + izdatelstvo + ", name="
				+ name + ", kind=" + kind + ", type=" + type + "]";
	}
}
