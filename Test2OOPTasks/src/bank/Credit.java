package bank;

public class Credit extends Product {
	private double monthlyVnoska;
	
	public Credit(String name, double interest) {
		super(name, interest);
	}
	
	public Credit(String name, double interest, int period, double value, double monthlyVnoska) {
		super(name, interest, period, value);
		this.monthlyVnoska = monthlyVnoska;
	}

	public double getMonthlyVnoska() {
		return monthlyVnoska;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}
}
