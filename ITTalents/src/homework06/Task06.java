package homework06;

import java.util.Scanner;

public class Task06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2D array elements to fill the 6x6 grid: ");
		int[][] array = new int[6][6];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println("Enter element at cell [" + i + "][" + j + "]");
				array[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// int[][] array = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25,
		// 26 }, { 31, 32, 33, 34, 35, 36 },
		// { 41, 42, 43, 44, 45, 46 }, { 51, 52, 53, 54, 55, 56 }, { 61, 62, 63,
		// 64, 65, 66 } };

		int rowSum = 0;
		int globalSum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i == 1 || i == 3 || i == 5) {
					rowSum += array[i][j];
					globalSum += array[i][j];

					if (j == array[i].length - 1) {
						System.out.print(array[i][j]);
					} else {
						System.out.print(array[i][j] + ", ");
					}
				}
			}
			if (i == 1 || i == 3 || i == 5) {
				System.out.print(" sum: " + rowSum);
				System.out.println();
				rowSum = 0;
			}
		}
		System.out.println("Global sum is: " + globalSum);
	}
}
