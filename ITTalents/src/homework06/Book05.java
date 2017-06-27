package homework06;

public class Book05 {
	public static void main(String[] args) {		
		int[][] array = { { 1, 4, 6, 3 }, { 5, 9, 7, 2 }, { 4, 8, 1, 9 }, { 2, 3, 4, 5 } };
		
		int product = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i > j) {
					product *= array[i][j];
				}
			}
		}
		System.out.println(product);
	}
}
