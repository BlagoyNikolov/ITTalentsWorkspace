package traders.suppliers;

public class BigSupplier extends Supplier {
	private static final double DISCOUNT_BIG = 15;

	public BigSupplier(String name, String address, int workingHours) {
		super(name, address, workingHours);
	}

	@Override
	public double makeDiscount(double amount)  {
		return amount - (amount * DISCOUNT_BIG / 100);
	}

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return this.DISCOUNT_BIG;
	}
}
