package lesson07EX;

public class Task06 {
	public static void main(String[] args) {
		char[][] charArray = { { 'a', '*', '&'}, {'c', 'z', '#'}, {'(', '`', '@'} };
		
//		for (int i = 0; i < charArray.length; i++) {
//			 for (int j = 0; j < charArray[i].length; j++) {
//				if (i == i) {
//					System.out.print(charArray[i][i] + " ");
//				}
//			}
//		}
		
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i][i] + " ");
		}
	}
}
