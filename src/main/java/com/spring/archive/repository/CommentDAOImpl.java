package com.spring.archive.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.archive.domain.CommentDTO;

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

	@Override
	public CommentDTO selectComment(Integer cno) {
		return session.selectOne("comment.selectComment", cno);
	}

	@Override
	public Integer deleteComment(Integer cno) {
		return session.delete("comment.deleteComment", cno);
	}

}
