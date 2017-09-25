package musicinstruments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import musicinstruments.instruments.Drum;
import musicinstruments.instruments.Guitar;
import musicinstruments.instruments.Instrument;
import musicinstruments.instruments.Piano;
import musicinstruments.instruments.Instrument.InstrumentType;
import java.util.TreeMap;
import java.util.TreeSet;

public class Shop {
	private String name;
	private TreeMap<InstrumentType, TreeMap<String, Instrument>> instruments;
	private double money;
	private double incomeFromSales;
	private HashMap<Instrument, Integer> soldInstruments;
	public static final int MIN_QUANTITY = 2;
	
	public Shop(String name) {
		this.name = name;
		this.instruments = new TreeMap<>();
		this.soldInstruments = new HashMap<>();
		//this.instruments.put(InstrumentType.BLOW, new TreeMap<>());
		//this.instruments.put(InstrumentType.ELECTRONIC, new TreeMap<>());
		
		// Type -> ( name -> instrument);
		this.instruments.put(InstrumentType.HIT, new TreeMap<>());
		this.instruments.put(InstrumentType.KEY, new TreeMap<>());
		this.instruments.put(InstrumentType.STRING, new TreeMap<>());
		this.instruments.get(InstrumentType.STRING).put("Fender", new Guitar("Fender", 900, 7));
		this.instruments.get(InstrumentType.STRING).put("Zender", new Guitar("Zender", 100, 10));
		this.instruments.get(InstrumentType.STRING).put("Orfei", new Guitar("Orfei", 100, 4));
		this.instruments.get(InstrumentType.KEY).put("Yamaha", new Piano("Yamaha", 2100, 8));
		this.instruments.get(InstrumentType.KEY).put("Lassy", new Piano("Lassy", 500, 2));
		this.instruments.get(InstrumentType.HIT).put("Yamaha", new Drum("Yamaha", 1200, 6));
		this.instruments.get(InstrumentType.HIT).put("Pearls", new Drum("Pearls", 1500, 12));
	}
	
	public double getMoney() {
		return money;
	}
	
	public double getIncomeFromSales() {
		return incomeFromSales;
	}
	
	public synchronized void sell(String name, int quantity) {
		while(insufficient(name, quantity)){
			try {
				System.out.println("Client waiting");
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		removeQuantities(name, quantity);
		notifyAll();
	}
	
	private boolean insufficient(String name, int quantity) {
		for (InstrumentType type : this.instruments.keySet()) {
			if (this.instruments.get(type).containsKey(name)) {
				Instrument i = this.instruments.get(type).get(name);
				if(i.getAvailability() < MIN_QUANTITY){
					return true;
				}
			}
		}
		return false;
	}
	
	public void removeQuantities(String name, int quantity) {
		for (InstrumentType type : this.instruments.keySet()) {
			if (this.instruments.get(type).containsKey(name)) {
				Instrument i = this.instruments.get(type).get(name);
				//if (quantity < i.getAvailability()) {
					i.decreaseQuantity(quantity);
					this.money += i.getPrice() * quantity;
					this.incomeFromSales += i.getPrice() * quantity;
					System.out.println(i.getType() + " " + i.getName() + " sold!");
					if (soldInstruments.containsKey(i)) {
						this.soldInstruments.put(i, soldInstruments.get(i) + quantity);
					}else{
						this.soldInstruments.put(i, quantity);
					}
//				} else {
//					System.out.println("Not enough uits available; currently available: " + i.getAvailability());
//				}
				break;
			}
		}
	}
	
	public synchronized void buy() {
		while(!hasInsufficient()){
			try {
				System.out.println("Supplier waiting");
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		fillQuantities();
		notifyAll();
	}
	
	private boolean hasInsufficient() {
		for (Entry<InstrumentType, TreeMap<String, Instrument>> entry : instruments.entrySet()) {
			for (Entry<String, Instrument> instrument : entry.getValue().entrySet()) {
				if(instrument.getValue().getAvailability() < MIN_QUANTITY){
					return true;
				}
			}
		}
		return false;
	}
	
	private void fillQuantities() {
		for (Entry<InstrumentType, TreeMap<String, Instrument>> entry : instruments.entrySet()) {
			for (Entry<String, Instrument> instrument : entry.getValue().entrySet()) {
				Instrument i = instrument.getValue();
				if(i.getAvailability() < MIN_QUANTITY){
					System.out.println(i.getType() + " " + i.getName() + " bought!");
					i.increaseQuantity(5);
				}
			}
		}
	}
	
	public void printInstrumentsByType() {
		for (Entry<InstrumentType, TreeMap<String, Instrument>> entry : instruments.entrySet()) {
			System.out.println("-----" + entry.getKey() + "-----");
			for (Entry<String, Instrument> instrument : entry.getValue().entrySet()) {
				System.out.println(instrument.getValue().toString());
			}
		}
	}
	
	public void printInstrumentsByName() {
		System.out.println("\n=====BY NAME======");
		ArrayList<Instrument> entries = new ArrayList<>();
		for (TreeMap<String, Instrument> map : this.instruments.values()) {
			entries.addAll(map.values());
		}
		entries.sort(new Comparator<Instrument>() {
			@Override
			public int compare(Instrument o1, Instrument o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (Instrument musicInstrument : entries) {
			System.out.println(musicInstrument.toString());
		}
	}
	
	public void KRASIprintInstrumentsByName() {
		System.out.println("\n=====BY NAME======");
		TreeSet<Instrument> set = new TreeSet<>();
//		for (InstrumentType type : instruments.keySet()) {
//			set.addAll(instruments.get(type).values());
//		}
		for (TreeMap<String, Instrument> map : instruments.values()) {
			set.addAll(map.values());
		}
		
		for (Instrument instrument : set) {
			System.out.println(instrument);
		}
	}
	
	public void printInstrumentsByPrice(boolean ascending) {
		System.out.println("\n=====BY PRICE Ascending: " + ascending + "======");
		ArrayList<Instrument> entries = new ArrayList<>();
		for (TreeMap<String, Instrument> map : this.instruments.values()) {
			entries.addAll(map.values());
		}
		if (ascending) {
			entries.sort(new Comparator<Instrument>() {
				@Override
				public int compare(Instrument o1, Instrument o2) {
					return Double.compare(o1.getPrice(), o2.getPrice());
				}
			});
		} else {
			entries.sort(new Comparator<Instrument>() {
				@Override
				public int compare(Instrument o1, Instrument o2) {
					return Double.compare(o2.getPrice(), o1.getPrice());
				}
			});
		}
		for (Instrument musicInstrument : entries) {
			System.out.println(musicInstrument.toString());
		}
	}
	
	public void KRASIprintInstrumentsByPrice(boolean ascending) {
		System.out.println("\n=====BY PRICE Ascending: " + ascending + "======");
		TreeSet<Instrument> set = new TreeSet<>(
			(o1, o2) -> {
				if(ascending) {
					return Double.compare(o1.getPrice(), o2.getPrice());
				} else {
					return Double.compare(o2.getPrice(), o1.getPrice());
				}
			});
		for (TreeMap<String, Instrument> map : instruments.values()) {
			set.addAll(map.values());
		}
		for (Instrument instrument : set) {
			System.out.println(instrument);
		}
	}
	
	public void printInstrumentsByAvailability() {
		System.out.println("\n=====BY AVAILABILITY======");
		ArrayList<Instrument> entries = new ArrayList<>();
		for (TreeMap<String, Instrument> map : this.instruments.values()) {
			entries.addAll(map.values());
		}
		entries.sort(new Comparator<Instrument>() {
			@Override
			public int compare(Instrument o1, Instrument o2) {
				return o1.getAvailability() - o2.getAvailability();
			}
		});
		for (Instrument musicInstrument : entries) {
			if (musicInstrument.getAvailability() > 0) {
				System.out.println(musicInstrument.toString());
			}
		}
	}
	
	public void KRASIprintInstrumentsByAvailability() {
		System.out.println("\n=====AVAILABLE INSTRUMENTS======");
		for (InstrumentType type : this.instruments.keySet()) {
			System.out.println("-----"+type+"-----");
			for (Instrument iterable_element : this.instruments.get(type).values()) {
				if (iterable_element.getAvailability() > 0) {
					System.out.println(iterable_element);
				}
			}
		}
	}
	
	public void printSoldInstruments() {
		ArrayList<Entry<Instrument, Integer>> entries = new ArrayList<>();
		entries.addAll(this.soldInstruments.entrySet());
		entries.sort(new Comparator<Entry<Instrument, Integer>>() {
			@Override
			public int compare(Entry<Instrument, Integer> o1, Entry<Instrument, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		for (Entry<Instrument, Integer> entry : entries) {
			System.out.println(entry.getKey().toString() + " SOLD ITEMS: " + entry.getValue());
		}
	}
	
	public void printMostAndLeastSoldInstrument() {
		ArrayList<Entry<Instrument, Integer>> entries = new ArrayList<>();
		entries.addAll(this.soldInstruments.entrySet());
		entries.sort(new Comparator<Entry<Instrument, Integer>>() {
			@Override
			public int compare(Entry<Instrument, Integer> o1, Entry<Instrument, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		System.out.println("Most sold instrument " + entries.get(entries.size()-1).toString());
		System.out.println("Least sold instrument " + entries.get(0).toString());
	}

	public void printMostSoldType() {
		System.out.println("\n=====MOST SOLD TYPE======");
		InstrumentType mostSold = null;
		int maxCount = 0;
		for (InstrumentType type : this.instruments.keySet()) {
			int countSales = 0;
			for (Instrument instrument : this.instruments.get(type).values()) {
				countSales += soldInstruments.get(instrument) == null ? 0 : soldInstruments.get(instrument);
			}
			if (countSales > maxCount) {
				maxCount = countSales;
				mostSold = type;
			}
		}
		System.out.println("The most sold type is " + mostSold);
	}
	
	public void printMostProfitableType() {
		System.out.println("\n=====MOST PROFITABLE TYPE======");
		InstrumentType mostProfitable = null;
		double maxMoney = 0;
		for (InstrumentType type : this.instruments.keySet()) {
			double money = 0;
			for (Instrument instrument : this.instruments.get(type).values()) {
				money += soldInstruments.get(instrument) == null ? 0 : instrument.getPrice() * soldInstruments.get(instrument);
			}
			if (money > maxMoney) {
				maxMoney = money;
				mostProfitable = type;
			}
		}
		System.out.println("The most profitable type is " + mostProfitable);
	}
}
