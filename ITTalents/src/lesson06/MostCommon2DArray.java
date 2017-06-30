package lesson06;


public class MostCommon2DArray {

	public static void main(String[] args) {
		int[][]arr =  { { 1, 4, 6}, { 2, 2, 2 }, { 3, 1, 2 }, { 9, 5, 1 } };
		
		int mostCommon = 0;
		int currentCounter = 0;
		int maxCounter = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int number = arr[i][j];
				for (int k = 0; k < arr.length; k++) {
					for (int l = 0; l < arr[k].length; l++) {
						if (number == arr[k][l]) {
							currentCounter++;
							if (currentCounter > maxCounter) {
								maxCounter = currentCounter;
								mostCommon = arr[k][l];
							}
						}
					}
					
				}
				currentCounter = 0;
			}
		}
		System.out.println(mostCommon);
		
		// print
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
