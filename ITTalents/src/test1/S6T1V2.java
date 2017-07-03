package test1;

import java.util.Scanner;

public class S6T1V2 {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7, 29, 9, 12 };
		//cards();
		stringCounter("Simple sentence thatsd is first.", "Another one thatsd is second.", "Third sentence thatsd is last.");
		System.out.println(sumOfArrayElements(arr, 0));
	}
	
	static void cards() {
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		int tries = 0;
		while (true) {
			tries++;
			String input = sc.nextLine();
			String[] cards = input.split(" ");
			while (!isValid(cards[0]) || !isValid(cards[1])) {
				System.out.println("Invalid cards given!");
				input = sc.nextLine();
				cards = input.split(" ");
			}
			
			if ((cards[0].equals("A") && cards[1].equals("K")) || (cards[0].equals("K") && cards[1].equals("A"))) {
				counter++;
				if (counter == 3) {
					break;
				}
			} else {
				counter = 0;
			}	
		}
		System.out.println("Number of tries: " + tries);
	}
	
	static boolean isValid(String str) {
		if ((str.charAt(0) >= '2' && str.charAt(0) <= '9') || str.equals("T") || str.equals("J") || str.equals("Q") || str.equals("K") || str.equals("A")) {
			return true;
		}
		return false;
	}
	
	static void stringCounter(String first, String second, String third) {
		String[] firstwords = first.split(" ");
		String currentWordFirst = null;
		String currentLongest = "";
		
		for (int i = 0; i < firstwords.length; i++) {
			currentWordFirst = firstwords[i];
			if (second.contains(currentWordFirst) && third.contains(currentWordFirst)) {
				if (currentWordFirst.length() > currentLongest.length()) {
					currentLongest = currentWordFirst;
				}
			}
		}
		System.out.println(currentLongest);
	}
	
	static int sumOfArrayElements(int[] arr, int i) {
		if (i == arr.length) {
			return 0;
		}
		if (arr[i] % 3 == 0) {
			return arr[i] + sumOfArrayElements(arr, i + 1);
		} else {
			return sumOfArrayElements(arr, i + 1);
		}
	}
}
