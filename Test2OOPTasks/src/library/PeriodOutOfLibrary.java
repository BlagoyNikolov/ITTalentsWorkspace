package library;

import java.time.LocalDateTime;

public class PeriodOutOfLibrary {
	private LocalDateTime taken;
	private LocalDateTime returned;
	
	public PeriodOutOfLibrary(LocalDateTime taken, LocalDateTime returned) {
		this.taken = taken;
		this.returned = taken;
	}
	
	public LocalDateTime getTaken() {
		return taken;
	}
	
	public void setTaken(LocalDateTime taken) {
		this.taken = taken;
	}
	
	public LocalDateTime getReturned() {
		return returned;
	}
	
	public void setReturned(LocalDateTime returned) {
		this.returned = returned;
	}
}
