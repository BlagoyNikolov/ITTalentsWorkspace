package lesson15.lulin;

import lesson15.lulin.weapons.Linia;
import lesson15.lulin.weapons.Pergel;

public class Uchenik {

	private int maxHealth = 100;
	private final String name;
	private int health = maxHealth;
	private final int dmg = 10;
	private Pergel pergel;
	private Linia linia;
	
	public Uchenik(String name) {
		this.name = name;
	}

	public void equipPergel(Pergel pergel) {
		this.pergel = pergel;
	}

	public void equipLinia(Linia linia) {
		this.linia = linia;
	}

	public boolean hasBetterPergel(Pergel pergel) {
		if(this.pergel == null){
			return false;
		}
		return this.pergel.getDmg() > pergel.getDmg();
	}

	public boolean hasBetterLinia(Linia linia) {
		if(this.linia == null){
			return false;
		}
		return this.linia.getDmg() > linia.getDmg();
	}
	
	public void fight(Mutra mutra){

		System.out.println("ELA TUKA BRE, !" + mutra.getNickname());
		while(true){
			if(mutra.isDead()){
				System.out.println("PREVURTQHME LULIN, NADEJDA DA SE GOTVI!");
				break;
			}
			if(this.isDead()){
				System.out.println("NEED MORE ZUBARCHETA!");
				this.rest();
				break;
			}
			this.hit(mutra);
			mutra.hit(this);
		}
		rest();
	}
	
	public void fight(Zubarche zub){
		
		System.out.println("ELA TUKA BRE, Zubar!");
		zub.showInfo();
		while(true){
			if(zub.isDead()){
				System.out.println("POBEDKA!");
				zub.dropLoot(this);
				break;
			}
			if(this.isDead()){
				System.out.println("ZAGUBKA!");
				this.rest();
				break;
			}
			this.hit(zub);
			zub.hit(this);
		}
		rest();
	}

	private void hit(Mutra m) {
		m.setHealth(m.getHealth()- calcTotalDmg());
		if(linia != null){
			linia.crack();
		}
		if(pergel != null){
			pergel.crack();
		}
	}
	
	private void hit(Zubarche zub) {
		zub.setHealth(zub.getHealth()- calcTotalDmg());
		if(linia != null){
			linia.crack();
		}
		if(pergel != null){
			pergel.crack();
		}
	}

	private int calcTotalDmg() {
		int totalDmg = dmg;
		if(this.pergel != null && !this.pergel.isBroken()){
			totalDmg += pergel.getDmg();
		}
		if(this.linia != null && !this.linia.isBroken()){
			totalDmg += linia.getDmg();
		}
		return totalDmg;
	}

	private void rest() {
		this.health = maxHealth;
		if(pergel!= null){
			pergel.repair();
		}
		if(linia!= null){
			linia.repair();
		}
	}

	private boolean isDead() {
		return this.health <= 0;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void showInfo(){
		String pergelInfo = "none";
		if(this.pergel != null){
			pergelInfo = pergel.getName() + " with dmg = " + pergel.getDmg();
		}
		String liniaInfo = "none";
		if(this.linia != null){
			liniaInfo = linia.getName() + " with dmg = " + linia.getDmg();
		}
		System.out.println("-----------OUR HERO-----------");
		System.out.println("Name = " + this.name);
		System.out.println("Health = " + this.health);
		System.out.println("Pergel = " + pergelInfo);
		System.out.println("Linia = " + liniaInfo);
		System.out.println("Dmg = " + this.calcTotalDmg());
		System.out.println("------------------------------");
	}

	public void naguvaLutenica() {
		maxHealth+= 10;
	}

	public void naguvaMoshtnoLutenica() {
		maxHealth *= 2;
	}
}
