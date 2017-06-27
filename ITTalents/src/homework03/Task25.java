package homework03;

import java.util.Scanner;

public class Task25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		
		int result = 1;
		for (int i = 1; i <= number; i++) {
			result *= i;
		}
		System.out.println(result);
	}
}
