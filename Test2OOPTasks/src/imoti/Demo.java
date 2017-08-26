package imoti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;
import imoti.agency.Agency;
import imoti.agency.Agent;
import imoti.clients.Buyer;
import imoti.clients.Seller;
import imoti.estates.Appartment;
import imoti.estates.House;
import imoti.estates.Parcel;

public class Demo {
	public static void main(String[] args) {
		TreeSet<Agent> agents = new TreeSet<>();
		for (int i = 1; i <= 5; i++) {
			agents.add(new Agent("Agent" + i));
		}
		Agency talents = new Agency("Talents estates", "Infinity Tower", "0888 888 888", agents);
		
		ArrayList<Seller> sellers = new ArrayList<Seller>();
		for (int i = 1; i <= 30; i++) {
			int number = new Random().nextInt(3);
			switch (number) {
			case 0:
				sellers.add(new Seller("Seller" + i, "0887 898 792", talents, new Appartment("App descr"+i, "App addr"+i, 80000 * new Random().nextDouble() + 70000, new Random().nextInt(200) + 50, Appartment.getRandomType(), Appartment.getRandomConstructiontype()), 5000));
				break;
			case 1:
				sellers.add(new Seller("Seller" + i, "0887 898 792", talents, new House("Haus descr"+i, "Haus addr"+i, 30000 * new Random().nextDouble() + 50000, new Random().nextInt(300) + 100, House.getRandomType(), House.getRandomConstructiontype(), 5, 30 * new Random().nextDouble()), 5000));
				break;
			case 2:
				sellers.add(new Seller("Seller" + i, "0887 898 792", talents, new Parcel("Parc descr"+i, "Parc addr"+i, 55000 * new Random().nextDouble() + 30000, new Random().nextInt(200) + 50, Parcel.getRandomType(), new Random().nextBoolean()), 5000));
				break;
			}
		}
		
		for (Seller seller : sellers) {
			seller.registerImotForSale();
			//seller.sellerInfo();
		}
		
		ArrayList<Buyer> buyers = new ArrayList<Buyer>();
		for (int i = 1; i <= 10; i++) {
			buyers.add(new Buyer("Buyer" + i, "0887 898 792", 120000 * new Random().nextDouble() + 30000, talents));
		}
		
		for (Buyer buyer : buyers) {
			buyer.registerImotEnquiry();
			buyer.declareView(talents.getRandomImot());
			buyer.declareView(talents.getRandomImot());
			buyer.declareView(talents.getRandomImot());
			//buyer.buyerInfo();
		}
		
		for (Buyer buyer : buyers) {
			buyer.declarePurchase();
		}
		
		talents.printBalance();
		
		TreeSet<Agent> agentsAfter = new TreeSet<>(new Comparator<Agent>() {
			@Override
			public int compare(Agent o1, Agent o2) {
				if (o1.getMoney() == o2.getMoney()) {
					return o1.getName().compareTo(o2.getName());
				}
				return (int) ((100 * o1.getMoney()) - (100 * o2.getMoney()));
			}
		});
		agentsAfter.addAll(agents);
		talents.printAgents(agentsAfter);
	}
}
