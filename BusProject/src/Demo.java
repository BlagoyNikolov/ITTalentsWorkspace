import bus.Bus;
import user.User;

public class Demo {
	public static void main(String[] args) {
		Bus bus = new Bus();
		
		for(int i = 0; i < 60; i++) {
			User user = new User(bus);
			user.start();
//			User user1 = new User(bus);
//			user1.start();
//			User user2 = new User(bus);
//			user2.start();
//			User user3 = new User(bus);
//			user3.start();
//			User user4 = new User(bus);
//			user4.start();
//			User user5 = new User(bus);
//			user5.start();	
		}
	}
}
