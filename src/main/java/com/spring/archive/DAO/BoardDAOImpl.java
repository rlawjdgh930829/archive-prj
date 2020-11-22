package com.spring.archive.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public Integer getMaxBoardNo() {
		return session.selectOne("board.getMaxBoardNo");
	}

}
