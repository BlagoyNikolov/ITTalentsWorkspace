package test3lutenica.brigada;

import java.util.Random;

import test3lutenica.resources.Baraka;
import test3lutenica.veggies.VegType;

public class Moma extends Person {
	private VegType vegType;
	private int quantity;
	private Baraka baraka;
	
	public Moma(String name, int age) {
		super(name, age);
	}
	
	public Moma(String name, VegType vegType, Baraka baraka) {
		super(name, new Random().nextInt(6) + 14);
		//this.vegType = VegType.getRandomVegType();
		this.vegType = vegType;
		this.baraka = baraka;
	}
	
	@Override
	public void run() {
		while (true) {
			this.vegType = VegType.getRandomVegType();
			this.setVegType(this.vegType);
			this.setQuantity();
			this.baraka.addToBarakata(this);
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public VegType getVegType() {
		return vegType;
	}
	
	public void setVegType(VegType vegType) {
		this.vegType = vegType;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity() {
		this.quantity = new Random().nextInt(4) + 3;
	}

	@Override
	public String getPersonName() {
		return this.name;
	}
}
