package bus;
import java.util.ArrayList;
import java.util.List;

import exceptions.NotValidSeatNumberException;
import user.User;

public class Bus {

	private List<Seat> seats;
	private int numberOfSeats;
	private static int DEFAULT_NUMBER_OF_SEATS =50;

	
	public Bus(int numberOfSeats) {
		this.setNumberOfSeats(numberOfSeats);
		seats = new ArrayList<>();
		for (int i = 1; i <= numberOfSeats; i++) {
			try {
				seats.add(new Seat(i));
			} catch (NotValidSeatNumberException e) {
				e.printStackTrace();
			}
		}
	}

	public Bus(){
		this(DEFAULT_NUMBER_OF_SEATS);
	}
	private void setNumberOfSeats(int numberOfSeats) {
		if (numberOfSeats>0) {
			this.numberOfSeats= numberOfSeats;
		}else{
			this.numberOfSeats = DEFAULT_NUMBER_OF_SEATS;
		}
	}

	public Seat getSeatByNumber(int number) {
		if (number < 0 || number > numberOfSeats) {
			return null;
		}
		return seats.get(number - 1);
	}

	public synchronized boolean isSeatTaken(int number) {
		Seat seat = getSeatByNumber(number);
		if (seat!= null) {
			return seat.isTaken();
		}
		System.out.println("No such seat");
		return true;
	}
	
	public synchronized boolean areThereFreeSeats(){
		for (int i = 0; i < seats.size(); i++) {
			if (!seats.get(i).isTaken()) {
				return true;
			}
		}
		System.out.print("No free places");
		return false;
	}
	public synchronized boolean bookSeat(int number,User user){
		if (!isSeatTaken(number)) {
			Seat freeseat = getSeatByNumber(number);
			freeseat.setTaken(true);
			user.setSeat(freeseat);
			//System.out.println("You have successfully booked a seat!");
			return true;
		}else{
			//System.out.println("This seat is already taken. Please book a new one");
			return false;
		}
	}

	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}
}
