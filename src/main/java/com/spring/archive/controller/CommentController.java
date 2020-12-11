package com.spring.archive.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.archive.DAO.CommentDAO;
import com.spring.archive.DTO.BoardDTO;
import com.spring.archive.DTO.CommentDTO;
import com.spring.archive.DTO.MemberDTO;

@Controller
public class CommentController {
	
	@Autowired
	private CommentDAO commentDao;
	
	@RequestMapping(value = "/commentwriting", method = RequestMethod.POST)
	public String commentWriting(@Valid CommentDTO comment, BindingResult bindingResult, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		if(getUser == null) {
			returnValue = "redirect:/signin";
		} else if(bindingResult.hasErrors()) {
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
	
	@RequestMapping(value = "/commentDelete", method = RequestMethod.GET)
	public String commentDelete(@RequestParam Integer bno, @RequestParam Integer cno, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		CommentDTO commentDetail = commentDao.selectComment(cno);
		if(getUser.getMemberNo() != commentDetail.getMemberNo()) {
			returnValue = "redirect:/detail?no="+bno;
		} else {
			commentDao.deleteComment(cno);
			returnValue = "redirect:/detail?no="+bno;
		}
		return returnValue;
	}
	
}
