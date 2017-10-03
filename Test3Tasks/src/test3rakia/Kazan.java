package test3rakia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class Kazan {
	private FruitType fruitType;
	private static final int MAX_CAPACITY = 10;
	private static final int MIN_CAPACITY = 0;
	private int capacity;
	private String name;
	private List<Rakia> rakii;
	private TreeMap<FruitType, Integer> rakiiStats;
	
	public Kazan(String name) {
		this.name = name;
		this.rakii = new ArrayList<>();
		this.rakiiStats = new TreeMap<FruitType, Integer>();
		this.rakiiStats.put(FruitType.GROZDE, 0);
		this.rakiiStats.put(FruitType.KAISII, 0);
		this.rakiiStats.put(FruitType.SLIVI, 0);
		//this.writeToFile();
	}

	public synchronized void addToKazana(Berach b, int quantity) {
		this.setFruitType(b.getFruitType());
		//System.out.println(this.name + " FRUIT TYPE SET! " + this.getFruitType());
		if (b != null && b.getFruitType().equals(this.fruitType)) {
			while (this.capacity >= MAX_CAPACITY) {	
				try {
					//this.setFruitType(null);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.capacity += quantity;
			this.rakiiStats.put(this.getFruitType(), rakiiStats.get(this.getFruitType()) + quantity);
			System.out.println(this.name + ": " + quantity + " " + this.getFruitType() + " added to kazana; now is " + this.capacity);
			notifyAll();
		} else {
			System.out.println("INVALID FRUIT BERACH!!");
		}
	}
	
	public synchronized void removeFromKazana(RakiaMan r) {
		while (this.capacity <= MIN_CAPACITY) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int quantity = new Random().nextInt(this.capacity);
		this.capacity -= quantity;
		Rakia rakia = new Rakia(r.getPersonName(), LocalDateTime.now(), this.getFruitType(), quantity);
		this.addRakiaToRakii(rakia);
		System.out.println(this.name + ":  " + this.getFruitType() + " removed from kazana; now is " + this.capacity);
		notifyAll();
	}
	
	private void addRakiaToRakii(Rakia r) {
		this.rakii.add(r);
	}
	
	public FruitType getFruitType() {
		return fruitType;
	}
	
	public void setFruitType(FruitType fruitType) {
		this.fruitType = fruitType;
	}
	
	public List<Rakia> getRakii() {
		return Collections.unmodifiableList(this.rakii);
	}
	
	public void writeToFile() {
		try {
			while (true) {
				try {
					Thread.sleep(3*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintStream ps = new PrintStream(new File("rakia-" + this.name + ".txt"));
				Thread writer = new Thread(() -> {
					ps.println(findMaxRakia());
					System.out.println(findMaxRakia());
				});
				writer.setDaemon(true);
				writer.start();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String findMaxRakia() {
		int max = 0;
		int current = 0;
		FruitType maxFruitType = null;
		FruitType currentFruitType = null;
		for (Entry<FruitType, Integer> rakia : rakiiStats.entrySet()) {
			current = rakia.getValue();
			currentFruitType = rakia.getKey();
			if (current > max) {
				max = current;
				maxFruitType = currentFruitType;
			}
		}
		return "MAX RAKIA IS OF TYPE: " + maxFruitType + " AND QUANTITY OF: " + max;
	}
}
