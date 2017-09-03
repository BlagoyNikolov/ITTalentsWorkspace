package library;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Reading {
	public enum ReadingType {
		BOOK, MAGAZINE, TEXTBOOK;
	}
	protected String name;
	protected IKind kind;
	protected ReadingType type;
	protected ArrayList<PeriodOutOfLibrary> history;
	
	public Reading(String name, ReadingType type) {
		this.name = name;
		this.type = type;
		this.history = new ArrayList<>();
	}
	
	public ReadingType getType() {
		return type;
	}
	
	public IKind getKind() {
		return kind;
	}
	
	public PeriodOutOfLibrary getPeriod() {
		return this.history.get(history.size() - 1);
	}
	
	public LocalDateTime getTaken() {
		return this.history.get(history.size() - 1).getTaken();
	}
	
	public void addTakenToHistory(LocalDateTime taken) {
		PeriodOutOfLibrary p = new PeriodOutOfLibrary(taken, null);
		p.setTaken(taken);
		this.history.add(p);
	}
	
	public void addReturnedToHistory(LocalDateTime returned) {
		PeriodOutOfLibrary p = this.history.get(history.size() - 1);
		p.setReturned(returned);
	}
}
