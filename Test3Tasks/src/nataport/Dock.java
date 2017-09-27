package nataport;

public class Dock {
	private int id;
	private static Pristanishte pristan;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void setPristanishte(Pristanishte pristanishte) {
		pristan = pristanishte;
	}
}
