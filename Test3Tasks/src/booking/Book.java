package booking;

public class Book {

	private String name;
	private int rentalDuration;
	private double price;
	private boolean isReturned = true;
	
	public Book(String name, int rentalDuration, double price) {
		this.name = name;
		this.rentalDuration = rentalDuration;
		this.price = price;
	}
	
	public int getRentalDuration() {
		return rentalDuration;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void modifyPrice(double percent){
		this.price*=(1 + percent/100);
	}

	public void hire() {
		isReturned = false;
		new Thread(){
			public void run() {
				//sleep for the duration of the rent
				try {
					Thread.sleep(rentalDuration*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(isReturned){
					return;
				}
				else{
					while(true){
						modifyPrice(10);
						System.out.println("The book is not yet returned! Add interest to the price = " + price);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(isReturned){
							return;
						}
					}
				}
				//then check every day if the book is returned
				//if not - add interest to the price
				//if returned - die.
			};
		}.start();
	}
	
	public void retrieve(){
		this.isReturned = true;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
