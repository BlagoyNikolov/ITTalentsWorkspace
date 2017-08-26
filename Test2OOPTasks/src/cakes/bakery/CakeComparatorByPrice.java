package cakes.bakery;

import java.util.Comparator;
import cakes.cake.Cake;

public class CakeComparatorByPrice implements Comparator<Cake> {
	@Override
	public int compare(Cake o1, Cake o2) {
		return Double.compare(o2.getPrice(), o1.getPrice());
	}
}
