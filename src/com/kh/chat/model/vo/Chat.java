package com.kh.chat.model.vo;

import java.io.Serializable;

public class Chat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int chatNo;
	private String fromId; // 보낸사람
	private String toId; // 받는사람
	private String chatContent;
	private String chatTime;
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chat(int chatNo, String fromId, String toId, String chatContent, String chatTime) {
		super();
		this.chatNo = chatNo;
		this.fromId = fromId;
		this.toId = toId;
		this.chatContent = chatContent;
		this.chatTime = chatTime;
	}
	public int getChatNo() {
		return chatNo;
	}
	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public String getChatTime() {
		return chatTime;
	}
	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Chat [chatNo=" + chatNo + ", fromId=" + fromId + ", toId=" + toId + ", chatContent=" + chatContent
				+ ", chatTime=" + chatTime + "]";
	}
	
	
}
