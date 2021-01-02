package com.spring.archive.repository;

import com.spring.archive.domain.LoginUserDTO;
import com.spring.archive.domain.MemberDTO;

public interface MemberDAO {
	
	Integer getMemeberMaxNo();
	Integer insertMemeber(MemberDTO member);
	MemberDTO selectMember(LoginUserDTO user);
	Integer idCheck(String userId);
	Integer emailCheck(String emailId);
	MemberDTO userCheck(String userId);
	
}
