package homework02;

import java.util.Scanner;

public class Task07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= number; i++) {
			System.out.print(i * 3 + " ");
		}
	}
}
