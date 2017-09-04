package recap;

public class Piqnica {
	private void piq() {
		System.out.println("piqn sum");
	}
	
	class RuskaPiqnica extends Piqnica {
		int age = 5;
		void piq() {
			System.out.println("Dai vodka");
		}
	}
	
	
}
