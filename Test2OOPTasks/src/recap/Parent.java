package recap;

import java.util.ArrayList;
import java.util.ListIterator;

public class Parent implements IRecap, IRecap2{
	public final int x;
	
	public Parent() {
		this.x = 5;
	}
	
	static class Brain {
		int capacity;
		
		public Brain(int capacity) {
			this.capacity = capacity;
		}
	}
	
	public void list() {
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		ListIterator<Integer> iterator = integers.listIterator();
		
		final int temp = 6;
		
//		while (iterator.hasNext()) {
//			if (iterator.next().equals(2)) {
//				iterator.remove();
//				integers.add(88);
//			}
//		}
		System.out.println(integers.toString());
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	public void Speak(String word) {
		System.out.println(word);
	}
	
}
