package lesson18.lists;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		//String[] list = new String[10];
		ArrayList<String> list = new ArrayList();
		
		list.add("Pesho");
		list.add("Gosho");
		System.out.println(list.size());
		list.add("Pesho");
		list.add("Gosho");
	}
}
