package exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapExample {
	public static void main(String[] args) {
		Map<String, Double> studentGrades = new HashMap<String, Double>();
		studentGrades.put("Pesho", 3.00);
		studentGrades.put("Gosho", 4.50);
		studentGrades.put("Nakov", 5.00);
		studentGrades.put("Vesko", 3.50);
		studentGrades.put("Tsanev", 4.00);
		studentGrades.put("Nerdy", 6.00);
		
		System.out.println("Tsanev grade: " + studentGrades.get("Tsanev"));
		studentGrades.remove("Tsanev");
		System.out.println("Tsanev removed");
		System.out.println("Is tsanev in the map? " + studentGrades.containsKey("Tsanev"));
		studentGrades.put("Nerdy", 3.20);
		System.out.println("Nerdy grade changed");
		System.out.println("There are: " + studentGrades.size() + " students");
		printStudents(studentGrades);
	}

	private static void printStudents(Map<String, Double> studentGrades) {
		for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
			System.out.println(entry);
		}
	}
}
