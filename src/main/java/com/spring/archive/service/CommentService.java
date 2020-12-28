package com.spring.archive.service;

import com.spring.archive.domain.CommentDTO;

public interface CommentService {

	void commentWritingService(CommentDTO comment);
	CommentDTO selectCommentService(Integer cno);
	void deleteCommentService(Integer cno);
	
}
