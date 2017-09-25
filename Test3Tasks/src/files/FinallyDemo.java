package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinallyDemo {
	public static void main(String[] args) {
		findLongestWord();
	}
	
	private static void findLongestWord() {
		File book = new File("voinaImir.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(book);
			System.out.println("scanning book done");
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] words = line.split(" ");
			for (String word : words) {
				System.out.println(word);
			}
		}
		sc.close();
	}
}
