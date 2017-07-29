package lesson15.lulin;

import java.util.Random;
import lesson15.lulin.weapons.Linia;
import lesson15.lulin.weapons.Pergel;

public class Zubarche {

	private final String name;
	private int health;
	private int dmg;
	
	public Zubarche(String name) {
		this.name = name;
		this.health = new Random().nextInt(70) + 50;//from 50 to 120
		this.dmg = new Random().nextInt(10) + 2;//from 2 to 12
	}
	
	void dropLoot(Uchenik hero){
		if(new Random().nextBoolean()){
			Pergel pergel = dropPergel();
			if(!hero.hasBetterPergel(pergel)){
				hero.equipPergel(pergel);
			}
		}
		else{
			Linia linia = dropLinia();
			if(!hero.hasBetterLinia(linia)){
				hero.equipLinia(linia);
			}
		}
		if(new Random().nextInt(100) < 3){
			System.out.println("Oppa! Mai imame lutenichka, a?!");
			hero.naguvaLutenica();
			return;
		}
		if(new Random().nextInt(100) < 1){
			System.out.println("EBASI! ZLATNATA EDROSMLQNA LUTENICA NA BABA!");
			hero.naguvaMoshtnoLutenica();
		}
	}
	
	private Pergel dropPergel(){
		return new Pergel("Zlatnia pergel na tati", (new Random().nextInt(200) + 100));
	}
	
	private Linia dropLinia(){
		return new Linia("Shivashkiq moshten lineal na mama", (new Random().nextInt(200) + 200));
	}

	public boolean isDead() {
		return this.health <= 0;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}

	public void hit(Uchenik uchenik) {
		uchenik.setHealth(uchenik.getHealth() - this.dmg);
	}
	public void showInfo(){
		
		System.out.println("-----------Zubarche-----------");
		System.out.println("Name = " + this.name);
		System.out.println("Health = " + this.health);
		System.out.println("Dmg = " + this.dmg);
		System.out.println("------------------------------");
	}
	
}
