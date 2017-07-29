package exercises;

import java.util.Scanner;

public class Besenica {
	public static void main(String[] args) {
		String input = "laptop";
		char[] word = input.toCharArray();
		char[] mask = new char[word.length];
		for (int i = 0; i < mask.length; i++) {
			mask[i] = '_';
		}
		
		char[][] grid = {{'_', '_', '_', '_', '_', '_', ' ', ' '},
		         {'|', '/', ' ', ' ', ' ', '|', ' ', ' '},
		         {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
		         {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
		         {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
		         {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
		
		quess(word, mask, grid);
	}

	private static void quess(char[] word, char[] mask, char[][] grid) {
		Scanner sc = new Scanner(System.in);
		int misses = 0;
		while (!solved(mask)) {
			printMask(mask);
			System.out.println("\nEnter char:");
			char c = sc.next().charAt(0);
			boolean flag = false;
			boolean masterFlag = false;
			
			for (int i = 0; i < word.length; i++) {
				if (c == word[i]) {		
					mask[i] = c;
					flag = true;
				} 
				else if((i == word.length - 1) && !flag) {
					misses++;
					System.out.println("Tries left: " + (6 - misses));
					switch (misses) {
					case 1: showHead(grid); // 2 5
						break;
					case 2: showLeftArm(grid); // 3 4
						break;
					case 3: showRightArm(grid); // 3 6
						break;
					case 4: showTorso(grid); // 4 5
						break;
					case 5: showLeftLeg(grid); // 5 4
						break;
					case 6: showRightLeg(grid); // 5 6
						break;
					default:
						break;
					}
					if (misses >= 6) {
						System.out.println("GAME OVER");
						masterFlag = true;
						break;
					}
				}
			}
			if (masterFlag) {
				break;
			}
		}
		if (solved(mask)) {
			System.out.print("YOU WON! The word is ");
			printMask(mask);
		}
	}

	private static void showHead(char[][] grid) { // 2 5
		grid[2][5] = 'O';
		printGrid(grid);
	}
	
	private static void showLeftArm(char[][] grid) { // 3 4
		grid[3][4] = '\\';
		printGrid(grid);
	}
	
	private static void showRightArm(char[][] grid) { // 3 6
		grid[3][6] = '/';
		printGrid(grid);
	}
	
	private static void showTorso(char[][] grid) { // 4 5
		grid[4][5] = '|';
		printGrid(grid);
	}
	
	private static void showLeftLeg(char[][] grid) { // 5 4
		grid[5][4] = '/';
		printGrid(grid);
	}
	
	private static void showRightLeg(char[][] grid) { // 5 6
		grid[5][6] = '\\';
		printGrid(grid);
	}

	public static boolean solved(char[] mask) {
		for (int i = 0; i < mask.length; i++) {
			if (mask[i] == '_') {
				return false;
			}
		}
		return true;
	}
	
	public static void printMask(char[] mask) {
		for (int i = 0; i < mask.length; i++) {
			System.out.print(mask[i]);
		}
	}
	
	public static boolean hasDuplicates(char c, char[] mask) {
		for (int i = 0; i < mask.length; i++) {
			if (mask[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	private static void printGrid(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
