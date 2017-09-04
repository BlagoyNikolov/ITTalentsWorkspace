package recap;

public abstract interface IRecap {
	public default void f() {
		System.out.println("Default method");
	}
	
	public void print();
}
