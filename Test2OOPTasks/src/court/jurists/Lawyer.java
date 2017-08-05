package court.jurists;

public class Lawyer extends Jurist {

	public Lawyer(String name, int exp, int cases) {
		super(name, exp, cases > 10 ? cases : 10);
		this.position = "Lawyer";
	}

	@Override
	public void askQuestion() {
		System.out.println("Ti mene uvajavash li me kato advokat");
	}

	@Override
	protected void takeNotes() {
		System.out.println("Pishem si kato advokat");
	}

}
