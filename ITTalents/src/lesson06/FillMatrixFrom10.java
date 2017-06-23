package lesson06;

import java.util.Scanner;

public class FillMatrixFrom10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int rows = sc.nextInt();
		System.out.println("Enter number of cols");
		int cols = sc.nextInt();
		
		int[][] newArray = new int[rows][cols];
		int counter = 0;
		for (int i = 0; i < newArray.length; i++) {
			for (int j = 0; j < newArray[i].length; j++) {
				newArray[i][j] = 10 + counter++; 
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
