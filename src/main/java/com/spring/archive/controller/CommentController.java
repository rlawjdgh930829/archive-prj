package com.spring.archive.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.archive.DAO.CommentDAO;
import com.spring.archive.DTO.CommentDTO;

@Controller
public class CommentController {
	
	@Autowired
	private CommentDAO commentDao;
	
	@RequestMapping(value = "/commentwriting", method = RequestMethod.POST)
	public String commentWriting(@Valid CommentDTO comment, BindingResult bindingResult) {
		String returnValue = "";
		if(bindingResult.hasErrors()) {
			returnValue = "redirect:/detail?no="+comment.getBoardNo();
		} else {
			Integer maxCommentNo = commentDao.getMaxCommentNo();
			if(maxCommentNo == null) maxCommentNo = 0;
			comment.setCommentNo(maxCommentNo+1);
			commentDao.insertComment(comment);
			returnValue = "redirect:/detail?no="+comment.getBoardNo();
		}
		return returnValue;
	}
	
}
