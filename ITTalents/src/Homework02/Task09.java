package homework02;

import java.util.Scanner;

public class Task09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number:");
		int firstNumber = sc.nextInt();
		System.out.println("Enter second number:");
		int secondNumber = sc.nextInt();
		sc.close();
		
		int sum = 0;
		for (int i = firstNumber; i <= secondNumber; i++) {
			if (i == secondNumber) {
				if ((i * i) % 3 == 0) {
					System.out.print("skip 3, ");
					continue;
				} else {
					sum = sum + (i * i);		
				}
				System.out.print(i * i);
			} else {
				if ((i * i) % 3 == 0) {
					System.out.print("skip 3, ");
					continue;
				} else {
					sum = sum + (i * i);
				}
				System.out.print(i * i + ", ");
			}
			//System.out.println("[" + sum + "]");
			if (sum > 200) {
				System.out.println(" [Terminated] -> sum is: " + sum);
				break;
			}
		}
	}
}
