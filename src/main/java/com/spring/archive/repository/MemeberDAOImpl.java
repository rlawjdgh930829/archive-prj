package com.spring.archive.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.archive.domain.LoginUserDTO;
import com.spring.archive.domain.MemberDTO;

@Repository
public class MemeberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public Integer getMemeberMaxNo() {
		return session.selectOne("member.getMemberMaxNo");
	}

	@Override
	public Integer insertMemeber(MemberDTO member) {
		return session.insert("member.insertMember", member);
	}

	@Override
	public MemberDTO selectMember(LoginUserDTO user) {
		return session.selectOne("member.selectMember", user);
	}

	@Override
	public Integer idCheck(String userId) {
		return session.selectOne("member.idCheck", userId);
	}

	@Override
	public Integer emailCheck(String emailId) {
		return session.selectOne("member.emailCheck", emailId);
	}

	@Override
	public MemberDTO userCheck(String userId) {
		return session.selectOne("member.userCheck", userId);
	}

}
