package lesson22;

import java.util.Comparator;

public class MyFrogComparatorByName implements Comparator<Frog>{

	@Override
	public int compare(Frog f1, Frog f2) {
		return f1.getName().compareTo(f2.getName());
	}

}
