package lesson07EX;

public class Task12Diagonal {
public static void main(String[] args) {
		
		int n = 5;
		int m = 11;
		
		int[][] matrix = new int[n][m];
		int counter = 10;
		
		for (int row = 0; row < matrix.length; row++) {
			//start new diagonal
			int diRow = row;
			int diCol = 0;
			while(diRow >= 0 && diCol <= matrix[0].length-1){
				matrix[diRow][diCol] = counter++;
				diRow--;
				diCol++;
			}
		}
		
		for (int col = 1; col < matrix[0].length; col++) {
			int diRow = matrix.length-1;
			int diCol = col;
			while(diRow >= 0 && diCol <= matrix[0].length-1){
				matrix[diRow][diCol] = counter++;
				diRow--;
				diCol++;
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
