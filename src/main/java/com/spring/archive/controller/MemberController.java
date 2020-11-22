package com.spring.archive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.archive.DAO.MemberDAO;
import com.spring.archive.DTO.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String singupView() {
		return "index.jsp?page=body/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String singup(MemberDTO member) {
		Integer memberMaxNo = dao.getMemeberMaxNo();
		if(memberMaxNo == null) {
			memberMaxNo = 0;
		}
		member.setMember_no(memberMaxNo + 1);
		dao.insertMemeber(member);
		return "redirect:/";
	}
}
