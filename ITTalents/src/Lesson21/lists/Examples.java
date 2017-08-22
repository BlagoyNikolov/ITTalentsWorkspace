package Lesson21.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Examples{

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("d");
		System.out.println(list);
		list.add(0, "f");
		System.out.println(list);
		list.remove("c");
		System.out.println(list);
		
		LinkedList<String> linked = new LinkedList<String>();
		linked.add("a");
		linked.add("b");
		linked.add("c");
		linked.add("d");
		System.out.println(linked);
		linked.add(0, "f");
		System.out.println(linked);
		
		Stack<String> s = new Stack<>();
		
		LinkedList<String> x = new LinkedList<>();
	}
	
}
