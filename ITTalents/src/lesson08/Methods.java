package lesson08;

public class Methods {

	public static void main(String[] args) {
	
		int a = 4;
		int b = 3;
		int sum = modifyNumbers(a, b);//a and b are arguments
		System.out.println(sum);
		int c = 1;
		sum = modifyNumbers(a, c);
		sum = modifyNumbers(b, c);
		int d = 33;
		sum = modifyNumbers(b, d);
		
	}
	
	static int modifyNumbers( int first, int second ){//first and second are parameters
		int sum = first * second;
		System.out.println("wut wut?");
		return sum;
	}
}
