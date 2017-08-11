package traders;

import java.util.ArrayList;
import java.util.Random;
import traders.shops.IChain;
import traders.shops.IETrader;
import traders.shops.Kiosque;
import traders.shops.MallShop;
import traders.shops.Pavillion;
import traders.shops.TradeObject;
import traders.suppliers.BigSupplier;
import traders.suppliers.SmallSupplier;
import traders.suppliers.Supplier;
import traders.trader.Ambulant;
import traders.trader.Chain;
import traders.trader.ETrader;
import traders.trader.Trader;

public class Demo {
	public static void main(String[] args) {
		ArrayList<Supplier> suppliers = addSuppliers();
		ArrayList<TradeObject> shops = addShops();
		ArrayList<Trader> traders = new ArrayList<>();
		
		Ambulant ambulant = new Ambulant("Ambulant", "Abmidk", 100);
		ETrader etrader = new ETrader("ETrader", "Etraddr", 500);
		Chain chain = new Chain("ChainTrader", "Chainadddr", 3000);
		
		etrader.setTradeObject(getRandomIETraderShop(shops));
		chain.setTradeObjects(getRandomIChainShop(shops));
		
		ambulant.setSmallSuplier(getRandomSmallSupplier(suppliers));
		etrader.setSmallSuppliers(getRandomSmallSuppliers(suppliers));
		chain.setSuppliers(getRandomSuppliers(suppliers));
		
		traders.add(ambulant);
		traders.add(etrader);
		traders.add(chain);
		
		beginTrade(traders);
	}
	
	public static void beginTrade(ArrayList<Trader> traders) {
		for (Trader trader : traders) {
			if (trader instanceof Ambulant) {
				trader.makeOrder(80 * new Random().nextDouble() + 20, ((Ambulant) trader).getSmallSuplier());
				trader.sellItems();
			}
			if (trader instanceof ETrader) {
				for (SmallSupplier ss : ((ETrader) trader).getSmallSuppliers()) {
					trader.makeOrder(400 * new Random().nextDouble() + 100, ss);
				}
				trader.sellItems();
				trader.payTax((TradeObject) ((ETrader) trader).getTradeObject());
			}
			if (trader instanceof Chain) {
				for (Supplier s : ((Chain) trader).getSuppliers()) {
					trader.makeOrder(2000 * new Random().nextDouble() + 1000, s);
				}
				trader.sellItems();
				for (IChain ic : ((Chain) trader).getTradeObjects()) {
					trader.payTax((TradeObject) ic);
				}
			}
		}
		for (Trader trader : traders) {
			trader.getTraderInfo();
		}
	}
	
	public static ArrayList<Supplier> getRandomSuppliers(ArrayList<Supplier> suppliers) {
		ArrayList<Supplier> chainSuppliers = new ArrayList<>();
		for (Supplier supplier : suppliers) {
			chainSuppliers.add(supplier);
		}
		return chainSuppliers;
	}
	
	public static ArrayList<SmallSupplier> getRandomSmallSuppliers(ArrayList<Supplier> suppliers) {
		ArrayList<SmallSupplier> smallSuppliers = new ArrayList<>();
		for (Supplier supplier : suppliers) {
			if (supplier instanceof SmallSupplier) {
				smallSuppliers.add((SmallSupplier) supplier);
			}
		}
		return smallSuppliers;
	}
	
	public static SmallSupplier getRandomSmallSupplier(ArrayList<Supplier> suppliers) {
		SmallSupplier smallSupplier = null;
		for (Supplier supplier : suppliers) {
			if (supplier instanceof SmallSupplier) {
				smallSupplier = (SmallSupplier) supplier;
			}
		}
		return smallSupplier;
	}
	
	public static ArrayList<IChain> getRandomIChainShop(ArrayList<TradeObject> shops) {
		ArrayList<IChain> ichainShops = new ArrayList<>();
		
		for (int i = 0; i < shops.size(); i++) {
			if (shops.get(i) instanceof IChain && ichainShops.size() < 10) {
				IChain ichainShop = (IChain) shops.get(i);
				ichainShops.add(ichainShop);
			}
		}
		//shops.removeAll(ichainShops);
		return ichainShops;
	}
	
	public static IETrader getRandomIETraderShop(ArrayList<TradeObject> shops) {
		IETrader ietraderShop = null;
		for (int i = 0; i < shops.size(); i++) {
			if (shops.get(i) instanceof IETrader) {
				ietraderShop = (IETrader) shops.get(i);
				break;
			}
		}
		//shops.remove(ietraderShop);
		return ietraderShop;
	}

	private static ArrayList<Supplier> addSuppliers() {
		ArrayList<Supplier> suppliers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			switch (r.nextInt(2)) {
			case 0:
				suppliers.add(new BigSupplier("BigSupplier" + i, "addr" + i, 5));
				break;
			case 1:
				suppliers.add(new SmallSupplier("SmallSupplier" + i, "addr" + i, 5));
				break;
			}
		}
		return suppliers;
	}
	
	private static ArrayList<TradeObject> addShops() {
		ArrayList<TradeObject> tradeObjs = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Random r = new Random();
			switch (r.nextInt(3)) {
			case 0:
				tradeObjs.add(new Pavillion("PavAddr" + i, new Random().nextInt(4) + 4, new Random().nextInt(8) + 2));
				break;
			case 1:
				tradeObjs.add(new MallShop("MallShopAddr" + i, new Random().nextInt(4) + 4, new Random().nextInt(90) + 10));
				break;
			case 2:
				tradeObjs.add(new Kiosque("KiosqueAddr" + i, new Random().nextInt(4) + 4, new Random().nextInt(2) + 4));
				break;
			}
		}
		return tradeObjs;
	}
}
