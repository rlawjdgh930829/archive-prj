package com.spring.archive.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.archive.DTO.CommentDTO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public Integer getMaxCommentNo() {
		return session.selectOne("comment.getMaxCommentNo");
	}

	@Override
	public Integer insertComment(CommentDTO comment) {
		return session.insert("comment.insertComment", comment);
	}

	@Override
	public List<CommentDTO> getCommentList(Integer no) {
		return session.selectList("comment.getCommentList", no);
	}

	@Override
	public Integer getCommentCount(Integer no) {
		return session.selectOne("comment.getCommentCount", no);
	}

}
