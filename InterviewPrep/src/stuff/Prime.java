package stuff;

import java.util.Arrays;

public class Prime {
	public static void main(String[] args) {
		/*int x = 40;
		x= ++x + ++x;
		x = x++ + x++;
		x = x-- - x--;
		x = x-- - --x;

		System.out.println(x);*/
		
		/*int x = 10;
		int y = 10;

		for (int i = 0; i < 5; i++) {
			if (++x > 2 || ++y > 2) {
				x++;				
			}
		}
		
		System.out.println("x = " + x + " y=" + y);*/
		
		/*outerloop:
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i);
				if(i == 5){
					break outerloop;
				}
			}
		}*/
	
		/*String str = new String("Welcome");
		str = str.substring(2, 4);
		System.out.println(str);*/
		
		/*StringBuilder sb = new StringBuilder("Hello there");
		sb.insert(3, "Z");
		System.out.println(sb);*/
		
		String input = "Hello";
		System.out.println(reverseStringRec(input, 0, ""));
		
		Integer x = 5;
		Integer y = 6;
		swap(x, y);
		System.out.println(x + " " + y);
		
		int[] arr = { 3, 4, 5 };
		modify(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void modify(int[] arr) {
		arr[1] = 8;
	}

	private static String reverseStringRec(String input, int index, String output) {
		if (index == input.length()) {
			return output;
		}
		output += input.charAt(input.length() - 1 - index);
		return reverseStringRec(input, index + 1, output);
	}
	
	private static void swap(Integer arg1, Integer arg2) {
		Integer temp = arg1;
	    arg1 = arg2;
	    arg2 = temp;
	}
	
	static final void m1(){}
	
	synchronized public final void m2() {}
	
	private native void m3();
}
