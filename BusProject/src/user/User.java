package user;

import java.util.Random;

import bus.Bus;
import bus.Seat;

public class User extends Thread {

	private Bus bus;
	private Seat seat;

	public User(Bus bus) {
		this.bus = bus;
	}

	@Override
	public void run() {
		while (seat == null) {
			if (!this.bus.areThereFreeSeats()) {
				System.out.println(" for " + this.getName());
				break;
			}
			int x = getRandomNumber();
			bus.bookSeat(x, this);
		}
		if (seat != null) {
			System.out.println("User " + this.getName() + " is in " + this.seat);
		}
	}

	private int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(bus.getNumberOfSeats()) + 1;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setBus(Bus bus) {
		if (bus != null) {
			this.bus = bus;
		}
	}

	public Bus getBus() {
		return this.bus;
	}
}
