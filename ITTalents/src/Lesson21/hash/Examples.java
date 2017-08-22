package Lesson21.hash;

import java.util.HashSet;
import java.util.TreeSet;

public class Examples {

	public static void main(String[] args) {
		
		Mouse misi = new Mouse("Mara", 4);
		Mouse sisi = new Mouse("Zara", 3);
		Mouse zisi = new Mouse("Mara", 2);
		Mouse fisi = new Mouse("Zara", 8);
		System.out.println(misi.hashCode()%16);
		System.out.println(sisi.hashCode()%16);
		HashSet<Mouse> set = new HashSet<>();
		set.add(misi);
		set.add(sisi);
		set.add(zisi);
		System.out.println(set);
		set.remove(new Mouse("", 245));
		System.out.println(set);
	}
}
