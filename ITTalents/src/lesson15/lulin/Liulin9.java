package lesson15.lulin;

public class Liulin9 {

	public static void main(String[] args) {
		
		Dvor mishovci = new Dvor("133-to", 600);
		Uchenik petrocvet = new Uchenik("Petrocvet");//the slayer of geeks!
		petrocvet.showInfo();
		for (int i = 0; i < 200; i++) {
			petrocvet.fight(mishovci.getRandomZubarOtDvora());
			petrocvet.showInfo();
		}
		Mutra dinko = new Mutra("Dinko", "Diniata");
		petrocvet.fight(dinko);
	}
}
