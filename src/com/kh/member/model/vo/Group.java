package com.kh.member.model.vo;

public class Group {
	private int group_no;		//시퀀스 넘버링
	private String group_name;	//그룹이름
	
	public Group() {}
	
	@Override
	public String toString() {
		return group_no + ", " + group_name;
	}
	public Group(int group_no, String group_name) {
		super();
		this.group_no = group_no;
		this.group_name = group_name;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
}
