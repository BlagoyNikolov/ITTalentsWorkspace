package test3lutenica.brigada;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import test3lutenica.resources.Kuhnq;
import test3lutenica.resources.Partida;
import test3lutenica.veggies.VegType;

public class Baba extends Person {
	private Kuhnq kuhnq;
	private ArrayList<Partida> partidi;

	public Baba(String babaName, int vegQuantity) {
		super(babaName, vegQuantity);
	}
	
	public Baba(String name, Kuhnq kuhnq) {
		super(name, new Random().nextInt(21) + 35);
		this.kuhnq = kuhnq;
		this.partidi = new ArrayList<Partida>();
	}
	
	@Override
	public void run() {
		while (true) {
			this.kuhnq.removeFromKuhnqta(VegType.CHUSHKA, this);
			this.kuhnq.removeFromKuhnqta(VegType.PATLAJAN, this);
			this.kuhnq.removeFromKuhnqta(VegType.DOMAT, this);
			try {
				Thread.sleep(10*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Partida p = new Partida(LocalDateTime.now());
			System.out.println("Lutenica just made! Adding to partidi of " + this.getPersonName());
			this.partidi.add(p);
			printPartidi();
		}
	}

	public List<Partida> getPartidi() {
		return Collections.unmodifiableList(partidi);
	}
	
	@Override
	public String getPersonName() {
		return this.name;
	}
	
	private void printPartidi() {
		System.out.println("---" + this.getPersonName() + " PARTIDI---");
		for (Partida partida : partidi) {
			System.out.println(partida);
		}
		System.out.println("----------------");
	}
}
