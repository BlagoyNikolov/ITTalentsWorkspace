package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class WarAndPeace {
	private String longestWord = "";
	private int peace = 0;
	private int war = 0;
	private int lines = 0;
	private int symbols = 0;
	private int wordsNumber = 0;
	private static WarAndPeace instance = null;
	
	private WarAndPeace() {
      // Exists only to defeat instantiation.
	}
	
	public static WarAndPeace getInstance() {
		if(instance == null) {
			instance = new WarAndPeace();
		}
		return instance;
	}
	
	public void execute() {
		try {
			File book = findLongestWord();
			createFilesWithWordLengths();
			List<TreeSet<String>> sets = createSets();
			fillSets(book, sets);
			WriteSetToFile(sets);
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("Something went wrong");
			ioe.printStackTrace();
		} catch (Exception e) {
			System.out.println("Something terribly went wrong");
			e.printStackTrace();
		}
		printResults();
	}
	
	private File findLongestWord() throws FileNotFoundException {
		File book = new File("voinaImir.txt");
		Scanner sc = new Scanner(book);
		while (sc.hasNextLine()) {
			this.lines++;
			String line = sc.nextLine();
			this.symbols += line.length();
			String[] words = line.split(" ");
			this.wordsNumber += words.length;
			for (String word : words) {
				if (word.length() > this.longestWord.length()) {
					this.longestWord = word;
				}
			}
		}
		sc.close();
		return book;
	}
	
	private void createFilesWithWordLengths() throws IOException {
		for (int i = 0; i <= this.longestWord.length(); i++) {
			File newFileWithWordLength = new File(i + "letterWords.txt");
			if (!newFileWithWordLength.exists()) {
				newFileWithWordLength.createNewFile();
			}
		}
	}
	
	private List<TreeSet<String>> createSets() {
		List<TreeSet<String>> sets = new ArrayList<TreeSet<String>>();
		for (int i = 0; i <= this.longestWord.length(); i++) {
			sets.add(new TreeSet<String>((o1, o2) -> o1.compareToIgnoreCase(o2)));
		}
		return sets;
	}
	
	private void fillSets(File book, List<TreeSet<String>> sets) throws FileNotFoundException {
		Scanner sc2 = new Scanner(book);
		while (sc2.hasNextLine()) {
			String line = sc2.nextLine();
			String[] words = line.split(" ");
			for (String word : words) {
				if (word.equalsIgnoreCase("мир") || word.equalsIgnoreCase("мирът")  || word.equalsIgnoreCase("мир.") || word.equalsIgnoreCase("мир;") || word.equalsIgnoreCase("мир!") || word.equalsIgnoreCase("мир?") || word.equalsIgnoreCase("мир,")) {
					this.peace++;
				}
				if (word.equalsIgnoreCase("война") || word.equalsIgnoreCase("войната") || word.equalsIgnoreCase("война.") || word.equalsIgnoreCase("война;") || word.equalsIgnoreCase("война!") || word.equalsIgnoreCase("война?") || word.equalsIgnoreCase("война,")) {
					this.war++;
				}
				if(!word.isEmpty()){
					sets.get(word.length()).add(word.trim());
				}
			}
		}
		sc2.close();
	}
	
	private void WriteSetToFile(List<TreeSet<String>> sets) throws IOException {
		FileWriter fw = null;
		for (TreeSet<String> set : sets) {
			for (String word : set) {
				fw = new FileWriter(word.length() + "letterWords.txt", true);
				fw.write(word.trim() + "  ");
				fw.flush();
			}
		}
		fw.close();
	}

	private void printResults() {
		System.out.println("War And Peace Stats:");
		System.out.println("Longest word: " + this.longestWord);
		System.out.println("Peace count: " + this.peace);
		System.out.println("War count: " + this.war);
		System.out.println("Lines: " + this.lines);
		System.out.println("Symbols: " + this.symbols);
		System.out.println("Words: " + this.wordsNumber);
	}
}
