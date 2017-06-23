package homework04;

public class Book06 {
	public static void main(String[] args) {
		int[][] array = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 }};
		
		int rowSum = 0;
		int crs = 0;
		int colSum = 0;
		int ccs = 0;
		int mainDiagonalSum = 0;
		int cmds = 0;
		int secDiagonalSum = 0;
		int csds = 0;
		boolean isMagical = true;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				rowSum += array[i][j];
				colSum += array[j][i];
				mainDiagonalSum += array[j][j];
	
				if (i + j == array.length - 1) {
					secDiagonalSum += array[i][j];
				}
			}
//			if (crs > rowSum || ccs > colSum || cmds > mainDiagonalSum || csds > secDiagonalSum) {
//				isMagical = false;
//			}
			crs = rowSum;
			ccs = colSum;
			cmds = mainDiagonalSum;
			csds = secDiagonalSum;
			rowSum = 0;
			colSum = 0;
			mainDiagonalSum = 0;
			secDiagonalSum = 0;
			System.out.println(isMagical);
		}
		System.out.println(crs);
		System.out.println(ccs);
		System.out.println(cmds);
		System.out.println(csds);
		
	}
}
