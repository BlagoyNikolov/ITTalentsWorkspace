package test1;

import java.util.Random;

public class Zarove2 {
	public static void main(String[] args) {
		Random r = new Random();
		int tries = 0;
		int counter = 0;
		while (true) {
			tries++;
			int first = r.nextInt(6) + 1;
			int second = r.nextInt(6) + 1;
			System.out.println(first + "|" + second);
			if (first == 6 && second == 6) {
				counter++;
			} else {
				counter = 0;
			}
			if (counter == 3) {
				System.out.println("Tries: " + tries);
				break;
			}
		}
	}
}
