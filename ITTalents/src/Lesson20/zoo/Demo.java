package Lesson20.zoo;

public class Demo {

	interface IRobot{
		void shoot(String x);
	}
	
	public static void main(String[] args) {
		
		Animal a = new Gushter();
		a.makeNoise();
		a = new Koala();
		a.makeNoise();
		
		Animal ani = new Animal() {
			@Override
			void makeNoise() {
				System.out.println("Cvur cvur");
			}
		};
		
		new Gushter() {
			@Override
			void makeNoise() {
				super.makeNoise();
				System.out.println("mur mur");
			}
		}.makeNoise();
		
		IRobot r = new IRobot() {
			@Override
			public void shoot(String x) {
				System.out.println("bang bang " + x);
			}
		};
		
		IRobot r2 = (x) -> System.out.println("pew pew");//Lambda expression
		IRobot r3 = (x) -> System.out.println("bang bang");//Lambda expression
		IRobot r4 = (x) -> System.out.println("pew bang");//Lambda expression
	}
}
