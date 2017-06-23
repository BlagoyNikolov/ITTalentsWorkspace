package lesson07EX;

public class Task08 {
	public static void main(String[] args) {
		boolean[][] boolMatrix = { { false, false, false, true }, 
									{ false, false, true, false },
									{ false, true, false, true }, 
									{ false, true, false, true } };
		
		boolean isTruePresent = false;
		for (int i = 0; i < boolMatrix.length; i++) {
			for (int j = 0; j < boolMatrix[i].length; j++) {
				if (i + j < boolMatrix.length - 1) {
					if (boolMatrix[i][j]) {
						isTruePresent = true;
						break;
					}
				}
			}
		}
		System.out.println("Is true present above secondary diagonal? " + isTruePresent);
	}
}
