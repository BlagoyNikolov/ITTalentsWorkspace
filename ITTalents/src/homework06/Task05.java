package homework06;

import java.util.Scanner;

public class Task05 {
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
		int maxRowSum = 0;
		int maxColSum = 0;
		int tempRowSum = 0;
		int tempColSum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				tempRowSum += array[i][j];
				if (tempRowSum > maxRowSum) {
					maxRowSum = tempRowSum;
				}

				tempColSum += array[j][i];
				if (tempColSum > maxColSum) {
					maxColSum = tempColSum;
				}
			}
			tempRowSum = 0;
			tempColSum = 0;
		}
		System.out.println(maxRowSum + " " + maxColSum);
		System.out.println(maxRowSum < maxColSum ? "maxRowSum < maxColSum" : "maxRowSum > maxColSum");
	}
}
