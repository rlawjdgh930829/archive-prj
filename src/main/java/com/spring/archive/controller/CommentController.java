package com.spring.archive.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.archive.domain.CommentDTO;
import com.spring.archive.domain.MemberDTO;
import com.spring.archive.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/commentwriting", method = RequestMethod.POST)
	public String commentWriting(@Valid CommentDTO comment, BindingResult bindingResult, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		if(getUser == null) {
			returnValue = "redirect:/signin";
		} else if(bindingResult.hasErrors()) {
			returnValue = "redirect:/detail?no="+comment.getBoardNo();
		} else {
			commentService.commentWritingService(comment);
			returnValue = "redirect:/detail?no="+comment.getBoardNo();
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/commentDelete", method = RequestMethod.GET)
	public String commentDelete(@RequestParam Integer bno, @RequestParam Integer cno, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		CommentDTO commentDetail = commentService.selectCommentService(cno);
		if(getUser.getMemberNo() != commentDetail.getMemberNo()) {
			returnValue = "redirect:/detail?no="+bno;
		} else {
			commentService.deleteCommentService(cno);
			returnValue = "redirect:/detail?no="+bno;
		}
		return returnValue;
	}
	
}
