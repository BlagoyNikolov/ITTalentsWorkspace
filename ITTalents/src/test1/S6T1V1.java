package test1;

import java.util.Scanner;

public class S6T1V1 {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 6, 7, 29, 1 };
		//cards();
		textCounter("Today is a good day for test. Sun is shining like a goddamn motherfucker. The students are happy. The birds are blue.");
		System.out.println("are all the elements in the array positive? " + recPositive(arr, 0, false));
		char[][] labyrinth = {{' ', ' ', ' ', ' '},
	  			              {' ', 'K', ' ', ' '},
	  			              {' ', ' ', ' ', ' '},
	  			              {' ', ' ', ' ', ' '}};
		System.out.println(findKing(labyrinth, 2, 3, 0, 2));
	}
	
	static void cards() {
		System.out.println("Enter pair of cards");
		Scanner sc = new Scanner(System.in);
		int counter = 1;
		
		while (true) {
			String input = sc.nextLine();
			String[] cards = input.split(" ");
			while (!isValid(cards[0]) || !isValid(cards[1])) {
				System.out.println("invalid cards given!");
				input = sc.nextLine();
				cards = input.split(" ");
			}
			
			if (cards[0].equals("A") && cards[1].equals("A")) {
				System.out.println("Number of tries " + counter);
				break;
			} else {
				counter++;
			}
		}
	}
	
	static boolean isValid(String input) {
		if ((input.charAt(0) >= '2' && input.charAt(0) <= '9') || input.equals("T") || input.equals("J")
				|| input.equals("Q") || input.equals("K") || input.equals("A")) {
			return true;
		}
		return false;
	}
	
	static void textCounter(String text) {
		String[] sentences = text.split("\\.");
		int numberOfSentences = sentences.length;
		String longestSentence = null;
		int longeseSentenceLength = 0;
		String currentSentence = null;

		for (int i = 0; i < sentences.length; i++) {
			currentSentence = sentences[i];
			if (currentSentence.length() > longeseSentenceLength) {
				longeseSentenceLength = currentSentence.length();
				longestSentence = currentSentence;
			}
		}
		
		System.out.println("LongestSentence: " + longestSentence);
		System.out.println("numberOfSentences: " + numberOfSentences);
	}
	
	static boolean recPositive(int[] arr, int i, boolean flag) {
		if (i == arr.length) {
			return flag;
		}
		if (arr[i] >= 0) {
			flag = true;
		} else {
			flag = false;
			return flag;
		}
		return recPositive(arr, i + 1, flag);
	}
	
	static boolean findKing(char[][] sheet, int beginI, int beginJ, int endI, int endJ){
		if(sheet[beginI][beginJ] == 'X'){
			return false;
		}
		if(beginI == endI && beginJ == endJ){
			return true;
		}
		if(sheet[beginI][beginJ] == 'K'){
			return true;
		}
		sheet[beginI][beginJ] = 'o';
		//i-2, j-1
		if(beginI-2 >= 0 && beginJ-1 >= 0 && (sheet[beginI-2][beginJ-1] == ' ')){
			return findKing(sheet, beginI-2, beginJ-1, endI, endJ);
		}
		//i-2, j+1
		if(beginI-2 >= 0 && beginJ+1 < sheet.length && sheet[beginI-2][beginJ+1] == ' '){
			return findKing(sheet, beginI-2, beginJ+1, endI, endJ);
		}
		//i-1, j-2
		if((beginI-1 >= 0) && (beginJ-2 >= 0) && (sheet[beginI-1][beginJ-2] == ' ')){
			return findKing(sheet, beginI-1, beginJ-2, endI, endJ);
		}
		//i-1, j+2
		if((beginI-1 >= 0) && beginJ+2 < sheet.length && (sheet[beginI-1][beginJ+2] == ' ')){
			return findKing(sheet, beginI-1, beginJ+2, endI, endJ);
		}
		return false;
	}
}
