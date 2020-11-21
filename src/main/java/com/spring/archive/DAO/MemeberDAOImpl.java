package com.spring.archive.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemeberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public Integer getMemeberMaxNo() {
		return session.selectOne("member.getMemberMaxNo");
	}

}
