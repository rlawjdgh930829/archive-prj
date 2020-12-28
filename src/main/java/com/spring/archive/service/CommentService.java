package com.spring.archive.service;

import java.util.List;

import com.spring.archive.domain.CommentDTO;

public interface CommentService {

	void commentWritingService(CommentDTO comment);
	CommentDTO selectCommentService(Integer cno);
	void deleteCommentService(Integer cno);
	Integer getCommentCountService(Integer no);
	List<CommentDTO> getCommentListService(Integer no);
	
}
