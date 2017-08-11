package traders.trader;

import java.util.ArrayList;

import traders.shops.IChain;
import traders.suppliers.Supplier;

public class Chain extends Trader {
	private ArrayList<Supplier> suppliers;
	private ArrayList<IChain> tradeObjects;
	
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
	
	public void setSuppliers(ArrayList<Supplier> suppliers) {
		if (suppliers.size() <= 15) {
			this.suppliers = suppliers;
		}
	}
	
	public ArrayList<IChain> getTradeObjects() {
		return tradeObjects;
	}
	
	public void setTradeObjects(ArrayList<IChain> tradeObjects) {
		if (tradeObjects.size() <= 10) {
			this.tradeObjects = tradeObjects;
		}
	}

	public Chain(String name, String address, double capital) {
		super(name, address, capital);
	}
}
