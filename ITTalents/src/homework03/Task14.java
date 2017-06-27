package homework03;

import java.util.Scanner;

public class Task14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number: [10..200]");
		int number = sc.nextInt();
		while (number < 10 || number > 200) {
			System.out.println("Invalid number, try again: [10..200]");
			number = sc.nextInt();
		}
		sc.close();
		
		for (int i = 200; i > 10; i--) {
			if (i % 7 == 0 && i < number) {
				System.out.print(i + " ");
			}
		}
	}
}
