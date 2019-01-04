package com.kh.member.model.vo;

import java.io.Serializable;

public class Member implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberId; //회원아이디
	 private String memberPwd; //패스원드
	 private String memberName;		//이름
	 private String memberGender;		//성별
	 private int memberAge;			//나이
	 private String memberEmail;		//이메일
	 private int memberLoginlog;		//로그인 누적 카운트
	 private String memberStatus;		//회원상태
	 private String memberSnsaccount;//sns연동
	 
	 @Override
	public String toString() {
		return memberId + ", " + memberPwd + ", " + memberName
				+ ", " + memberGender + ", " + memberAge + ", " + memberEmail
				+ ", " + memberLoginlog + ", " + memberStatus + ", "
				+ memberSnsaccount;
	}

	public Member(String memberId, String memberPwd, String memberName, String memberGender, int memberAge,
			String memberEmail, int memberLoginlog, String memberStatus, String memberSnsaccount) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberAge = memberAge;
		this.memberEmail = memberEmail;
		this.memberLoginlog = memberLoginlog;
		this.memberStatus = memberStatus;
		this.memberSnsaccount = memberSnsaccount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberLoginlog() {
		return memberLoginlog;
	}

	public void setMemberLoginlog(int memberLoginlog) {
		this.memberLoginlog = memberLoginlog;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getMemberSnsaccount() {
		return memberSnsaccount;
	}

	public void setMemberSnsaccount(String memberSnsaccount) {
		this.memberSnsaccount = memberSnsaccount;
	}

	public Member() {}
	 
}
