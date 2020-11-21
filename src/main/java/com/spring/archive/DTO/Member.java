package com.spring.archive.DTO;

public class Member {
	
	private int member_no;
	private String member_id;
	private String member_pwd;
	private String memeber_email;
	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMemeber_email() {
		return memeber_email;
	}
	public void setMemeber_email(String memeber_email) {
		this.memeber_email = memeber_email;
	}

}
