package dawdawdasdwad1;

import java.util.Scanner;

public class Task09 {
	public static void main(String[] args) {
		System.out.println("Enter 2 two-digit numbers: [10..99]");
		Scanner sc = new Scanner(System.in);
		int firstNumber = sc.nextInt();
		
		if (firstNumber < 10 || firstNumber > 99) {
			System.out.println("Invalid number try again: [10..99]");
			firstNumber = sc.nextInt();
		}
		
		int secondNumber = sc.nextInt();
		if (secondNumber < 10 || secondNumber > 99) {
			System.out.println("Invalid number try again: [10..99]");
			secondNumber = sc.nextInt();
		}
		
		int product = firstNumber * secondNumber;
		int lastDigitOfProduct = product % 10;
		
		if (lastDigitOfProduct % 2 == 0) {
			System.out.println(product + ", " + lastDigitOfProduct + " Prime");
		} else {
			System.out.println(product + ", " + lastDigitOfProduct + " Not prime");
		}
	}
}
