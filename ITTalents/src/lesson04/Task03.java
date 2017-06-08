package lesson04;

import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number");
		int first = sc.nextInt();
		System.out.println("Enter second number");
		int second = sc.nextInt();
		sc.close();

		int start = 0;
		int end = 0;
		if (first < second) {
			start = first;
			end = second;
		} else if (first > second) {
			start = second;
			end = first;
		}
		for (int i = start; i <= end; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
