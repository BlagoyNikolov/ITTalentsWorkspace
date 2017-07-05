package test1;

import java.util.Scanner;

public class S8T1V0 {
	public static void main(String[] args) {
		cards();
		String[] output = sorted("Hword Bword Zword Aword");
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		int[] arr = { 9, 8, 5, 3, 2, 4, 1, 7, 11, 12, 13, 15 };
		System.out.println(recursion(arr, 0, 6));
	}
	
	static void cards() {
		Scanner sc = new Scanner(System.in);
		String[] strength = new String[5];
		String[] color = new String[5];
		while (true) {
			for (int i = 0; i < 5; i++) {
				System.out.println("enter card strength");
				strength[i] = sc.nextLine();
				System.out.println("enter card color");
				color[i] = sc.nextLine();
				while (!isValid(strength[i])) {
					System.out.println("invalid cards!");
					strength[i] = sc.nextLine();
				}
			}
			
			for (int i = 1; i < color.length - 1; i++) {
				if (color[i - 1].equals(color[i]) && color[i].equals(color[i + 1])) {
					for (int j = 0; j < strength.length; j++) {
						
					}
				}
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
	
	static String[] sorted(String text) {
		String[] words = text.split(" ");
		for (int i = 0; i < words.length; i++) {
			for (int j = 1; j < words.length; j++) {
				if (words[j - 1].charAt(0) > words[j].charAt(0)) {
				//if (words[j - 1].compareTo(words[j]) > 0) {
					String temp = words[j - 1];
					words[j - 1] = words[j];
					words[j] = temp;
				}
			}
		}
		return words;
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
}
