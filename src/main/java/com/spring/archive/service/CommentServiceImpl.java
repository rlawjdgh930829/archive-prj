package com.spring.archive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.archive.domain.CommentDTO;
import com.spring.archive.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public void commentWritingService(CommentDTO comment) {
		Integer maxCommentNo = commentDao.getMaxCommentNo();
		if(maxCommentNo == null) maxCommentNo = 0;
		comment.setCommentNo(maxCommentNo+1);
		commentDao.insertComment(comment);
	}

	@Override
	public CommentDTO selectCommentService(Integer cno) {
		return commentDao.selectComment(cno);
	}

	@Override
	public void deleteCommentService(Integer cno) {
		commentDao.deleteComment(cno);
	}

}
