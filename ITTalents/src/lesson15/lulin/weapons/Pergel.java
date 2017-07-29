package lesson15.lulin.weapons;

public class Pergel {

	private static final int MAX_DURABILITY = 100;//constant
	private final String name;
	private final int dmg;
	private int durability = MAX_DURABILITY;
	
	public Pergel(String name, int dmg) {
		this.name = name;
		this.dmg = dmg;
	}
	
	public int getDmg() {
		return dmg;
	}
	
	public void crack(){
		this.durability--;
	}
	
	public boolean isBroken(){
		return this.durability <= 0;
	}

	public void repair() {
		this.durability = MAX_DURABILITY;
	}
	
	public String getName() {
		return name;
	}
}
