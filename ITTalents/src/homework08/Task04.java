package homework08;

import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		nameLetterCounter(getNames());
	}
	
	public static String nameLetterCounter(String[] names) {
		int maxSum = 0;
		int currentSum = 0;
		String output = null;
		for (int i = 0; i < names.length; i++) {
			names[i] = names[i].trim();
			for (int j = 0; j < names[i].length(); j++) {
				currentSum += names[i].charAt(j);
				if (maxSum < currentSum) {
					maxSum = currentSum;
					output = names[i];
				}
			}
			currentSum = 0;
		}
		System.out.println(output);
		return output;
	}

	public static String[] getNames() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the names of two people, divided by a ','");
		String input = sc.nextLine();
		while (input.contains(" ") || input.isEmpty()) {
			System.out.println("Enter a valid string pls:");
			input = sc.nextLine();
		}
		String[] names = input.split(",");
		return names;
	}
}
