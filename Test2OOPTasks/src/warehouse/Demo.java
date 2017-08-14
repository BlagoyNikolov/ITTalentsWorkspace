package warehouse;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse("Warehouse");
		Supplier supplier = new Supplier("Suplier", warehouse);
		Shop shop1 = new Shop("Shop1", warehouse);
		Shop shop2 = new Shop("Shop2", warehouse);
		Shop shop3 = new Shop("Shop3", warehouse);
		
		ArrayList<Shop> shops = new ArrayList<Shop>(); 
		shops.add(shop1);
		shops.add(shop2);
		shops.add(shop3);
		
		for (Shop s : shops){
			for (int i = 1; i <= 3; i++) {
				s.getClients().add(new Client("Client" + i, s));
			}
		}
		
		for (Shop s : shops){
			s.viewAvailability();
			for (Client c: s.getClients()) {
				c.buyProducts();
			}
			s.viewAvailability();
		}
	}
}
