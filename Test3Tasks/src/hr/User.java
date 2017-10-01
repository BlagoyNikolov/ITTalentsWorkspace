package hr;

public class User {
	private int userId;
	private String username;
	private int groupId;
	private String group;
	
	public User(String username, int groupId) {
		this.username = username;
		this.groupId = groupId;
	}
	
	public User(String username, String group) {
		this.username = username;
		this.group = group;
	}
	
	public User(int userId, String username, int groupId) {
		this.userId = userId;
		this.username = username;
		this.groupId = groupId;
	}

	public int getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public int getGroupId() {
		return groupId;
	}

	@Override
	public String toString() {
		return "User [userId = " + userId + ", username = " + username + ", groupId = " + groupId + "]\n";
	}
}
