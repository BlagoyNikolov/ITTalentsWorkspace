package recap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Demo {
	public static void main(String[] args) {
		TreeMap<String, Integer> family = new TreeMap<>((o1, o2) -> o1.length() - o2.length());
		family.put("Ivan", 40);
		family.put("Minka", 38);
		family.put("Mimi", 10);
		family.put("NIkol", 8);
		System.out.println(family);
		
		for (Iterator iterator = family.entrySet().iterator(); iterator.hasNext();) {
			//iterator.remove();
			iterator.next();
			iterator.remove();
			
		}
		
		Parent.Brain b = new Parent.Brain(5);
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.remove((Integer)2);
		System.out.println(arr);
		
		Parent p = new Parent();
		p.list();
		
		//doSomething();
		arrList();
		int x = 1;
		Double y = new Double(1.0);
		System.out.println(y.equals(x));
		integer();
		
		int a = 5;
		byte c = 7;
		short z = 8;
		z = c;
		c = (byte)a;
		System.out.println(c);
		
		Singleton s = Singleton.getInstance();
		String str = new String("STR");
		str.intern();
		
		int w = 5;
		System.out.println(x++ - --x);
		
		Piqnica pesho = new Piqnica();
		Piqnica.RuskaPiqnica russian = pesho.new RuskaPiqnica();
		russian.piq();
	}
	
	public static void doSth() {
		final class SectetClass {
			abstract class MoreSecretClass {
				class TheSecretestClassOfThemAll {
					public void doSomethingElse() {
						System.out.println("Are we there yet");
					}
				}
			}
		}
	}
	
	public static void arrList() {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(3.14);
		list.add("Bazinka");
		list.add(new ArrayList<Object>());
		System.out.println(list.contains(1));
		
		System.out.println(list.size());
	}
	
	public static void integer() {
		Integer i = new Integer(5);
		i = 5;
		Object object = new Object();
		object = null;
		System.out.println(i.equals(object));
	}
	
	public static void strings() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Mow you see me");
		list.add("..now you don't");
		
		for (String string : list) {
			if (string.equals("..now you don't")) {
				list.remove(string);
			}
		}
		
		System.out.println(list.toString());
	}
	
}
