package cakes.bakery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import cakes.cake.Cake;
import cakes.cake.Cake.Type;
import cakes.cake.IKind;
import imoti.estates.Imot;

public class Bakery {
	private String name;
	private String address;
	private String phone;
	//private ArrayList<Cake> cakes;
	private Map<Cake.Type, TreeMap<IKind, List<Cake>>> cakes;
	private ArrayList<Supplier> suppliers;
	private double money;
	private static int numberOfCakes = 0;
	
	public Bakery(String name, String address, Map<Cake.Type, TreeMap<IKind, List<Cake>>> cakes, ArrayList<Supplier> suppliers) {
		this.name = name;
		this.address = address;
		this.cakes = cakes;
		this.suppliers = suppliers;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public void addMoney(double money) {
		this.money += money;
	}
	
	public boolean isCakeAvailable(Cake cake) {
		//return cakes.contains(cake);
		if (this.cakes.containsKey(cake.getType())) {
			for (Iterator<Entry<Cake.Type, TreeMap<IKind, List<Cake>>>> iterator = cakes.entrySet().iterator(); iterator.hasNext();) {
				Entry<Cake.Type, TreeMap<IKind, List<Cake>>> entry = iterator.next();
				if (entry.getKey().equals(cake.getType())) {
					for (Iterator<Entry<IKind, List<Cake>>> iterator2 = entry.getValue().entrySet().iterator(); iterator2.hasNext();) {
						Entry<IKind, List<Cake>> listOfCakes = iterator2.next();
						if (listOfCakes.getValue().contains(cake)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public void printAllCakesInBakery() {
		for (Iterator<Entry<Cake.Type, TreeMap<IKind, List<Cake>>>> iterator = this.cakes.entrySet().iterator(); iterator.hasNext();) {
			Entry<Cake.Type, TreeMap<IKind, List<Cake>>> entry = iterator.next();
			for (Iterator<Entry<IKind, List<Cake>>> iterator2 = entry.getValue().entrySet().iterator(); iterator2.hasNext();) {
				Entry<IKind, List<Cake>> listOfCakes = iterator2.next();
				System.out.println(listOfCakes.getValue());
			}
		}
	}
	
	public void addCake(Cake cake) {
		if (this.cakes.containsKey(cake.getType())) {
			for (Iterator<Entry<Cake.Type, TreeMap<IKind, List<Cake>>>> iterator = cakes.entrySet().iterator(); iterator.hasNext();) {
				Entry<Cake.Type, TreeMap<IKind, List<Cake>>> entry = iterator.next();
				if (entry.getKey().equals(cake.getType())) {
					for (Iterator<Entry<IKind, List<Cake>>> iterator2 = entry.getValue().entrySet().iterator(); iterator2.hasNext();) {
						Entry<IKind, List<Cake>> listOfCakes = iterator2.next();
						if (listOfCakes.getKey().equals(cake.getKind())) {
							if (listOfCakes.getValue().contains(cake)) {
								System.out.println("This cake has already been added!");
							} else {
								listOfCakes.getValue().add(cake);
							}
						}
					}
				}
			}
		} else {
			this.cakes.put(cake.getType(), new TreeMap<>());
			this.cakes.get(cake.getType()).put(cake.getKind(), new ArrayList<Cake>());
			this.cakes.get(cake.getType()).get(cake.getKind()).add(cake);
		}
	}
	
	public static void addCakeToMap(Cake cake, Map<Type, TreeMap<IKind, List<Cake>>> map) {
		if (map.containsKey(cake.getType())) {
			for (Iterator<Entry<Cake.Type, TreeMap<IKind, List<Cake>>>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
				Entry<Cake.Type, TreeMap<IKind, List<Cake>>> entry = iterator.next();
				if (entry.getKey().equals(cake.getType())) {
					for (Iterator<Entry<IKind, List<Cake>>> iterator2 = entry.getValue().entrySet().iterator(); iterator2.hasNext();) {
						Entry<IKind, List<Cake>> listOfCakes = iterator2.next();
						if (listOfCakes.getKey().equals(cake.getKind())) {
							if (listOfCakes.getValue().contains(cake)) {
								System.out.println("This cake has already been added!");
							} else {
								listOfCakes.getValue().add(cake);
								System.out.println("Cake added successfully");
							}
						} else {
							//System.out.println("1st here");
							//entry.getValue().get(cake.getKind()).add(cake);
							//System.out.println("Cake added successfully");
						}
					}
				} else {
					//System.out.println("2nd here");
					entry.getValue().get(cake.getKind()).add(cake);
					System.out.println("Cake added successfully");
				}
			}
		} else {
			map.put(cake.getType(), new TreeMap<>());
			map.get(cake.getType()).put(cake.getKind(), new ArrayList<Cake>());
			map.get(cake.getType()).get(cake.getKind()).add(cake);
			System.out.println("Cake added successfully");
		}
		numberOfCakes++;
		System.out.println(numberOfCakes);
	}
	
	public Cake getRandomCakeFromBakery() {
		//return this.cakes.get(new Random().nextInt(this.cakes.size()));
		Random r = new Random();
		int i = 0;
		int index = r.nextInt(numberOfCakes);
		for (Iterator<Entry<Cake.Type, TreeMap<IKind, List<Cake>>>> iterator = this.cakes.entrySet().iterator(); iterator.hasNext();) {
			Entry<Cake.Type, TreeMap<IKind, List<Cake>>> entry = iterator.next();
			for (Iterator<Entry<IKind, List<Cake>>> iterator2 = entry.getValue().entrySet().iterator(); iterator2.hasNext();) {
				Entry<IKind, List<Cake>> listOfCakes = iterator2.next();
				for (Iterator<Cake> iterator3 = listOfCakes.getValue().iterator(); iterator3.hasNext();) {
					Cake cake = iterator3.next();
					if (i == index) {
						return cake;
					}
					i++;
				}
			}
		}
		return null;
	}
	
	public Supplier getRandomSupplier() {
		return this.suppliers.get(new Random().nextInt(this.suppliers.size()));
	}

	public void removeCake(Cake cake) {
		this.cakes.remove(cake);
	}
	
//	public int getAllAvailableCakes() {
//		int counter = 0;
//		for (Cake cake : cakes) {
//			counter++;
//			System.out.print(cake.toString());
//		}
//		return counter;
//	}
}
