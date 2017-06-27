package lesson07EX;

public class Task13Spiral {
public static void main(String[] args) {
		

		int n = 8;
		int m = 8;
		
		int[][] matrix = new int[n][m];
		int counter = 10;
		
		char direction = 'D';//can be U, L, R, D
		
		int cellRow = 0;
		int cellCol = 0;
		for (int i = 0; i < n*m; i++) {
			matrix[cellRow][cellCol] = counter++;
			switch(direction){
				case 'D': {
					if((cellRow+1) >= matrix.length || matrix[cellRow+1][cellCol] != 0){
						direction = 'R';
						cellCol++;
					}
					else{
						cellRow++; 
					}
					break;
				}
				case 'U': {
					if((cellRow-1) < 0 || matrix[cellRow-1][cellCol] != 0){
						direction = 'L';
						cellCol--;
					}
					else{
						cellRow--; 
					}
					break;
				}
				case 'L': {
					if((cellCol-1) < 0 || matrix[cellRow][cellCol-1] != 0){
						direction = 'D';
						cellRow++;
					}
					else{
						cellCol--; 
					}
					break;
				}
				
				case 'R': {
					if((cellCol+1) >= matrix[0].length || matrix[cellRow][cellCol+1] != 0){
						direction = 'U';
						cellRow--;
					}
					else{
						cellCol++; 
					}
					break;
				}
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
