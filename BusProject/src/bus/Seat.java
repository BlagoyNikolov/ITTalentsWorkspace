package bus;
import exceptions.NotValidSeatNumberException;

public class Seat {
	
	private int number;
	private boolean isTaken;
	
	public Seat(int number) throws NotValidSeatNumberException{
		setNumber(number);
		this.isTaken= false;
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) throws NotValidSeatNumberException {
		if (number>0 && number<=50) {
			this.number = number;
		}else{
			throw new NotValidSeatNumberException("Not valid seat number");
		}
		
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	@Override
	public String toString() {
		return "Seat [number=" + number + "]";
	}

	
}
