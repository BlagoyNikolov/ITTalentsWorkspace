package test3lutenica.brigada;

import java.util.Random;

import test3lutenica.resources.Baraka;
import test3lutenica.resources.Kuhnq;
import test3lutenica.veggies.Chushka;
import test3lutenica.veggies.Domat;
import test3lutenica.veggies.Patlajan;
import test3lutenica.veggies.VegType;
import test3lutenica.veggies.Vegetable;

public class Momuk extends Person {
	private VegType vegType;
	private int quantity;
	private Baraka baraka;
	private Kuhnq kuhnq;
	private int secondsWorked;

	public Momuk(String name, Baraka baraka, Kuhnq kuhnq) {
		super(name, new Random().nextInt(11) + 15);
		this.baraka = baraka;
		this.kuhnq = kuhnq;
	}

	@Override
	public void run() {
		while (true) {
			Vegetable v = getRandomVegetable();
			this.baraka.removeFromBarakata(v.getType(), this);
			try {
				Thread.sleep(v.getTimeToProcess());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.secondsWorked += v.getTimeToProcess();
			this.kuhnq.addToKuhnqta(v, this);
		}
	}

	public Vegetable getRandomVegetable() {
		int x = new Random().nextInt(3);
		switch (x) {
		case 0:
			return new Domat("Domat");
		case 1:
			return new Chushka("Chushka");
		case 2:
			return new Patlajan("Patl");
		default:
			return null;
		}
	}
	
	public int getSecondsWorked() {
		return secondsWorked;
	}
	
	@Override
	public String getPersonName() {
		return this.name;
	}
}
