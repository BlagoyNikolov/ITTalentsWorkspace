package homework06;

import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numebr of array rows: ");
		int rows = sc.nextInt();
		System.out.println("Enter numebr of array columns: ");
		int cols = sc.nextInt();
		int[][] array = new int[rows][cols];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println("Enter element at cell [" + i + "][" + j + "]");
				array[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// int[][] array = { { 1, 4, 6, 3 }, { 5, 9, 7, 2 }, { 4, 8, 1, 9 }, { 2, 3, 4, 5 } };
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum = sum + array[i][j];
			}
		}

		double avg = sum / (rows * cols);
		System.out.println("Sum: " + sum + " Avg: " + avg);
	}
}
