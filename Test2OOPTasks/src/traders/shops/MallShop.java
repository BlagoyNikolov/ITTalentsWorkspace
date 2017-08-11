package traders.shops;

public class MallShop extends TradeObject implements IChain {

	public MallShop(String address, int workingHours, int area) {
		super(address, workingHours);
		if (area >= 10 && area <= 100) {
			this.setArea(area);
		}
		this.setTaxes(150);
	}
}
