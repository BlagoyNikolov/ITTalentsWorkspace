package lesson08;

import java.util.Arrays;

public class Swap {

	public static void main(String[] args) {
		int a = 5;
		int b = 8;
		int[] array = { 4, 7, 6, 8 };
		String animal = "krava";
		
		swap(a, b);
		changeCell(array);
		change(animal);

		System.out.println(Arrays.toString(array));
	}
	
	public static void change(String a) {
		a = a.toUpperCase();
	}
	
	public static void changeCell(int[] masiv) {
		masiv[1] = 56;
	}
	
	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
}
