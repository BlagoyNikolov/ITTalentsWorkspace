package musicinstruments;

public class Demo {
	public static void main(String[] args) {
		Shop shop = new Shop("Talanti.bg");
		Supplier s = new Supplier(shop);
		Client c = new Client(shop);
		
		c.start();
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
