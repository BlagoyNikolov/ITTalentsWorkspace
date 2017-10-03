package booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Library {

	private ArrayList<Book> books;
	private Thread reporter;
	
	private class LibReporter implements Runnable{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				System.out.println(books);
			}
		}
	}
	
	public Library() {
		books = new ArrayList<>();
		books.add(new Book("Java za vseki", 10, 17));
		books.add(new Book("50 nuansa rozovo", 5, 30));
		books.add(new Book("Vinetu", 15, 5));
		books.add(new Book("Meteoriti na Dan", 20, 20));
		reporter = new Thread(new LibReporter());
		reporter.setDaemon(true);
		reporter.start();
	}

	public Book naemiKniga() {
		Book book = books.remove(new Random().nextInt(books.size()));
		book.hire();
		return book;
	}

	public void returnBook(Book b) {
		books.add(b);
		System.out.println(b.getName() + " is returned. Price to be payed = " + b.getPrice());
		b.retrieve();
	}
}
