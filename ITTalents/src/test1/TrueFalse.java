package test1;

import java.util.Random;

public class TrueFalse {
	public static void main(String[] args) {
		int counter = 0;
		Random random = new Random();
		while (true) {
			boolean first = random.nextBoolean();
			boolean second = random.nextBoolean();
			System.out.println(first + "|" + second);
			if (first == true && second == true) {
				counter++;
			} else {
				counter = 0;
			}
			if (counter == 7) {
				System.out.println("Exit");
				break;
			}
		}
	}
}
