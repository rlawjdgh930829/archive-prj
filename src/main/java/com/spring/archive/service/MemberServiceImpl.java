package com.spring.archive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.archive.domain.LoginUserDTO;
import com.spring.archive.domain.MemberDTO;
import com.spring.archive.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void memberSingupService(MemberDTO member) {
		Integer memberMaxNo = memberDAO.getMemeberMaxNo();
		if(memberMaxNo == null) {
			memberMaxNo = 0;
		}
		member.setMemberNo(memberMaxNo + 1);
		memberDAO.insertMemeber(member);
	}

	@Override
	public MemberDTO selectMemberService(LoginUserDTO user) {
		return memberDAO.selectMember(user);
	}

	@Override
	public Integer idCheckService(String userId) {
		return memberDAO.idCheck(userId);
	}

	@Override
	public Integer emailCheckService(String emailId) {
		return memberDAO.emailCheck(emailId);
	}

	@Override
	public MemberDTO userCheckService(String userId) {
		return memberDAO.userCheck(userId);
	}

}
