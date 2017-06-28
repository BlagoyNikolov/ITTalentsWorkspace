package lesson08;

public class IteratingStrings {

	public static void main(String[] args) throws InterruptedException {
		
		String text = "Kravata, kakto nauchihme dnes, dava 20 litra mliako na den";
		
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < text.length(); i++) {
				System.out.print(text.charAt(i));
				Thread.sleep(50);
			}
			System.out.println();
		}
	}
}
