package court.jurists;

public abstract class Jurist {
	private String name;
	protected String position;
	private int exp;
	private int cases;
	
	public Jurist(String name, int exp, int cases) {
		this.name = name;
		this.exp = exp;
		this.cases = cases;
	}
	
	protected abstract void askQuestion();
	protected abstract void takeNotes();
	
	public void increaseCases() {
		this.cases++;
	}
}
