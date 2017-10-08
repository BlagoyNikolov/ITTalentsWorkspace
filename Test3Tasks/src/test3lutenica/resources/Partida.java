package test3lutenica.resources;

import java.time.LocalDateTime;
import java.util.Random;

public class Partida {
	private LocalDateTime date;
	private int quantity;
	
	public Partida(LocalDateTime date) {
		this.date = date;
		this.quantity = new Random().nextInt(10) + 3;
	}
	
	public LocalDateTime getDate() {
		return this.date;
	}

	public int getQuantity() {
		return this.quantity;
	}

	@Override
	public String toString() {
		return "Partida: date: " + date + ", quantity: " + quantity;
	}
}
