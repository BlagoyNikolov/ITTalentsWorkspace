package test1;

import java.util.Scanner;

public class SXT1V0 {
	public static void main(String[] args) {
		int[] arr = { -2, -2, -6, -7, -29, 1 };
		//cards();
		//textCounter("Today is a good day for the test.The sun is shining gracefully.The students are happy.The birds are blue.");
		//System.out.println("are all the elements in the array negative? " + areNegative(arr, 0, false));
		
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
			
			if (cards[0].equals("Q") && cards[1].equals("Q")) {
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
		String[] words = text.replaceAll("\\.", " ").toLowerCase().split(" ");
		int numberOfWords = words.length;
		String longestWord = null;
		int longeseWordLength = 0;
		String mostCommon = null;
		String currentLetter = null;
		int counter = 0;
		int mostCommonMax = 0;
		
		for (int i = 0; i < words.length; i++) {
			currentLetter = words[i];
			longeseWordLength = words[i].length();
			for (int j = 0; j < words.length; j++) {
				if (currentLetter.equals(words[j])) {
					counter++;
					if (counter > mostCommonMax) {
						mostCommonMax = counter;
						mostCommon = words[j];
					}
				}
				if (words[j].length() > longeseWordLength) {
					longeseWordLength = words[j].length();
					longestWord = words[j];
				}
			}
			counter = 0;
		}
		
		System.out.println("There are: " + numberOfWords + " words");
		System.out.println("Longest word: " + longestWord);
		System.out.println("Most common word: " + mostCommon);
	}
	
	static boolean areNegative(int[] arr, int i, boolean flag) {
		if (i == arr.length) {
			return flag;
		}
		if (arr[i] < 0) {
			flag = true;
		} else {
			flag = false;
			return flag;
		}
		return areNegative(arr, i + 1, flag);
	}
}
