package booking;

public class Nerd extends Thread{

	private Library lib;
	
	public Nerd(Library britishLib) {
		this.lib = britishLib;
	}

	@Override
	public void run() {
		naemiKniga();
	}
	
	public void naemiKniga() {
		Book b = lib.naemiKniga();
		System.out.println("Naeta e " + b.getName() + " za " + b.getRentalDuration() + " and initial price = " + b.getPrice());
		try {
			Thread.sleep(12_000);
		} catch (InterruptedException e) {
		}
		lib.returnBook(b);
	}

}
