package lesson22;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapExamples {

	public static void main(String[] args) {
		
//		TreeMap<String, String> ocenki = new TreeMap<>();
//		ocenki.put("Pesho", "Sreden 3");
//		ocenki.put("Desi", "Mn dobur 5");
//		ocenki.put("Sasho", "Otlichen 6");
////		ocenki.put("Pesho", "Dobur 4");
//		System.out.println(ocenki.size());
//		System.out.println(ocenki.get("Pesho"));
		
//		System.out.println(ocenki.keySet());
//		System.out.println(ocenki.values());
//		System.out.println(ocenki.entrySet());
//		
		
		TreeMap<Frog, Puddle> map = new TreeMap<>();
		map.put(new Frog("Cani", 3), new Puddle("Kilifarski qzovir"));
		map.put(new Frog("Cani", 2), new Puddle("Qzovir Yovkovci"));
		map.put(new Frog("Cani", 4), new Puddle("Plachkovskiq qzovir"));
		map.put(new Frog("Bani", 1), new Puddle("Velchovskiq qzovir"));
		System.out.println(map);
		
		TreeSet<Frog> set = new TreeSet<>(new Comparator<Frog>() {
			@Override
			public int compare(Frog o1, Frog o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		set.add(new Frog("Fifi", 3));
		set.add(new Frog("Sisi", 2));
		set.add(new Frog("Bobi", 13));
		System.out.println(set);
		
		TreeSet<Frog> set2 = new TreeSet<>((f1, f2) -> {
			if(f1.getAge() == f2.getAge()){
				return f1.getName().compareTo(f2.getName());
			}
			return f1.getAge() - f2.getAge();
		});
		set2.add(new Frog("Fifi", 3));
		set2.add(new Frog("Sisi", 2));
		set2.add(new Frog("Bobi", 13));
		System.out.println(set2);
		

		TreeSet<Frog> set3 = new TreeSet<>((f1, f2) -> (int) (f1.getWeight() - f2.getWeight()));
	}
}
