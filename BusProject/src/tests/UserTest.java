package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import bus.Bus;
import bus.Seat;
import user.User;

public class UserTest {
	
	private Bus bus= new Bus();
	@Test
	public void whenSetNullBusToUserWithNotNullBusTheOldReamins(){
		User user = new User(bus);
		user.setBus(null);
		Assert.assertNotNull(user.getBus());
		
	}

	@Test
	public void whenTwoUsersTryToGetTheSameSeatOnlyOneGetsIt(){
		User user1 = new User(bus);
		User user2 = new User(bus);
		bus.bookSeat(1, user1);
		bus.bookSeat(1, user2);
		Assert.assertNotEquals(user1.getSeat(), user2.getSeat());
		
	}
	
	@Test
	 public void whenUsersAreMoreThanSeatsSomeUsersLeaveWithoutSeat() throws InterruptedException{
		Bus twoSeatBus= new Bus(2);
		User user1 = new User(twoSeatBus);
		user1.start();
		User user2 = new User(twoSeatBus);
		user2.start();
		User user3 = new User(twoSeatBus);
		user3.start();
		User user4 = new User(twoSeatBus);
		user4.start();
		Thread.sleep(1000);
		Set<Seat> set = new HashSet<Seat>();
		set.add(user1.getSeat());
		set.add(user2.getSeat());
		set.add(user3.getSeat());
		set.add(user4.getSeat());
		Assert.assertNotEquals(set.size(), 4);
		
	}

	@Test
	public void whenUserTriesToBookNotExistingSeatTheProgramDoesNotCrush(){
		User user = new User(bus);
		System.out.println(bus.bookSeat(-10, user));
		boolean isSuccessful= bus.bookSeat(-10, user);
		
		Assert.assertFalse(isSuccessful);
	}
	
}
