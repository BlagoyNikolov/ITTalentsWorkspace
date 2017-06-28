package lesson11;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {1,3,6,7,8,11,31,44,67,88};
		int x = 45;
		int result= binarySearch(arr, x, 0, arr.length-1);
		System.out.println(result);
	}

	//1: find mid element
	//2: check if mid element is equal to x - if true, return mid index
	//3: if false: check if mid element is greater than x
	//3.1 if greater - search in left half
	//3.2 if lesser - search in right half
	static int binarySearch(int[] masiv, int x, int left, int right){
		if(left >= right){
			return -1;
		}
		int mid = (left + right) / 2;
		if(masiv[mid] == x){
			return mid;
		}
		else
		if(masiv[mid] > x){
			return binarySearch(masiv, x, left, mid-1);
		}
		else{
			return binarySearch(masiv, x, mid+1, right);
		}
	}
}
