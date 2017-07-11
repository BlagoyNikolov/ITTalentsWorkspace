package homework13;

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
		}
	}
}
