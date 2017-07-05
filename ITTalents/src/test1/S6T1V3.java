package test1;

import java.util.Scanner;

public class S6T1V3 {
	public static void main(String[] args) {
		// cards();
		String[] vtora = stringZadacha("Simple sentence that is first.", "Another sentence that is second.");
		for (String item : vtora) {
			System.out.print(item + " ");
		}
		int[] arr = { 9, 8, 5, 3, 2, 4, 1, 7, 11, 12, 13, 15 };
		System.out.println(recursion(arr, 0, 6));
		
		char[][] labyrinth = {{' ', ' ', 'W', 'W'},
							  {'W', ' ', ' ', 'W'},
							  {'W', 'W', ' ', 'W'},
							  {'W', 'W', ' ', ' '}};
		System.out.println(findPath(labyrinth, 0, 0, 3, 3));
	}

	static void cards() {
		Scanner sc = new Scanner(System.in);
		int tries = 0;
		while (true) {
			String str = sc.nextLine();
			String[] cards = str.split(" ");
			while (!isValid(cards[0]) || !isValid(cards[1]) || !isValid(cards[2])) {
				System.out.println("invalid cards!");
				str = sc.nextLine();
				cards = str.split(" ");
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

	static String[] stringZadacha(String first, String second) {
		String[] firstSent = first.split(" ");
		String[] secondSent = second.split(" ");
		StringBuilder sb = new StringBuilder();
		String currentWord = "";
		boolean flag = true;
		for (int i = 0; i < firstSent.length; i++) {
			currentWord = firstSent[i];
			for (int j = 0; j < secondSent.length; j++) {
				if (currentWord.equals(secondSent[j])) {
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
			if (!flag) {
				sb.append(currentWord);
				sb.append(" ");
			}
		}
		String output = sb.toString();
		return output.split(" ");
	}

	static int recursion(int[] arr, int i, int x) {
		if (i == arr.length) {
			return 1;
		}
		if (arr[i] % 2 != 0 && arr[i] > x) {
			return arr[i] * recursion(arr, i + 1, x);
		}
		return recursion(arr, i + 1, x);
	}
	
	static boolean findPath(char[][] sheet, int beginI, int beginJ, int endI, int endJ){
		if(sheet[beginI][beginJ] == 'W'){
			return false;
		}
		sheet[beginI][beginJ] = 'x';
		if(beginI == endI && beginJ == endJ){
			return true;
		}
		
		//i, j+1
		if((beginJ+1 < sheet[beginI].length) && (sheet[beginI][beginJ+1] == ' ')){
			return findPath(sheet, beginI, beginJ+1, endI, endJ);
		}
		//i, j-1
		if(beginJ-1 >= 0 && sheet[beginI][beginJ-1] == ' '){
			return findPath(sheet, beginI, beginJ-1, endI, endJ);
		}
		//i+1, j
		if((beginI+1 < sheet.length) && (sheet[beginI+1][beginJ] == ' ')){
			return findPath(sheet, beginI+1, beginJ, endI, endJ);
		}
		//i-1, j
		if((beginI-1 >= 0) && (sheet[beginI-1][beginJ] == ' ')){
			return findPath(sheet, beginI-1, beginJ, endI, endJ);
		}
		return false;
	}
}
