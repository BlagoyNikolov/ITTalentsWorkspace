package homework06;

public class Book03 {
	public static void main(String[] args) {		
		int[][] array = { { 1, 4, 6, 3 }, { 5, 9, 7, 2 }, { 4, 8, 1, 9 }, { 2, 3, 4, 5 } };
		
		int sumOfPrimary = 0;
		int sumOfSecondary = 0;
		
		for (int i = 0; i < array.length; i++) {
			sumOfPrimary += array[i][i];
			for (int j = 0; j < array[i].length; j++) {
				if (i + j == array.length - 1) {
					sumOfSecondary += array[i][j];
				}
			}
		}
		System.out.println(sumOfPrimary < sumOfSecondary ? sumOfSecondary : sumOfPrimary);
	}
}
