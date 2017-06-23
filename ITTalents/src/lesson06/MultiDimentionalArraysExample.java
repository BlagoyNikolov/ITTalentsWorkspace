package lesson06;

import java.util.Scanner;

public class MultiDimentionalArraysExample {
	public static void main(String[] args) {
		int x = 4;
		int[] array = new int[10]; // creates 10 number variables
		int[] array2 = {};
		// System.out.println(array2[0]);
		int[][] matrix = new int[4][3]; // creates 4 arrays of 3 elements each =
										// 12 elements
		int[][] matrix2 = { { 1, 4, 6, 8 }, { 2, 2 }, { 3, 1, 8, 5, 3 }, { 9, 5, 1 } };
		int[][][] ebasiMasivaBate = new int[5][7][2]; // 3 arrays with 3 arrays
														// of integers each

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int rows = sc.nextInt();
		System.out.println("Enter number of cols");
		int cols = sc.nextInt();
		
		int[][] newArray = new int[rows][cols];
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < newArray[i].length; j++) {
				System.out.println("Enter element  at cell [" + i + "][" + j + "]");
				newArray[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < newArray[i].length; j++) {
				System.out.print(newArray[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}
