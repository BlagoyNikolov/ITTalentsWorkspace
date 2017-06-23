package lesson07EX;

import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter char pls");
		char symbol = sc.next().charAt(0);
		sc.close();
		char[] charArray = { 'a', '*', '&', 'c', 'z', '#' };

		int charIndex = 0;
		boolean isCharPresent = false;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == symbol) {
				isCharPresent = true;
				charIndex = i;
				break;
			}
		}
		System.out.print(isCharPresent ? "present " : "not present ");
		System.out.print("at index " + (charIndex != 0 ? charIndex : "N/A"));
	}
}
