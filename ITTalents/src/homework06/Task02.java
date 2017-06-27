package homework06;

import java.util.Scanner;

public class Task02 {
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

		//int[][] array = { { 1, 4, 6, 3 }, { 5, 9, 7, 2 }, { 4, 8, 1, 9 }, { 2, 3, 4, 5 } };
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i == j) {
					System.out.print(array[i][j] + " ");
				}
			}
		}
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i + j == array.length - 1) {
					System.out.print(array[i][j] + " ");
				}
			}
		}
	}
}
