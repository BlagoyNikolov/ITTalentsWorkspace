package test3lutenica.resources;

import java.util.ArrayList;

import test3lutenica.brigada.Baba;
import test3lutenica.brigada.Momuk;
import test3lutenica.veggies.VegType;
import test3lutenica.veggies.Vegetable;

public class Kuhnq {
	private ArrayList<Tava> tavi;
	
	public Kuhnq() {
		this.tavi = new ArrayList<Tava>();
		this.tavi.add(new Tava("DomatoTava", VegType.DOMAT));
		this.tavi.add(new Tava("PatlajanTava", VegType.PATLAJAN));
		this.tavi.add(new Tava("ChushkaTava", VegType.CHUSHKA));
	}
	
	public synchronized void addToKuhnqta(Vegetable v, Momuk m) {
		while (hasEnough(v)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Tava t = getTava(v.getType());
		for (Tava tava : tavi) {
			if (tava.equals(t)) {
				tava.addQuantity(1);
				System.out.println(m.getPersonName() + " added 1 of " + v.getType() + " to the kuhnqta");
			}
		}
		notifyAll();
	}
	
	public synchronized void removeFromKuhnqta(VegType type, Baba b) {
		while (isEmpty(type)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Tava t = getTava(type);
		for (Tava tava : tavi) {
			if (tava.equals(t)) {
				tava.removeQuantity(5);
				System.out.println(b.getPersonName() + " removed 5 of " + type + " from the kuhnqta");
			}
		}
		notifyAll();
	}

	private boolean isEmpty(VegType type) {
		Tava t = getTava(type);
		if (t.getQuantity() <= 0) {
			return true;
		}
		return false;
	}

	private boolean hasEnough(Vegetable v) {
		VegType type = v.getType();
		Tava tava = getTava(type);
		if (tava.getQuantity() >= 30) {
			return true;
		}
		return false;
	}
	
	private Tava getTava(VegType type) {
		for (Tava tava : this.tavi) {
			if (tava.getVegtype().equals(type)) {
				return tava;
			}
		}
		return null;
	}
}
