package lesson07EX;

public class Task10 {
	public static void main(String[] args) {
		int[] array = { 4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3, 4 };
		
		int tempCounter = 1;
		int number = 0;
		int maxCounter = 0;
		int mostPopular = array[0];
		
		for (int i = 0; i < array.length; i++) {
			number = array[i];
			for (int j = 1; j < array.length; j++) {
				if (number == array[j]) {
					tempCounter++;
				}
			}
			if (tempCounter > maxCounter) {
				mostPopular = number;
				maxCounter = tempCounter;
			}
			tempCounter = 0;
		}
		System.out.println("Number " + mostPopular + " counter " + maxCounter);
	}
}
