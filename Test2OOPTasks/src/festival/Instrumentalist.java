package festival;

public class Instrumentalist extends Musician {

	public Instrumentalist(String name) {
		super(name);
	}

	public void playMusic() {
		System.out.println("Instrumentalist " + this.name + " is playing: ");
		//for (Song s : this.band.getSongs()) {
			System.out.println("♪♪♪♪");
		//}
	}

	@Override
	public String toString() {
		return "Instrumentalist [name=" + name + "]";
	}
}
