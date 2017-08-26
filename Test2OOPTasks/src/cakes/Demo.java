package cakes;

import java.util.ArrayList;
import java.util.Random;
import cakes.bakery.Bakery;
import cakes.bakery.Supplier;
import cakes.clients.Corporate;
import cakes.clients.Private;
import cakes.clients.Client;

public class Demo {
	public static void main(String[] args) {
		ArrayList<Supplier> suppliers = generateSuppliers();
		Bakery bakery = new Bakery("Sladki Talanti", "Infinity tower", suppliers);
		
		bakery.printAllCakesInBakery();
		
		ArrayList<Private> privateClients = generatePrivateClients(bakery);
		ArrayList<Corporate> corporateClients = generateCorporateClients(bakery);
		
		System.out.println("Number of available cakes: " + bakery.getNumberOfCakes());
		
		ArrayList<Client> allClients = new ArrayList<Client>();
		allClients.addAll(privateClients);
		allClients.addAll(corporateClients);
		
		for (Corporate corporateClient : corporateClients) {
			corporateClient.makeOrder();
		}
		
		for (Private privateClient : privateClients) {
			privateClient.makeOrder();
		}
		
		System.out.println("Number of available cakes: " + bakery.getNumberOfCakes());
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
	
	private static ArrayList<Private> generatePrivateClients(Bakery bakery) {
		ArrayList<Private> privateClients = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			privateClients.add(new Private("Private Client"+i, bakery, new Random().nextDouble() * 1000));
		}
		return privateClients;
	}

	private static ArrayList<Corporate> generateCorporateClients(Bakery bakery) {
		ArrayList<Corporate> corporateClients = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			corporateClients.add(new Corporate("Corporate Client"+i, bakery, new Random().nextDouble() * 1000));
		}
		return corporateClients;
	}
}
