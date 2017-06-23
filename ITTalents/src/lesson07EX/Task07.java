package lesson07EX;

public class Task07 {
	public static void main(String[] args) {
		int[][] array = { { 1, 4, 6, 8 }, { 2, 2, 2, 0 }, { 3, 1, 8, 2 }, { 9, 5, 1, 6 } };
		
		int sumOfElementsUnderDiagonal = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i > j) {
					sumOfElementsUnderDiagonal += array[i][j];
				}
			}
		}
		System.out.println("The sum of elements under the main diagonal is: " + sumOfElementsUnderDiagonal);
	}
}
