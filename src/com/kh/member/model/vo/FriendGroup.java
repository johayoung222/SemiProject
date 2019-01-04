package com.kh.member.model.vo;

public class FriendGroup {
	private int groupNo;		//시퀀스 넘버링
	private String groupName;	//그룹이름
	
	public FriendGroup() {}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public FriendGroup(int groupNo, String groupName) {
		super();
		this.groupNo = groupNo;
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return groupNo + ", " + groupName;
	}
	
	
}
	

