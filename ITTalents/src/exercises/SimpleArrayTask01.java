package exercises;

import java.util.Scanner;

public class SimpleArrayTask01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] workers = new String[10];
		for (int i = 0; i < workers.length; i++) {
			System.out.println("Enter worker " + (i + 1) + " names:");
			workers[i] = sc.nextLine();
		}
		for (int i = 0; i < workers.length; i++) {
			System.out.println(workers[i]);
		}
		for (int i = workers.length - 1; i > 0; i--) {
			System.out.println(workers[i]);
		}
	}
}
