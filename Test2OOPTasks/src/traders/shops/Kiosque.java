package traders.shops;

public class Kiosque extends TradeObject implements IETrader {

	public Kiosque(String address, int workingHours, int area) {
		super(address, workingHours);
		if (area >= 4 && area <= 6) {
			this.setArea(area);
		}
		this.setTaxes(50);
	}
}
