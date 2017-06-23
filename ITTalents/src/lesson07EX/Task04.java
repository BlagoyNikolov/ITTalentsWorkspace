package lesson07EX;


public class Task04 {
	public static void main(String[] args) {
		int[] binaryArray = { 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 };
		
		int zerosCount = 0;
		for (int i = 0; i < binaryArray.length; i++) {
			if (binaryArray[i] == 0) {
				zerosCount++;
			}
		}
		
		for (int i = zerosCount; i < binaryArray.length; i++) {
			if (i < zerosCount) {
				binaryArray[i] = 0;
			} else {
				binaryArray[i] = 1;
			}
		}

//		for (int i = 0; i < binaryArray.length; i++) {
//			for (int j = 0; j < binaryArray.length - 1 - i; j++) {
//				if (binaryArray[j] > binaryArray[j + 1]) {
//					int temp = binaryArray[j];
//					binaryArray[j] = binaryArray[j + 1];
//					binaryArray[j + 1] = temp;
//				}
//			}
//		}
		
		for (int i = 0; i < binaryArray.length; i++) {
			System.out.print(binaryArray[i] + " ");
		}
	}
}
