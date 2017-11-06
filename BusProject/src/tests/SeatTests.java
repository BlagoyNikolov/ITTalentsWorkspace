package tests;

import org.junit.Assert;
import org.junit.Test;

import bus.Bus;
import bus.Seat;
import exceptions.NotValidSeatNumberException;
import user.User;

public class SeatTests {

	private Bus bus = new Bus();

	@Test(expected = NotValidSeatNumberException.class)
	public void whenCreatingSeatWithInvalidNumberExceptionShouldBeThrown() throws NotValidSeatNumberException {
		Seat seat = new Seat(-10);
		Assert.assertSame(seat, null);
	}

	@Test
	public void whenCreatingSeatWithValidNumberNewSeatShouldBeCreated() throws NotValidSeatNumberException {
		Seat seat = new Seat(17);
		Assert.assertNotNull(seat);
	}

	@Test
	public void whenUserBooksFreeSeatItBecomesTaken() {
		int wantedFreeSeat = 5;
		User u = new User(bus);
		boolean isTaken = bus.getSeatByNumber(wantedFreeSeat).isTaken();
		bus.bookSeat(wantedFreeSeat, u);
		boolean isTakenAfterBooking = bus.getSeatByNumber(wantedFreeSeat).isTaken();
		Assert.assertNotEquals(isTaken, isTakenAfterBooking);

	}
	
	@Test
	public void whenCreateBusWithLessThanZeroSeatsFiftySeatsAreSetToIt(){
		Bus bus = new Bus(-20);
		Assert.assertEquals(bus.getNumberOfSeats(),50);
	}

}
