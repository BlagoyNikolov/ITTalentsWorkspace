package lesson08;

import java.util.Random;

public class Tasks {

	public static void main(String[] args) {
		
		for (;;) {
			printArr(generateArr(1500));
		}
		
	}
	
	static int[] generateArr(int n){
		int[] masivche = new int[n];
		Random r = new Random();
		for (int i = 0; i < masivche.length; i++) {
			masivche[i] = r.nextInt(10);
		}
		return masivche;
	}
	
	static void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
