package Lesson20.magarii;

public class Universe {

	String x = "Universe";
	Earth e;
	public Universe() {
		e = new Earth();
	}
	
	void print(String x){
		e.print(x);
	}
	
	public static void main(String[] args) {
		new Universe().print("something");
	}
	
	class Earth extends Planet{
		String x = "Earth";
		Person p;
		public Earth() {
			p = new Person();
		}

		void print(String x){
			p.print(x);
		}
		
		class Person extends Creature{
			String x = "Person";
		
			void print(String x){
				System.out.println(x);
				System.out.println(this.x);
				System.out.println(super.x);
				System.out.println(Earth.this.x);
				System.out.println(Earth.super.x);
				System.out.println(Universe.this.x);
			}
		}
	}
}
