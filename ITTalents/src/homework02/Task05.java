package homework02;
import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		System.out.println("Enter first number:");
		Scanner sc = new Scanner(System.in);
		double firstNumber = sc.nextDouble();
		System.out.println("Enter second number:");
		double secondNumber = sc.nextDouble();
		System.out.println("Enter third number:");
		double thirdNumber = sc.nextDouble();
		sc.close();
		
		if (firstNumber > secondNumber && secondNumber > thirdNumber) {
			System.out.println(firstNumber + " " + secondNumber + " " + thirdNumber);
		}
		if (firstNumber > thirdNumber && thirdNumber > secondNumber) {
			System.out.println(firstNumber + " " + thirdNumber + " " + secondNumber);
		}
		if (secondNumber > firstNumber && firstNumber > thirdNumber) {
			System.out.println(secondNumber + " " + firstNumber + " " + thirdNumber);
		}
		if (secondNumber > thirdNumber && thirdNumber > firstNumber) {
			System.out.println(secondNumber + " " + thirdNumber + " " + firstNumber);
		}
		if (thirdNumber > firstNumber && firstNumber > secondNumber) {
			System.out.println(thirdNumber + " " + firstNumber + " " + secondNumber);
		}
		if (thirdNumber > secondNumber && secondNumber > firstNumber) {
			System.out.println(thirdNumber + " " + secondNumber + " " + firstNumber);
		}
	}
}