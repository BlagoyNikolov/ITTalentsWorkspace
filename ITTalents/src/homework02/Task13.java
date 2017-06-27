package homework02;

import java.util.Scanner;

public class Task13 {
	public static void main(String[] args) {
		System.out.println("Enter desired temperature:");
		Scanner sc = new Scanner(System.in);
		int temperature = sc.nextInt();
		
		if (temperature < -20) {
			System.out.println("freezing");
		}
		if (temperature >= -20 && temperature < 0) {
			System.out.println("cold");
		}
		if (temperature >= 0 && temperature < 15) {
			System.out.println("moderate");
		}
		if (temperature >= 15 && temperature < 25) {
			System.out.println("warm");
		}
		if (temperature >= 25) {
			System.out.println("hot");
		}
	}
}
