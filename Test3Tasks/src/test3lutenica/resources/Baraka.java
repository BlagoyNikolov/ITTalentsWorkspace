package test3lutenica.resources;

import java.util.ArrayList;

import test3lutenica.brigada.Moma;
import test3lutenica.brigada.Momuk;
import test3lutenica.veggies.VegType;

public class Baraka {
	private ArrayList<Basket> baskets;
	
	public Baraka() {
//		this.tomatoBasket = new TreeMap<VegType, Integer>();
//		this.patlajanBasket = new TreeMap<VegType, Integer>();
//		this.chushkaBasket = new TreeMap<VegType, Integer>();
//		this.tomatoBasket.put(VegType.DOMAT, 40);
//		this.patlajanBasket.put(VegType.PATLAJAN, 40);
//		this.chushkaBasket.put(VegType.CHUSHKA, 40);
		this.baskets = new ArrayList<Basket>();
		this.baskets.add(new Basket("DomatoBasket", VegType.DOMAT));
		this.baskets.add(new Basket("PatlajanBasket", VegType.PATLAJAN));
		this.baskets.add(new Basket("ChushkaBasket", VegType.CHUSHKA));
	}
	
	public synchronized void addToBarakata(Moma m) {
		while (hasEnough(m)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Basket b = getBasket(m.getVegType());
		for (Basket basket : baskets) {
			if (basket.equals(b)) {
				basket.addQuantity(m.getQuantity());
				System.out.println(m.getPersonName() + " added " + m.getQuantity() + " of " + m.getVegType() + " to barakata");
			}
		}
		notifyAll();
	}
	
	public synchronized void removeFromBarakata(VegType type, Momuk m) {
		while (isEmpty(type)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Basket b = getBasket(type);
		for (Basket basket : baskets) {
			if (basket.equals(b)) {
				b.removeQuantity(1);
				System.out.println(m.getPersonName() + " removed " + 1 + " of " + type + " from barakata");
			}
		}
		notifyAll();
	}

	private boolean isEmpty(VegType type) {
		Basket b = getBasket(type);
		if (b.getQuantity() <= 0) {
			return true;
		}
		return false;
	}

	private boolean hasEnough(Moma m) {
		VegType type = m.getVegType();
		Basket basket = getBasket(type);
		if (basket.getQuantity() >= 40) {
			return true;
		}
		return false;
	}
	
	private Basket getBasket(VegType type) {
		for (Basket basket : baskets) {
			if (basket.getVegtype().equals(type)) {
				return basket;
			}
		}
		return null;
	}
}
