package cakes.bakery;

import java.util.Comparator;
import cakes.cake.Cake;

public class CakeComparatorByPieces implements Comparator<Cake> {
	@Override
	public int compare(Cake o1, Cake o2) {
		return o1.getPieces() - o2.getPieces();
	}
}
