package bank;

public class Deposit extends Product implements Comparable<Deposit>, Cloneable {
	private double monthlyFee;

	public Deposit(String name, double interest, int period) {
		super(name, interest, period);
	}

	public Deposit(String name, double interest, int period, double value, double monthlyFee) {
		super(name, interest, period, value);
		this.monthlyFee = monthlyFee;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}

	public void addInterest(double interest) {
		this.value += interest;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	@Override
	public String toString() {
		return "Deposit [name=" + name + ", interest=" + interest + ", period=" + period + ", value=" + value + "]";
	}

	@Override
	public int compareTo(Deposit o) {
		return Double.compare(this.getValue(), o.getValue());
	}

	@Override
	public Deposit clone() {
		try {
			final Deposit result = (Deposit) super.clone();
			// copy fields that need to be copied here!
			return result;
		} catch (final CloneNotSupportedException ex) {
			throw new AssertionError();
		}
	}
}
