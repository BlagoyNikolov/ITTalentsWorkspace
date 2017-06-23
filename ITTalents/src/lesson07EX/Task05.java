package lesson07EX;

public class Task05 {
	public static void main(String[] args) {
		int[][]array =  { { 1, 4, 6}, { 2, 2, 2 }, { 3, 1, 8 }, { 9, 5, 1 } };
		
		int maxRowSum = 0;
		int currentRowSum = 0;
		int rowIndex = 0;
		int rowLength = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				currentRowSum += array[i][j];
				if (currentRowSum > maxRowSum) {
					maxRowSum = currentRowSum;
					rowIndex = i;
					rowLength = array[i].length;
				}
			}
			currentRowSum = 0;
		}
		
		System.out.println("The row with the max sum is:");
		for (int i = 0; i < array[rowLength].length; i++) {
			System.out.print(array[rowIndex][i] + " ");
		}
	}
}
