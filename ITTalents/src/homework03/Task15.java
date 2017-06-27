package homework03;

import java.util.Scanner;

public class Task15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired number:");
		int number = sc.nextInt();
		sc.close();
		
		int counter = 1;
		int sum = 0;
		while (counter <= number) {
			sum += counter;
			counter++;
		}
		System.out.println(sum);
	}
}
