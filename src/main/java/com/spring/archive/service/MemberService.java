package com.spring.archive.service;

import com.spring.archive.domain.LoginUserDTO;
import com.spring.archive.domain.MemberDTO;

public interface MemberService {
	
	void memberSingupService(MemberDTO member);
	MemberDTO selectMemberService(LoginUserDTO user);
	Integer idCheckService(String userId);
	Integer emailCheckService(String emailId);
	MemberDTO userCheckService(String userId);

}
