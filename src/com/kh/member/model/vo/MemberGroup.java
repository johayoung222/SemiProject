package com.kh.member.model.vo;

import java.io.Serializable;

public class MemberGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int groupNo;	//시퀀스 넘버링
	private String memberId;//회원 아이디
	
	public MemberGroup() {}
	
	@Override
	public String toString() {
		return groupNo + ", " + memberId;
	}

	public MemberGroup(int groupNo, String memberId) {
		super();
		this.groupNo = groupNo;
		this.memberId = memberId;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
	
}
