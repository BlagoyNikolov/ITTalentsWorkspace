package traders.shops;

public class Pavillion extends TradeObject implements IETrader, IChain {

	public Pavillion(String address, int workingHours, int area) {
		super(address, workingHours);
		if (area >= 2 && area <= 10) {
			this.setArea(area);
		}
		this.setTaxes(50);
	}
}
