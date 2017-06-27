package homework06;

public class Book02 {
	public static void main(String[] args) {
		int[][] array = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 }, { 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, { 51, 52, 53, 54, 55, 56 }, { 61, 62, 63, 64, 65, 66 } };
		
		int rowIndex = 0;
		int sum = 0;
		int maxRowSum = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				if (sum > maxRowSum) {
					maxRowSum = sum;
					rowIndex = i;
				}
			}
			sum = 0;
		}
		
		System.out.println(maxRowSum);
		for (int i = 0; i < array[rowIndex].length; i++) {
			System.out.print(array[rowIndex][i] + " ");
		}
	}
}
