package homework03;

import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		int firstNumber = sc.nextInt();
		System.out.println("Enter second number:");
		int secondNumber = sc.nextInt();
		sc.close();
		
		if (firstNumber < secondNumber) {
			for (int i = firstNumber; i <= secondNumber; i++) {
				System.out.print(i + " ");
			}
		} else 
		if (firstNumber > secondNumber) {
			for (int i = secondNumber; i <= firstNumber; i++) {
				System.out.print(i + " ");
			}
		}
	}
}
