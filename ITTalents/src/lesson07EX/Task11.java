package lesson07EX;

public class Task11 {
	public static void main(String[] args) {
		int row = 4;
		int col = 3;
		int[][] matrix = new int[row][col];

		int diff = Math.abs(row - col);
		int start = 1;
		int counter = 0;
		for (int i = 0; i < matrix.length + diff; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][i] = start + counter++;
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
