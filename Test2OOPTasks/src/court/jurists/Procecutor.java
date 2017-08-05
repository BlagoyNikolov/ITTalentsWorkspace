package court.jurists;

import court.court.IAccuser;

public class Procecutor extends Jurist implements IAccuser {

	public Procecutor(String name, int exp, int cases) {
		super(name, exp > 10 ? exp : 10, cases);
		this.position = "Procecutor";
	}

	@Override
	public void askQuestion() {
		System.out.println("Ti mene uvajavash li me kato Procecutor");
	}

	@Override
	protected void takeNotes() {
		System.out.println("Pishem si kato Procecutor");
	}

}