package homework06;

import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2D array dimention: ");
		int size = sc.nextInt();
		int[][] array = new int[size][size];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println("Enter element at cell [" + i + "][" + j + "]");
				array[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] newArray = new int[array.length][array.length];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				newArray[i][j] = array[array.length - 1 - j][i];
				System.out.print(newArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}
