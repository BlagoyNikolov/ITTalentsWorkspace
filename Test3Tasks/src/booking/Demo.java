package booking;

public class Demo {

	public static void main(String[] args) {
		
		Library britishLib = new Library();
		Nerd kornelia = new Nerd(britishLib);
		kornelia.start();
		
	}
}
