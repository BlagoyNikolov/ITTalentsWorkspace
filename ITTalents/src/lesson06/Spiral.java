package lesson06;

public class Spiral {
	public static void main(String[] args) {
		int rows = 5;
		int cols = 4;

		int[][] array = new int[rows][cols];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[j][0] = (j + 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[array.length - 1][j] = (j + array.length);
			}
		}
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[array.length - 1 - i][array[i].length - 1] = (array[rows - 1][cols - 1] + i);
			}
		}

		// print
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

		int[] arr = { 4, 6, 7 };
		int[][] matrix = new int[4][3];
		int[] brr = matrix[1];
		matrix[1] = arr;
		brr[1] = 4;
		matrix[2][0] = arr[1] + brr[1] + matrix[1][1];
		matrix[2][1] = ++matrix[2][0];
		System.out.println(matrix[2][0] + matrix[2][1]);
	}
}
