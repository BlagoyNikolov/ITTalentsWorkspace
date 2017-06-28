package lesson08;

import java.util.Arrays;

public class ReplacingStrings {

	public static void main(String[] args) {
		
		String text = "My cow is a good cow. The cow gives milk dayly.";
		System.out.println(Arrays.toString(text.split(" ")));
		System.out.println(text.split(" ").length);
		text = text.replace("cow", "sheep");
		text = text.replace("day ", "month ");
		System.out.println(text);
		
		String licencePlateRegEx = "[A-Z]{1,2}[0-9]{4}[A-Z]{1,2}";
		String sample = "CA3125AB";
		System.out.println(sample.matches(licencePlateRegEx));
	
		String txt = "Masa";
		txt.toUpperCase();
	
	}
}
