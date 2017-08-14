package krasi;

public class OverloadDemo {
	public static void main(String[] args) {
		Child child = new Child();
		child.x();
	}

	/**
	 * the Java language forbids a class to declare multiple methods with the
	 * same signature but different return types, the Java virtual machine does
	 * not
	 */
	// Object x() {
	// return "abc";
	// }
	//
	// String x() {
	// return "123";
	// }
}
