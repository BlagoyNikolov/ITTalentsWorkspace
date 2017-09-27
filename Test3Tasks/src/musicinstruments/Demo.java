package musicinstruments;

public class Demo {
	public static void main(String[] args) {
		Shop shop = new Shop("Talanti.bg");
		Supplier s = new Supplier(shop);
		Client c1 = new Client(shop, "Fender", 5);
		Client c2 = new Client(shop, "Yamaha", 4);
		Client c3 = new Client(shop, "Pearls", 5);
		
		c1.start();
		c2.start();
		c3.start();
		s.start();
		
//		shop.printInstrumentsByType();
//		shop.KRASIprintInstrumentsByName();
//		shop.KRASIprintInstrumentsByPrice(false);
//		shop.KRASIprintInstrumentsByAvailability();
//		System.out.println("Shop money " + shop.getMoney());
//		shop.printSoldInstruments();
//		System.out.println("Shop income money " + shop.getIncomeFromSales());
//		shop.printMostAndLeastSoldInstrument();
//		shop.printMostSoldType();
//		shop.printMostProfitableType();
	}
}
