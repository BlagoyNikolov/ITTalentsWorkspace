package traders.suppliers;

public class SmallSupplier extends Supplier {
	private static final double DISCOUNT_SMALL = 0;

	public SmallSupplier(String name, String address, int workingHours) {
		super(name, address, workingHours);
	}

	@Override
	public double makeDiscount(double amount)  {
		return amount - (amount * DISCOUNT_SMALL / 100);
	}

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return this.DISCOUNT_SMALL;
	}
}
