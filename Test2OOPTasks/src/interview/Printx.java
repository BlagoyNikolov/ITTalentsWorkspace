package interview;

public class Printx implements Interfaceable {
	private int x=5; 
	
	public Printx(int x, String z) {
		// TODO Auto-generated constructor stub
	}
	
	void print() {
		final int x = 5;
		System.out.println(x);
	} 
	
	
	protected  class Inner {
		private int inner = 7;
		
		 void print() {
			System.out.println(x);
		}
	}

	@Override
	public void sayHi() {
		// TODO Auto-generated method stub
		
	}
	
	
}