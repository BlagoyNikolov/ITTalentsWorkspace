package homework02;
import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		int firstNumber = sc.nextInt();
		System.out.println("Enter first number:");
		int secondNumber = sc.nextInt();
		sc.close();
		
		System.out.println("Old vars: " + firstNumber + " " + secondNumber);		
		int temp = firstNumber;
		firstNumber = secondNumber;
		secondNumber = temp;
		System.out.println("New vars: " + firstNumber + " " + secondNumber);
	}
}
