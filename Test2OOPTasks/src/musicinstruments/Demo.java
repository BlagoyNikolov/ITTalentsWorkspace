package musicinstruments;

public class Demo {
	public static void main(String[] args) {
		Shop shop = new Shop("Talanti.bg");
		shop.sell("Fender", 3);
		shop.sell("Zender", 5);
		shop.sell("Yamaha", 3);
		shop.buy("Lassy", 5);
		
		shop.printInstrumentsByType();
		shop.KRASIprintInstrumentsByName();
		shop.KRASIprintInstrumentsByPrice(false);
		shop.KRASIprintInstrumentsByAvailability();
		System.out.println("Shop money " + shop.getMoney());
		shop.printSoldInstruments();
		System.out.println("Shop income money " + shop.getIncomeFromSales());
		shop.printMostAndLeastSoldInstrument();
		shop.printMostSoldType();
		shop.printMostProfitableType();
	}
}
