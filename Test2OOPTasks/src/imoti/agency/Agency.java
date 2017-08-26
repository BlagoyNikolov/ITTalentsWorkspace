package imoti.agency;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import imoti.estates.Imot;

public class Agency {
	private String name;
	private String address;
	private String phone;
	private Set<Agent> agents;
	private Map<Imot.Category, TreeSet<Imot>> catalogue;
	private double balance;
	private int numberOfProperties = 0;

	public Agency(String name, String address, String phone, TreeSet<Agent> agents) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.agents = agents;
		this.catalogue = new TreeMap<Imot.Category, TreeSet<Imot>>();
	}

	public Set<Agent> getAgents() {
		return Collections.unmodifiableSet(agents);
	}

	public Map<Imot.Category, TreeSet<Imot>> getCatalogue() {
		return Collections.unmodifiableMap(catalogue);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Agent getRandomAgent() {
		int r = new Random().nextInt(getAgents().size());
		int i = 0;
		for (Iterator<Agent> iterator = getAgents().iterator(); iterator.hasNext(); i++) {
			Agent a = iterator.next();
			if (i == r) {
				return a;
			}
		}
		return null;
	}

	public Imot getRandomImot() {
		Random r = new Random();
		int i = 0;
		int index = r.nextInt(numberOfProperties);
		for (Iterator<TreeSet<Imot>> iterator = catalogue.values().iterator(); iterator.hasNext();) {
			TreeSet<Imot> allImoti = iterator.next();
			for (Iterator<Imot> iterator2 = allImoti.iterator(); iterator2.hasNext();) {
				Imot imot = iterator2.next();
				if (i == index) {
					return imot;
				}
				i++;
			}
		}
		return null;
	}

	public void addImotToCatalogue(Imot imot) {
		if (this.catalogue.containsKey(imot.getCategory())) {
			for (Iterator<Entry<Imot.Category, TreeSet<Imot>>> iterator = catalogue.entrySet().iterator(); iterator.hasNext();) {
				Entry<Imot.Category, TreeSet<Imot>> entry = iterator.next();
				if (entry.getKey().equals(imot.getCategory())) {
					if (entry.getValue().contains(imot)) {
						System.out.println("This imot has already been added!");
					} else {
						entry.getValue().add(imot);
					}
				}
			}
		} else {
			this.catalogue.put(imot.getCategory(), new TreeSet<>());
			this.catalogue.get(imot.getCategory()).add(imot);
		}
		numberOfProperties++;
	}

	public void removeImotFromCatalogue(Imot imot) {
		if (this.catalogue.containsKey(imot.getCategory())) {
			for (Iterator<TreeSet<Imot>> iterator = catalogue.values().iterator(); iterator.hasNext();) {
				TreeSet<Imot> allImoti = iterator.next();
				if (allImoti.contains(imot)) {
					allImoti.remove(imot);
				}
			}
		}
	}

	public void addFundsToBalance(double amount, Agent agent) {
		agent.receiveMoney(amount / 2);
		this.setBalance(this.getBalance() + amount / 2);
	}

	public void printAgents(TreeSet<Agent> agents) {
		System.out.println(agents);
	}

	public void printBalance() {
		System.out.println("\nAgency balance: " + this.getBalance());
	}
}
