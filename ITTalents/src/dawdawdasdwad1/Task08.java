package dawdawdasdwad1;

import java.util.Scanner;

public class Task08 {
	public static void main(String[] args) {
		System.out.println("Enter a number: [1000.. 9999]");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		if (number < 1000 || number > 9999) {
			System.out.println("Invalid number try again: [1000.. 9999]");
			number = sc.nextInt();
		}
		
		int firstNumber = number / 1000 * 10 + number % 10;
		int secondNumber = ((number / 100) % 10) * 10 + ((number / 10) % 10);
		
		if (firstNumber < secondNumber) {
			System.out.println(firstNumber + "<" + secondNumber);
		}
		if (firstNumber == secondNumber) {
			System.out.println(firstNumber + "=" + secondNumber);
		}
		if (firstNumber > secondNumber) {
			System.out.println(firstNumber + ">" + secondNumber);
		}
	}
}
