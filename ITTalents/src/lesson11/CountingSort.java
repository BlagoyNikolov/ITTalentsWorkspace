package lesson11;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		
		int[] array = {1,-5,3,6,4,8,1,5,3,6,2,7,4,2,3};
		countingSort(array);
		System.out.println(Arrays.toString(array));
		
	}
	
	static void countingSort(int[] masiv){
		//1:find max and min
		int max = masiv[0];
		int min = masiv[0];
		for (int i = 0; i < masiv.length; i++) {
			if(max < masiv[i]){
				max = masiv[i];
			}
			if(min > masiv[i]){
				min = masiv[i];
			}
		}
		//2:create helper array of max-min+1 cells
		int[] helper = new int[max - min + 1];
		//3:iterate over original and fill counters
		for (int i = 0; i < masiv.length; i++) {
			helper[masiv[i]-min]++;
		}
		System.out.println(Arrays.toString(helper));
		//4:iterate over helper and replace cells of original with counted values from the current counter
		int originalIndex = 0;
		for (int i = 0; i < helper.length; i++) {
			while(helper[i]-- > 0){
				masiv[originalIndex++] = i+min;
			}
		}
	}
}
