package lesson22.scheduler;

import java.util.HashSet;

public class Examples {

	public static void main(String[] args) {
		
		HashSet<Mouse> mishki = new HashSet<>();
		Mouse sisi = new Mouse("Sisi", 3);
		Mouse misi = new Mouse("Sisi", 4);
		mishki.add(sisi);
		mishki.add(misi);
		System.out.println(mishki);
		
	}
}
