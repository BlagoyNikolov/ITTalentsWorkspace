package hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
	private String name;
	private ArrayList<Room> rooms;
	
	public Department(String name) {
		this.name = name;
		this.rooms = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			rooms.add(new Room());
		}
	}
	
	public String getName() {
		return name;
	}
	
	public List<Room> getRooms() {
		return Collections.unmodifiableList(rooms);
	}
}
