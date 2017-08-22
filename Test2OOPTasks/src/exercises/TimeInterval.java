package exercises;

import java.time.LocalTime;

public class TimeInterval /*implements Comparable<TimeInterval>*/ {
	private LocalTime arrival;
	private LocalTime departure;
	
	public TimeInterval(LocalTime arrival, LocalTime departure) {
		this.arrival = arrival;
		this.departure = departure;
	}
	
	public LocalTime getArrival() {
		return arrival;
	}
	
	public LocalTime getDeparture() {
		return departure;
	}

	@Override
	public String toString() {
		return "TimeInterval [arrival=" + arrival + ", departure=" + departure + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeInterval other = (TimeInterval) obj;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		return true;
	}

	/*@Override
	public int compareTo(TimeInterval other) {
		if (arrival.getHour() == other.arrival.getHour()) {
			return arrival.getMinute() - other.arrival.getMinute();
		}
		return arrival.getHour() - other.arrival.getHour();
	}*/
}
