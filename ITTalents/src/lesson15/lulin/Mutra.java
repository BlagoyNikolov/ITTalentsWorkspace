package lesson15.lulin;

public class Mutra {

	private final String name;
	private final String nickname;
	private int health = 2500;
	private final int dmg = 100;
	
	public Mutra(String name, String nickmane) {
		this.name = name;
		this.nickname = nickmane;
	}

	public String getNickname() {
		return this.nickname;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean isDead(){
		return this.health <= 0;
	}
	
	public int getHealth() {
		return health;
	}

	public void hit(Uchenik uchenik) {
		uchenik.setHealth(uchenik.getHealth() - this.dmg);
	}
}
