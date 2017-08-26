package cakes.bakery;

import java.util.ArrayList;
import java.util.Comparator;
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
import cakes.cake.Juvenile;
import cakes.cake.Special;
import cakes.cake.Standard;
import cakes.cake.Wedding;
import imoti.estates.Imot;

public class Bakery {
	private String name;
	private String address;
	private String phone;
	private Map<Cake.Type, TreeMap<IKind, List<Cake>>> cakes;
	private ArrayList<Supplier> suppliers;
	private double money;
	private static int numberOfCakes = 0;

	public Bakery(String name, String address, ArrayList<Supplier> suppliers) {
		this.name = name;
		this.address = address;
		this.suppliers = suppliers;
		this.cakes = new TreeMap<Cake.Type, TreeMap<IKind, List<Cake>>>();
//		this.cakes.put(Cake.Type.STANDARD, new TreeMap<IKind, List<Cake>>());
//		this.cakes.put(Cake.Type.SPECIAL, new TreeMap<IKind, List<Cake>>());
//		this.cakes.put(Cake.Type.WEDDING, new TreeMap<IKind, List<Cake>>());
//		this.cakes.put(Cake.Type.JUVENILE, new TreeMap<IKind, List<Cake>>());
		this.generateCakes();
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
	
	public static int getNumberOfCakes() {
		return numberOfCakes;
	}
	
	public void generateCakes() {
		for (int i = 0; i < 30; i++) {
			int x = new Random().nextInt(4);
			switch (x) {
			case 0:
				this.addCake(new Standard());
				break;
			case 1:
				this.addCake(new Special());
				break;
			case 2:
				this.addCake(new Wedding());
				break;
			case 3:
				this.addCake(new Juvenile());
				break;
			default:
				break;
			}
		}
	}

	public void addCake(Cake cake) {
		if (this.cakes.containsKey(cake.getType())) {
			for (Iterator<Entry<Type, TreeMap<IKind, List<Cake>>>> iterator = this.cakes.entrySet().iterator(); iterator.hasNext();) {
				Entry<Type, TreeMap<IKind, List<Cake>>> bigEntry = iterator.next();
				if (bigEntry.getKey().equals(cake.getType())) {
					if (bigEntry.getValue().containsKey(cake.getKind())) {
						for (Iterator<Entry<IKind, List<Cake>>> iterator2 = bigEntry.getValue().entrySet().iterator(); iterator2.hasNext();) {
							Entry<IKind, List<Cake>> smallEntry = iterator2.next();
							if (smallEntry.getKey().equals(cake.getKind())) {
								smallEntry.getValue().add(cake);
								if (cake instanceof Juvenile || cake instanceof Wedding) {
									smallEntry.getValue().sort(new CakeComparatorByPieces());
								} else {
									smallEntry.getValue().sort(new CakeComparatorByPrice());
								}
							}
						}
					} else {
						bigEntry.getValue().put(cake.getKind(), new ArrayList<Cake>());
						bigEntry.getValue().get(cake.getKind()).add(cake);
					}
				}
			}
		} else {
			cakes.put(cake.getType(), new TreeMap<IKind, List<Cake>>());
			cakes.get(cake.getType()).put(cake.getKind(), new ArrayList<Cake>());
			cakes.get(cake.getType()).get(cake.getKind()).add(cake);
		}
		numberOfCakes++;
	}
	
	public void removeCake(Cake cake) {
		//this.cakes.remove(cake);
		for (Iterator<Entry<Type, TreeMap<IKind, List<Cake>>>> iterator = this.cakes.entrySet().iterator(); iterator.hasNext();) {
			Entry<Type, TreeMap<IKind, List<Cake>>> bigEntry = iterator.next();
			if (bigEntry.getKey().equals(cake.getType())) {
				for (Iterator<Entry<IKind, List<Cake>>> iterator2 = bigEntry.getValue().entrySet().iterator(); iterator2.hasNext();) {
					Entry<IKind, List<Cake>> smallEntry = iterator2.next();
					if (smallEntry.getKey().equals(cake.getKind())) {
//						for (Iterator<Cake> iterator3 = smallEntry.getValue().iterator(); iterator3.hasNext();) {
//							Cake c = iterator3.next();
//							iterator.remove();
//							return;
//						}
						//System.out.println(smallEntry.getValue());
						smallEntry.getValue().remove(cake);
						numberOfCakes--;
						return;
					}
				}
			}
		}
	}

	public boolean isCakeAvailable(Cake cake) {
		for (Iterator<Entry<Type, TreeMap<IKind, List<Cake>>>> iterator = this.cakes.entrySet().iterator(); iterator.hasNext();) {
			Entry<Type, TreeMap<IKind, List<Cake>>> bigEntry = iterator.next();
			if (bigEntry.getKey().equals(cake.getType())) {
				for (Iterator<Entry<IKind, List<Cake>>> iterator2 = bigEntry.getValue().entrySet().iterator(); iterator2.hasNext();) {
					Entry<IKind, List<Cake>> smallEntry = iterator2.next();
					if (smallEntry.getKey().equals(cake.getKind())) {
						if (smallEntry.getValue().contains(cake)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public Cake getRandomCakeFromBakery() {
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
				//i=0;
			}
		}
		System.out.println("ot te tuka ska4a");
		return null;
	}

	public void printAllCakesInBakery() {
		for (Iterator<Entry<Cake.Type, TreeMap<IKind, List<Cake>>>> iterator = this.cakes.entrySet()
				.iterator(); iterator.hasNext();) {
			Entry<Cake.Type, TreeMap<IKind, List<Cake>>> entry = iterator.next();
			System.out.println("-----" + entry.getKey() + "-----");
			for (Iterator<Entry<IKind, List<Cake>>> iterator2 = entry.getValue().entrySet().iterator(); iterator2
					.hasNext();) {
				Entry<IKind, List<Cake>> listOfCakes = iterator2.next();
				System.out.println("-----" + listOfCakes.getKey() + "-----");
				System.out.println(listOfCakes.getValue());
			}
		}
	}
	
	public Supplier getRandomSupplier() {
		return this.suppliers.get(new Random().nextInt(this.suppliers.size()));
	}

	// public int getAllAvailableCakes() {
	// int counter = 0;
	// for (Cake cake : cakes) {
	// counter++;
	// System.out.print(cake.toString());
	// }
	// return counter;
	// }
}
