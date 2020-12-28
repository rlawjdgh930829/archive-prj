package com.spring.archive.repository;

import java.util.List;

import com.spring.archive.domain.CommentDTO;

public interface CommentDAO {

	Integer getMaxCommentNo();
	Integer insertComment(CommentDTO comment);
	List<CommentDTO> getCommentList(Integer no);
	Integer getCommentCount(Integer no);
	CommentDTO selectComment(Integer cno);
	Integer deleteComment(Integer cno);
	
}
