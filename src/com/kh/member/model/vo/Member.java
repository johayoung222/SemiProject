package com.kh.member.model.vo;

public class Member {

	 private String memberid; //회원아이디
	 private String password; //패스원드
	 private String name;		//이름
	 private String gender;		//성별
	 private int age;			//나이
	 private String email;		//이메일
	 private int login_log;		//로그인 누적 카운트
	 private String status;		//회원상태
	 private String sns_account;//sns연동
	 
	 public Member() {}
	 
	@Override
	public String toString() {
		return memberid + ", " + password + ", " + name + ", " + gender
				+ ", " + age + ", " + email + ", " + login_log + ", " + status
				+ ", " + sns_account;
	}

	public Member(String memberid, String password, String name, String gender, int age, String email, int login_log,
			String status, String sns_account) {
		super();
		this.memberid = memberid;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.login_log = login_log;
		this.status = status;
		this.sns_account = sns_account;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLogin_log() {
		return login_log;
	}
	public void setLogin_log(int login_log) {
		this.login_log = login_log;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSns_account() {
		return sns_account;
	}
	public void setSns_account(String sns_account) {
		this.sns_account = sns_account;
	}
	 
}
