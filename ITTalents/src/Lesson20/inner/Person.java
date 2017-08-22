package Lesson20.inner;

public class Person {
	
	private int age;

	//inner class - depends on the existance of an instance of the outer class
	//can have access to ALL variables of the outer class
	public class Brain{
		public Brain() {
			age++;
		}
		
		public void sleep(){
			Person.this.sleep();
		}
	}
	
	private void sleep(){
		System.out.println("ZzZzZzZ");
	}
}
