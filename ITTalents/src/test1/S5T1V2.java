package test1;

import java.util.Random;

public class S5T1V2 {
	public static void main(String[] args) {
		// int[] arr = { -12, -9, -5, -2, -1, 3, 4, 5 };
		// int[] arr = { -6, -4, -2, -1, 5, 6, 7, 8, 9, 10 };
		// int[] arr = { -10, -9, 7, 8, 10, 12, 15, 20, 30 };
		int[] arr = { -9, -7, -5, -4, 2, 5, 6, 8 };
		// dice();
		System.out.println(binarySearch(arr, 0, arr.length - 1));
		ratio("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaaaaaaaaaaaaa");
		char[][] matr = { { ' ', '*', ' ', ' ', ' ' }, { ' ', '*', ' ', ' ', ' ' }, { ' ', ' ', ' ', '*', ' ' },
				{ '*', ' ', '*', ' ', ' ' } };

		fillMinesweeper(matr);
		print(matr);
	}

	static void dice() {
		int counter = 0;
		int tries = 1;
		while (true) {
			Random r = new Random();
			tries++;
			int first = r.nextInt(6) + 1;
			int second = r.nextInt(6) + 1;
			System.out.println(first + "|" + second);
			if (first + second == 7) {
				counter++;
				if (counter == 7) {
					System.out.println(tries);
					break;
				}
			} else {
				counter = 0;
			}
		}
	}

	static void ratio(String text) {
		int lowerCount = 0;
		int upperCount = 0;
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLowerCase(text.charAt(i))) {
				lowerCount++;
			}
			if (Character.isUpperCase(text.charAt(i))) {
				upperCount++;
			}
		}
		if (upperCount > lowerCount) {
			System.out.println((double) upperCount / lowerCount + ":" + (double) lowerCount / lowerCount);
		}
		if (upperCount < lowerCount) {
			System.out.println((double) upperCount / upperCount + ":" + (double) lowerCount / upperCount);
		}
		if (upperCount == lowerCount) {
			System.out.println("1:1");
		}
	}

	static int binarySearch(int[] masiv, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;

		if (masiv[mid] < 0) {
			if (masiv[mid + 1] > 0) {
				return (mid + 1);
			} else {
				return binarySearch(masiv, mid + 1, right);
			}
		} else {
			if (masiv[mid - 1] < 0) {
				return (mid - 1);
			} else {
				return binarySearch(masiv, left, mid - 1);
			}
		}
	}

	static void fillMinesweeper(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == '*') {
					fillAroundBomb(arr, i, j);
				}
			}
		}
	}
	
	static void fillAroundBomb(char[][] matr, int x, int y) {
		for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(x + i < 0 || x + i == matr.length || y + j < 0 || y + i == matr[0].length){
                    continue;
                } else if(matr[x+i][y+j] == '*'){
                    continue;
                } else if(matr[x+i][y+j] == ' '){
                    matr[x+i][y+j] = '1';
                } else{
                    matr[x+i][y+j] += 1;
                }
            }
		}
	}

	static void print(char[][] matr) {
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr.length; j++) {
				System.out.print(matr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
