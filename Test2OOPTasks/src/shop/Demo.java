package shop;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<>();
		Kilogram meat = new Kilogram("Meat", 5, 10);
		Kilogram cheese = new Kilogram("Cheese", 3, 8);
		Kilogram fish = new Kilogram("Fish", 6, 7);
		Broika beer = new Broika("Beer", 2, 20);
		Broika book = new Broika("Book", 15, 30);
		Broika chair = new Broika("Chair", 50, 10);
		products.add(meat);
		products.add(cheese);
		products.add(fish);
		products.add(beer);
		products.add(book);
		products.add(chair);
		Shop shop = new Shop("Fantastiko", "100dentski", 1000, products);
		
		ShoppingCart sc = new ShoppingCart();
		Client blago = new Client(shop, 120, 10, sc);
		//blago.addItemBroika((Broika) products.get(3), 5);
		//blago.addItemBroika((Broika) products.get(4), 3);
		blago.addItemKilogram((Kilogram) products.get(0), 0.8);
		blago.getShoppingCart().shoppingCardInfo();
		//blago.removeItemBroika((Broika) products.get(3), 2);
		blago.getShoppingCart().shoppingCardInfo();
		blago.payAll();
		System.out.println("Client money " + blago.getMoney());
		System.out.println("Shop money " + shop.getMoney());
	}
}
