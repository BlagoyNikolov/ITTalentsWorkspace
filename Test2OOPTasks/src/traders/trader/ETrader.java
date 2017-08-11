package traders.trader;

import java.util.ArrayList;

import traders.shops.IETrader;
import traders.suppliers.SmallSupplier;

public class ETrader extends Trader {
	private ArrayList<SmallSupplier> smallSuppliers;
	private IETrader tradeObject;
	
	public ArrayList<SmallSupplier> getSmallSuppliers() {
		return smallSuppliers;
	}
	
	public void setSmallSuppliers(ArrayList<SmallSupplier> smallSuppliers) {
		if (smallSuppliers.size() <= 5) {
			this.smallSuppliers = smallSuppliers;
		}
	}
	
	public IETrader getTradeObject() {
		return tradeObject;
	}
	
	public void setTradeObject(IETrader tradeObject) {
		this.tradeObject = tradeObject;
	}
	
	public ETrader(String name, String address, double capital) {
		super(name, address, capital);
	}
}
