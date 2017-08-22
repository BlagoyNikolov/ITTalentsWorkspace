package imoti;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		TreeSet<Agent> agents = new TreeSet<>();
		for (int i = 1; i <= 5; i++) {
			agents.add(new Agent("Agent" + i, new HashSet<Seller>(), new HashSet<Buyer>(), new ArrayList<View>()));
		}
		Agency talens = new Agency("Talents express", "Infinity Tower", "0888 888 888", agents, new ArrayList<Imot>());
		
		ArrayList<Seller> sellers = new ArrayList<Seller>();
		for (int i = 1; i <= 30; i++) {
			int number = new Random().nextInt(3);
			switch (number) {
			case 0:
				sellers.add(new Seller("Seller" + i, "0887 898 792", talens, new Appartment("App descr"+i, "App addr"+i, 80000 * new Random().nextDouble() + 70000, new Random().nextInt(200) + 50, Appartment.getRandomType(), Appartment.getRandomConstructiontype()), 5000));
				break;
			case 1:
				sellers.add(new Seller("Seller" + i, "0887 898 792", talens, new House("Haus descr"+i, "Haus addr"+i, 30000 * new Random().nextDouble() + 50000, new Random().nextInt(300) + 100, House.getRandomType(), House.getRandomConstructiontype(), 5, 30 * new Random().nextDouble()), 5000));
				break;
			case 2:
				sellers.add(new Seller("Seller" + i, "0887 898 792", talens, new Parcel("Parc descr"+i, "Parc addr"+i, 55000 * new Random().nextDouble() + 30000, new Random().nextInt(200) + 50, new Random().nextBoolean()), 5000));
				break;
			}
		}
		
		for (Seller seller : sellers) {
			seller.registerImotForSale();
			//seller.sellerInfo();
		}
		
		ArrayList<Buyer> buyers = new ArrayList<Buyer>();
		for (int i = 1; i <= 10; i++) {
			buyers.add(new Buyer("Buyer" + i, "0887 898 792", 120000 * new Random().nextDouble() + 30000, talens));
		}
		
		for (Buyer buyer : buyers) {
			buyer.registerImotEnquiry();
			buyer.declareView(talens.getAds().get(new Random().nextInt(talens.getAds().size())));
			buyer.declareView(talens.getAds().get(new Random().nextInt(talens.getAds().size())));
			buyer.declareView(talens.getAds().get(new Random().nextInt(talens.getAds().size())));
			//buyer.buyerInfo();
		}
		
		for (Buyer buyer : buyers) {
			//Imot i = buyer.getViews().get(new Random().nextInt(buyer.getViews().size())).getImot();
			buyer.declarePurchase();
		}
		
		talens.printAgents();
	}
}
