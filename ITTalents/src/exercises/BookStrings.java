package exercises;

public class BookStrings {
	public static void main(String[] args) {
		String[] output = firstLetterToUpper("qkaaATaa zada4AAa");
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		countStuff("taa zada4a hi4 ne e lo6a bate");
		System.out.println(isPalindrome("illuminati"));
		System.out.println(letterShifter("hellothere"));
		letterCounter("az obi4am banica bate", 'a');
		printRhombus(4);
		
		letterOccurence("starwarstheforceawakensaaa");
		printFrame(new String[] {"Hello", "world", "in", "a", "frame", "starwars"});
	}
	
	static String[] firstLetterToUpper(String input) {
		String[] output = input.split(" ");
		for (int i = 0; i < output.length; i++) {
			output[i] = output[i].substring(0, 1).toUpperCase() + output[i].substring(1).toLowerCase(); 
		}
		return output;
	}
	
	static void countStuff(String input) {
		String[] output = input.split(" ");
		int longest = output[0].length();
		for (int i = 0; i < output.length; i++) {
			if (output[i].length() > longest) {
				longest = output[i].length();
			}
		}
		System.out.println("The number of words is " + output.length);
		System.out.println("The longest word has " + longest + " chars");
	}
	
	static boolean isPalindrome(String input) {
		boolean flag = true;
		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	static String letterShifter(String input) {
		char[] charr = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			charr[i] = (char) (input.charAt(i) + 5);
		}
		return new String(charr);
	}
	
	static void letterCounter(String text, char c) {
		int counter = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == c) {
				counter++;
			}
		}
		System.out.println("The symbol '" + c + "' has occured " + counter + " times");
	} 
	
	static void printRhombus(int n) { //4
		int counter = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = n - 1 - i; j > 0; j--) {
				System.out.print(" ");
			}
			if (i == 0) {
				System.out.print(i + 1);
			} else {
				System.out.print(i + 1);
				for (int j = 1; j < i * 2; j++) {
					System.out.print("*");
				}
				System.out.print(i + 1);
			}
			System.out.println();
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			if (i == n - 2) {
				System.out.print(1);
			}else {
				System.out.print(counter);
				for (int j = counter * 2 - 3; j > 0; j--) {
					System.out.print("*");
				}
				System.out.print(counter);
				counter--;
			}
			System.out.println();
		}
	}
	
	static void letterOccurence(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int counter = 0;
		int maxCounter = 0;
		char mostCommon = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			char letter = alphabet.charAt(i);
			for (int j = 0; j < text.length(); j++) {
				if (letter == text.charAt(j)) {
					counter++;
					if (counter > maxCounter) {
						maxCounter = counter;
						mostCommon = text.charAt(j);
					}
				}
			}
			System.out.println("letter " + letter + " -> " + counter);
			counter = 0;
		}
		System.out.println(mostCommon);
	}
	
	static void printFrame(String[] text) {
		int longest = 0;
		for (int i = 0; i < text.length; i++) {
			if (text[i].length() > longest) {
				longest = text[i].length();
			}
		}
		
		for (int i = 0; i < longest + 2; i++) {
			System.out.print('*');
		}
		System.out.println();
		
		for (int i = 0; i < text.length; i++) {
			System.out.print('*');
			
			for (int j = 0; j < text[i].length(); j++) {
				System.out.print(text[i].charAt(j));
			}
			for (int j = 0; j < longest - text[i].length(); j++) {
				System.out.print(' ');
			}
			System.out.print('*');
			System.out.println();
		}
		
		for (int i = 0; i < longest + 2; i++) {
			System.out.print('*');
		}
	}
}
