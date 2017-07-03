package test1;

import java.util.Scanner;

public class S5T1V1 {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 6, 7, 29, 1 };
		//heads();
		//System.out.println(findFrequentWord("Today is a good day for the test. The sun is shining gracefully. The students are happy. The birds are blue."));
		System.out.println(findDiff(arr, 0, arr[0], arr[0]));
	}
	
	static void heads() {
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (true) {
			String input = sc.nextLine();
			if (input.equals("Heads")) {
				counter++;
				if (counter == 5) {
					break;
				}
			} else {
				counter = 0;
			}
		}
	}
	
	static String findFrequentWord(String text) {
		String[] words = text.split(" ");
		String mostFrequent = null;
		String currentWord = null;
		int counter = 0;
		int maxCounter = 0;
		for (int i = 0; i < words.length; i++) {
			currentWord = words[i];
			for (int j = 0; j < words.length; j++) {
				if (currentWord.equals(words[j])) {
					counter++;
					if (counter > maxCounter) {
						maxCounter = counter;
						mostFrequent = words[j];
					}
				}
			}
			counter = 0;
		}
		return mostFrequent;
 	}
	
	static int findDiff(int[] arr, int i, int max, int min) {
		if (i == arr.length) {
			return (max - min);
		}
		if (arr[i] > max) {
			max = arr[i];
		}
		if (arr[i] < min) {
			min = arr[i];
		}
		return findDiff(arr, i + 1, max, min);
	}
	
	static void gas(char[][] sheet, int i, int j){
		if(sheet[i][j] == 'b'){
			return;
		}
		sheet[i][j] = 'x';
		//i, j+1
		if((j+1 < sheet[i].length) && (sheet[i][j+1] == ' ')){
			gas(sheet, i, j+1);
		}
		//i, j-1
		if(j-1 >= 0 && sheet[i][j-1] == ' '){
			gas(sheet, i, j-1);
		}
		//i+1, j
		if((i+1 < sheet.length) && (sheet[i+1][j] == ' ')){
			gas(sheet, i+1, j);
		}
		//i-1, j
		if((i-1 >= 0) && (sheet[i-1][j] == ' ')){
			gas(sheet, i-1, j);
		}
	}
}
