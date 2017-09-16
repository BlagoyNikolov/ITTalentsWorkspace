package library;

import java.time.LocalDate;

import library.Book.Genre;
import library.Magazine.Category;

public class Demo {
	public static void main(String[] args) {
		Library l = new Library("Talents");
		
		Book b = new Book("Hunger Games", "Somebody", LocalDate.of(1999, 06, 27), "whoknows", Genre.ROMAN);
		Magazine m = new Magazine("Men's Health", 25, LocalDate.of(2017, 8, 23), "nz", Category.FASHION);
		
		l.addReading(b);
		l.takeReading(b);
		
		l.printTextBooksByType();
		l.printNumberOfAllReadsInLibrary();
		l.printTakenReadings();
	}
}
