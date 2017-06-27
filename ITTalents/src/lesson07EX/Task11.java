package lesson07EX;

public class Task11 {
	public static void main(String[] args) {
		int row = 4;
		int col = 5;
		int[][] matrix = new int[row][col];

		int start = 1;
		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = start + counter++;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
