package com.spring.archive.DAO;

import com.spring.archive.DTO.LoginUserDTO;
import com.spring.archive.DTO.MemberDTO;

public interface MemberDAO {
	
	Integer getMemeberMaxNo();
	Integer insertMemeber(MemberDTO member);
	MemberDTO selectMember(LoginUserDTO user);
	Integer idCheck(String userId);
	
}
