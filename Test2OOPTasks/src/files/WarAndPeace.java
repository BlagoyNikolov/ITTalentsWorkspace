package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class WarAndPeace {
	public static void main(String[] args) throws IOException {
		File f = new File("voinaImir.txt");
		Scanner sc = new Scanner(f);
		String longest = "";
		int peace = 0;
		int war = 0;
		int lines = 0;
		int symbols = 0;
		int wordsNumber = 0;
		while (sc.hasNextLine()) {
			lines++;
			String line = sc.nextLine();
			symbols+= line.length();
			String[] words = line.split(" ");
			wordsNumber += words.length;
			for (String word : words) {
				if (word.length() > longest.length()) {
					longest = word;
				}
			}
		}
		for (int i = 1; i <= longest.length(); i++) {
			File gen = new File(i+"letter.txt");
			if (!gen.exists()) {
				gen.createNewFile();
			}
			
		}
		Scanner sc2 = new Scanner(f);
		while (sc2.hasNextLine()) {
			TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareToIgnoreCase(o2);
				}
			});
			String line = sc2.nextLine();
			String[] words = line.split(" ");
			for (String word : words) {
				if (word.equalsIgnoreCase("мир") || word.equalsIgnoreCase("мир.") || word.equalsIgnoreCase("мир;") || word.equalsIgnoreCase("мир!") || word.equalsIgnoreCase("мир?") || word.equalsIgnoreCase("мир,")) {
					peace++;
				}
				if (word.equalsIgnoreCase("война") || word.equalsIgnoreCase("войната") || word.equalsIgnoreCase("война.") || word.equalsIgnoreCase("война;") || word.equalsIgnoreCase("война!") || word.equalsIgnoreCase("война?") || word.equalsIgnoreCase("война,")) {
					war++;
				}
				if(!word.isEmpty()){
					set.add(word.trim());
				}
				FileWriter fw = new FileWriter(word.length()+"letter.txt", true);
				fw.write(word + " ");
				fw.flush();
			}
			
		}
		System.out.println("longest word: " + longest);
		System.out.println("peace count: " + peace);
		System.out.println("war count: " + war);
		System.out.println("lines = " + lines);
		System.out.println("symbols = " + symbols);
		System.out.println("words = " +wordsNumber);
	}
}
