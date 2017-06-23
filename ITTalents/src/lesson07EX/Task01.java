package lesson07EX;

public class Task01 {
	public static void main(String[] args) {
		int[][] array = { { 1, 4, 6, 8 }, { 2, 2 }, { 2, 1, 8, 5, 3 }, { 9, 5, 1 } };
		
		boolean areNeotricatelni = true;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] < 0) {
					areNeotricatelni = false;
					break;
				}
			}
		}
		System.out.println(areNeotricatelni ? "all are neotr" : "not all are neotr");
	}
}
