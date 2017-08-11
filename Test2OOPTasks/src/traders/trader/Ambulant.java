package traders.trader;

import traders.suppliers.SmallSupplier;

public class Ambulant extends Trader {
	private SmallSupplier smallSuplier;
	
	public SmallSupplier getSmallSuplier() {
		return smallSuplier;
	}
	
	public void setSmallSuplier(SmallSupplier smallSuplier) {
		this.smallSuplier = smallSuplier;
	}
	
	public Ambulant(String name, String address, double capital) {
		super(name, address, capital);
	}
}
