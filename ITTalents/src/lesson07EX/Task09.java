package lesson07EX;

public class Task09 {
	public static void main(String[] args) {
		int[][] array = { { 1, 4, 6, 8 }, { 2, 2, 2, 0 }, { 3, 1, 8, 2 }, { 9, 5, 1, 6 } };

		int currentMatrixSum = 0;
		int maxMatrixSum = 0;
		int indexI = 0;
		int indexJ = 0;

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array[i].length - 1; j++) {
				currentMatrixSum += array[i][j] + array[i][j + 1] + array[i + 1][j] + array[i + 1][j + 1];
		
				if (currentMatrixSum > maxMatrixSum) {
					maxMatrixSum = currentMatrixSum;
					indexI = i;
					indexJ = j;
				}
				currentMatrixSum = 0;
			}
		}
		
		System.out.println(array[indexI][indexJ] + " " + array[indexI][indexJ + 1]);
		System.out.println(array[indexI + 1][indexJ] + " " + array[indexI + 1][indexJ + 1]);
		System.out.println(maxMatrixSum);
	}
}
