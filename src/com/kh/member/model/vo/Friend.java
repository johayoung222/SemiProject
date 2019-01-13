package com.kh.member.model.vo;

import java.io.Serializable;

public class Friend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	private String friendId;
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friend(String memberId, String friendId) {
		super();
		this.memberId = memberId;
		this.friendId = friendId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Friend [memberId=" + memberId + ", friendId=" + friendId + "]";
	}
	
	
}

