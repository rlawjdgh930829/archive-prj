package com.spring.archive.DAO;

import java.util.List;

import com.spring.archive.DTO.CommentDTO;

public interface CommentDAO {

	Integer getMaxCommentNo();
	Integer insertComment(CommentDTO comment);
	List<CommentDTO> getCommentList(Integer no);
	Integer getCommentCount(Integer no);
	
}
