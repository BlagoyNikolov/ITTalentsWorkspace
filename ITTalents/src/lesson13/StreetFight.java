package lesson13;

public class StreetFight {
	public static void main(String[] args) {	
		SuperHero viki = new SuperHero();
		SuperHero iliya = new SuperHero();
		viki.name = "Viktoria";
		iliya.name = "Iliya";
		
		viki.enemy = iliya;
		iliya.enemy = viki;
		
		while(true){
			if(iliya.isDead()){
				System.out.println("Winner is " + viki.name);
				break;
			}
			else{
				iliya.hit();
			}
			if(viki.isDead()){
				System.out.println("Winner is " + iliya.name);
				break;
			}
			else{
				viki.hit();
			}
		}
	}
}
