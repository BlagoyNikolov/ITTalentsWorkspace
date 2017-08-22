package festival;

public class Vocalist extends Musician {

	public Vocalist(String name) {
		super(name);
	}

	public void playMusic() {
		System.out.println("Vocalist " + this.name + " is singing: ");
		//for (Song s : this.band.getSongs()) {
			//System.out.println(s.getTitle() + "\n" + s.getText());
		//}
	}

	@Override
	public String toString() {
		return "Vocalist [name=" + name + "]";
	}

}
