package lesson04EX;

import java.util.Scanner;

public class Task08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 1 + i * 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
