package lesson22.zoo;

import java.util.Comparator;
import java.util.TreeSet;

public class Zoo {
	private TreeSet<Bear> bears;
	
	public Zoo() {
		Bear b1 = new Bear("Bear 1", 5, 12);
		Bear b2 = new Bear("Bear 2", 7, 28);
		Bear b3 = new Bear("Bear 3", 7, 21);
		Bear b4 = new Bear("Bear 4", 7, 27);
		Bear b5 = new Bear("Bear 5", 8, 29);
		
		Comparator<Bear> comparator = new Comparator<Bear>() {
			@Override
			public int compare(Bear o1, Bear o2) {
				if (o1.getAge() == o2.getAge()) {
					return o1.getFurLength() - o2.getFurLength();
				}
				return o1.getAge() - o2.getAge();
			}
		};
		this.bears = new TreeSet<>(comparator);
		bears.add(b1);
		bears.add(b2);
		bears.add(b3);
		bears.add(b4);
		bears.add(b5);
		System.out.println(bears);
	}
}
