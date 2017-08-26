package cakes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import cakes.bakery.Bakery;
import cakes.bakery.Supplier;
import cakes.cake.Cake;
import cakes.cake.IKind;
import cakes.cake.Juvenile;
import cakes.cake.Special;
import cakes.cake.Standard;
import cakes.cake.Wedding;
import cakes.clients.Corporate;
import cakes.clients.Private;
import cakes.clients.Client;

public class Demo {
	public static void main(String[] args) {
		ArrayList<Supplier> suppliers = generateSuppliers();
		//ArrayList<Cake> cakes = generateCakes();
		Map<Cake.Type, TreeMap<IKind, List<Cake>>> cakes = generateCakes();
		Bakery bakery = new Bakery("Sladki Talanti", "Infinity tower", cakes, suppliers);
		
		bakery.printAllCakesInBakery();
		
		ArrayList<Private> privateClients = generatePrivateClients(bakery);
		ArrayList<Corporate> corporateClients = generateCorporateClients(bakery);
		
		//System.out.println("Number of available cakes: " + bakery.getAllAvailableCakes());
		
		ArrayList<Client> allClients = new ArrayList<Client>();
		allClients.addAll(privateClients);
		allClients.addAll(corporateClients);
		
		for (Corporate corporateClient : corporateClients) {
			corporateClient.makeOrder();
		}
		
		for (Private privateClient : privateClients) {
			privateClient.makeOrder();
		}
		
		//System.out.println("Number of available cakes: " + bakery.getAllAvailableCakes());
		System.out.println("Bakery income " + bakery.getMoney());
		for (Supplier supplier : suppliers) {
			System.out.println(supplier.toString());
		}
		System.out.println("Best supplier " + getBestSupplier(suppliers));
		System.out.println("Client who payed the most " + getClientWhoPayedTheMost(allClients));
	}

	private static Supplier getBestSupplier(ArrayList<Supplier> suppliers) {
		Supplier bestSupplier = suppliers.get(0);
		int temp = suppliers.get(0).getOrderCount();
		for (Supplier supplier : suppliers) {
			if (supplier.getOrderCount() > temp) {
				bestSupplier = supplier;
				temp = supplier.getOrderCount();
			}
		}
		return bestSupplier;
	}
	
	private static Client getClientWhoPayedTheMost(ArrayList<Client> allclients) {
		Client bestClient = allclients.get(0);
		double temp = allclients.get(0).getPayedMoney();
		for (Client client : allclients) {
			if (client.getPayedMoney() > temp) {
				bestClient = client;
				temp = bestClient.getPayedMoney();
			}
		}
		return bestClient;
	}

	public static ArrayList<Supplier> generateSuppliers() {
		ArrayList<Supplier> suppliers = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			suppliers.add(new Supplier("Supplier" + i));
		}
		return suppliers;
	}
	
	public static Map<Cake.Type, TreeMap<IKind, List<Cake>>> generateCakes() {
		Map<Cake.Type, TreeMap<IKind, List<Cake>>> cakes = new TreeMap<Cake.Type, TreeMap<IKind, List<Cake>>>();
		for (int i = 0; i < 30; i++) {
			int x = new Random().nextInt(4);
			switch (x) {
			case 0:
				Bakery.addCakeToMap(new Standard(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Standard.getRandomStandardCakeType()), cakes);
				//cakes.add(new Standard(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Standard.getRandomStandardCakeType()));
				break;
			case 1:
				Bakery.addCakeToMap(new Special(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Special.getRandomSpecialCakeType()), cakes);
				//cakes.add(new Special(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Special.getRandomSpecialCakeType()));
				break;	
			case 2:
				Bakery.addCakeToMap(new Wedding(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Wedding.getRandomWeddingCakeType()), cakes);
				//cakes.add(new Wedding(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Wedding.getRandomWeddingCakeType()));
				break;
			case 3:
				Bakery.addCakeToMap(new Juvenile(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Juvenile.getRandomJuvenileCakeType()), cakes);
				//cakes.add(new Juvenile(new Random().nextDouble() * 100, new Random().nextInt(8) + 1, Juvenile.getRandomJuvenileCakeType()));
				break;
			default:
				break;
			}
		}
		return cakes;
	}
	
	private static ArrayList<Private> generatePrivateClients(Bakery bakery) {
		ArrayList<Private> privateClients = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			privateClients.add(new Private("PrivateClient"+i, bakery, new Random().nextDouble() * 1000));
		}
		return privateClients;
	}

	private static ArrayList<Corporate> generateCorporateClients(Bakery bakery) {
		ArrayList<Corporate> corporateClients = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			corporateClients.add(new Corporate("PrivateClient"+i, bakery, new Random().nextDouble() * 1000));
		}
		return corporateClients;
	}
}
