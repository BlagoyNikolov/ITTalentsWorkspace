package stuff;

public class Happy extends Thread {
	final StringBuffer sb1 = new StringBuffer();
	final StringBuffer sb2 = new StringBuffer();

	public static void main(String args[]) {
		final Happy h = new Happy();

		new Thread() {
			public void run() {
				synchronized (this) {
					h.sb1.append("A");
					h.sb2.append("B");
					System.out.println(h.sb1);
					System.out.println(h.sb2);
				}
			}
		}.start();

		new Thread() {
			public void run() {
				synchronized (this) {
					h.sb1.append("D");
					h.sb2.append("C");
					System.out.println(h.sb2);
					System.out.println(h.sb1);
				}
			}
		}.start();

		int i, j, k;
		for (i = 0; i < 3; i++) {
			for (j = 1; j < 4; j++) {
				for (k = 2; k < 5; k++) {
					if ((i == j) && (j == k))
						System.out.println(i);
				}
			}
		}
	}
}