package com.spring.archive.DTO;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberDTO {
	
	private int member_no;
	@NotEmpty(message = "아이디를 입력해주세요.")
	private String member_id;
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	private String member_pwd;
	@NotEmpty(message = "이메일을 입력해주세요.")
	private String member_email;
	
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
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

}
