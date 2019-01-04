package com.kh.member.model.vo;

public class MemberGroup {
	private int group_no;	//시퀀스 넘버링
	private String memberid;//회원 아이디
	
	public MemberGroup() {}
	
	@Override
	public String toString() {
		return group_no + ", " + memberid;
	}

	public MemberGroup(int group_no, String memberid) {
		super();
		this.group_no = group_no;
		this.memberid = memberid;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	
	
	
}
