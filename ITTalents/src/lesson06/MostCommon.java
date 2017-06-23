package lesson06;


public class MostCommon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]array =  { { 1, 4, 6}, { 2, 2, 2 }, { 3, 1, 8 }, { 9, 5, 1 } };
		
		int currentMax = array[0][0];
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				
			}
		}
		
		// print
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}
