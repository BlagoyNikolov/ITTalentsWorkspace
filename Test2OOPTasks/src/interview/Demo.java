package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import interview.Printx.Inner;

abstract class Demo {
	public static void main(String[] args) {
		Printx p = new Printx(0, null);
		Printx.Inner in = p.new Inner();
		//in.print();
		ArrayList ar = new ArrayList<>();
		
		System.gc();
		
		double x = 10;
		++x;

		System.out.println(x);
		
		String str = new String("Welcome");
		str = str.substring(2, 4);
		System.out.println(str);


		Stack s = new Stack<>();
		Queue q = new LinkedList<>();

		Integer i = 5;
		i++;
		System.out.println(i);
		
		System.out.println(7^1);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("Abc", null);
		System.out.println(map);
		map.put(null, "ajs");
		System.out.println(map);
		
		Underwear underwear = new Underwear();
		Underwear.Victoria superModel = underwear.new Victoria();
		
		Integer integer = new Integer(5);
		integer = 5;

		Object object = new Object();
		object = null;

		System.out.println(integer.equals(object));

//		ArrayList<String> strings = new ArrayList<>();
//		strings.add("Now you see me");
//		strings.add("... now you don't");
//
//		for (String string : strings) {
//			if (string.equals("... now you don't")) {
//				strings.remove(string);
//			}
//		}
//		System.out.println(strings.toString());
		
		Iterator<String> iterator = null;
		ArrayList<String> strings = new ArrayList();
		strings.add("Is this the real life");
		strings.add("is this just fantasy?");
		iterator = strings.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
		System.out.println(strings);
		
//		System.out.println("enter number");
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		for (int w = 1; w <= n; w++) {
//			for (int j = 1; j <= n - w; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 2; k <= 2 * w; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
		doSomething();
		int[] arr = {4,8,9,3,8,4,5,31,65,7,9,5,46,8,1};
		bubble(arr);
		System.out.println(Arrays.toString(arr));
		
		new Anon() {
			@Override
			public void sayHi() {
				System.out.println("Hey");
				super.sayHi();
			}
		}.sayHi();
		
		Integer a = 5;
		a++;
		System.out.println(a);
	}
	
	public static void bubble(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j]  = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	

	public static void doSomething() {
		
		final class SecretClass {
			abstract class MoreSecretClass {
				class TheSecretestOfThemAll {
					public void doSomethingElse() {
						System.out.println("Are we there yet?");
					}
				}
			}
		}
		//SecretClass.MoreSecretClass.TheSecretestOfThemAll sad = new SecretClass().new MoreSecretClass().new TheSecretestOfThemAll();
		//sad.doSomethingElse();
	}

}
