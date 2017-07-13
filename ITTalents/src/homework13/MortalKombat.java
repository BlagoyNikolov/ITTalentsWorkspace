package homework13;

import java.util.Random;

public class MortalKombat {
	public static void main(String[] args) {
		Fighter subZero = new Fighter();
		subZero.name = "Subzero";
		
		Fighter scorpion = new Fighter();
		scorpion.name = "Scorpion";
		
		subZero.enemy = scorpion;
		scorpion.enemy = subZero;
		
		while(true){
			if(subZero.isDead()){
				System.out.println("Winner is " + scorpion.name);
				break;
			}
			else{
				subZero.hit();
			}
			if(scorpion.isDead()){
				System.out.println("Winner is " + subZero.name);
				break;
			}
			else{
				scorpion.hit();
			}
			float chance = new Random().nextFloat();
			if (chance <= 0.03f && !scorpion.isDead()) {
				scorpion.health += 30;
				System.err.println(scorpion.name + " found the Domashnqrka!");
			}
			chance = new Random().nextFloat();
			if (chance <= 0.03f && !subZero.isDead()) {
				subZero.health += 30;
				System.err.println(subZero.name + " found the Domashnqrka!");
			}
		}
	}
}
