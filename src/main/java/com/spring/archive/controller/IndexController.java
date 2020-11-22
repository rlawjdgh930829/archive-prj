package com.spring.archive.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.archive.DAO.BoardDAO;
import com.spring.archive.DAO.MemberDAO;
import com.spring.archive.DTO.BoardDTO;
import com.spring.archive.DTO.MemberDTO;

@Controller
public class IndexController {
	
	@Autowired
	private MemberDAO dao;
	@Autowired
	private BoardDAO bDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<BoardDTO> getAllBoard = bDao.getAllBoard();
		model.addAttribute("BOARD", getAllBoard);
		return "index.jsp?page=body/home";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signinView() {
		return "index.jsp?page=body/signin";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(MemberDTO member, HttpSession session) {
		MemberDTO selectMemberResult = dao.selectMember(member);
		String returnValue;
		if(selectMemberResult == null) {
			returnValue = "redirect:/signin";
		} else {
			session.setAttribute("USER", selectMemberResult);
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
