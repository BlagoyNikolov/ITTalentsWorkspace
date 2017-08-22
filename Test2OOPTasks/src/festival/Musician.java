package festival;

public abstract class Musician {
	protected String name;
	//protected Band band;

	public Musician(String name) {
		this.name = name;
		//this.band = band;
	}
	
	public abstract String toString();
	public abstract void playMusic();
}
