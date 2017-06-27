package homework03;

import java.util.Scanner;

public class Task16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired numbers: [10..5555]");
		int firstNumber = sc.nextInt();
		while (firstNumber < 10 || firstNumber > 5555) {
			System.out.println("Invalid number, try again: [10..5555]");
			firstNumber = sc.nextInt();
		}
		int secondNumber = sc.nextInt();
		while (secondNumber < 10 || secondNumber > 5555) {
			System.out.println("Invalid number, try again: [10..5555]");
			secondNumber = sc.nextInt();
		}
		sc.close();

		if (firstNumber > secondNumber) {
			int temp = firstNumber;
			firstNumber = secondNumber;
			secondNumber = temp;
		}
		boolean firstPrinted = false;

		for (int i = secondNumber; i >= firstNumber; i--) {
			if (i % 50 == 0) {
				if (firstPrinted == false) {
					System.out.print(i);
					firstPrinted = true;
				} else {
					System.out.print(", " + i);
				}
			}
		}
	}
}
