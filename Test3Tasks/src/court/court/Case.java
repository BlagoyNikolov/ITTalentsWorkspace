package court.court;

import java.util.ArrayList;
import java.util.Random;
import court.citizens.Defendant;
import court.citizens.Witness;
import court.jurists.Judge;
import court.jurists.Jury;

public abstract class Case {
	private Judge judge;
	private ArrayList<Jury> jury;
	protected IAccuser accuser;
	private ArrayList<Witness> witnesses;
	private Defendant defendant;
	
	public Case(Judge judge, ArrayList<Jury> jury, IAccuser accuser, ArrayList<Witness> witnesses,
			Defendant defendant) {
		this.judge = judge;
		this.jury = jury;
		this.accuser = accuser;
		this.witnesses = witnesses;
		this.defendant = defendant;
	}
	
	public void execute() {
		increaseXP();
		askQuestions();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < defendant.getLawyers().size(); j++) {
				defendant.getLawyers().get(j).askQuestion();
			}
		}
		makeDecision();
	}

	private void makeDecision() {
		int guilty = 0;
		for (int i = 0; i < jury.size(); i++) {
			if (new Random().nextBoolean()) {
				guilty++;
			}
		}
		if (guilty > jury.size() / 2) {
			makeVerdict();
		}
	}

	private void makeVerdict() {
		System.out.println("lejish bace za " + (new Random().nextInt(37) + 3) + " godinki na toplo");
		
	}

	protected abstract void askQuestions();

	protected void increaseXP() {
		judge.increaseCases();
		for (int i = 0; i < jury.size(); i++) {
			jury.get(i).increaseCases();
		}
		
	}
}
