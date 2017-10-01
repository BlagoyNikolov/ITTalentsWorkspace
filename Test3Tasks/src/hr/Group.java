package hr;

public class Group {
	private int groupId;
	private String groupName;
	
	public Group(String groupName) {
		this.groupName = groupName;
	}
	
	public Group(int groupId, String groupName) {
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	@Override
	public String toString() {
		return "Group [groupId = " + groupId + ", groupName = " + groupName + "]\n";
	}
}
