package lesson11;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {9,7,1,4,8,3,2,5};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int[] masiv, int left, int right){
		if(left >= right){
			return;
		}
		int pivoIdx = partition(masiv, left, right);
		quickSort(masiv, left, pivoIdx-1);
		quickSort(masiv, pivoIdx+1, right);
	}
	 
	static int partition(int[] masiv, int left, int right){
		//1: choose pivot
		int pivot = masiv[right];
		int idx = left;
		//2: traverse all elements and compare with pivot
		for (int i = left; i < right; i++) {
			//3: if lesser than pivot - move to the beginning 
			if(masiv[i] < pivot){
				swap(masiv, i, idx++);
			}
		}
		//4: at last - move pivot after all lesser values
		swap(masiv, right, idx);
		return idx;
	}
	
	static void swap(int[] arr, int idx1, int idx2){
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
