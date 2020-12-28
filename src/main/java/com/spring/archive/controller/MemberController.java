package com.spring.archive.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.archive.domain.LoginUserDTO;
import com.spring.archive.domain.MemberDTO;
import com.spring.archive.repository.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String singupView(Model model) {
		model.addAttribute(new MemberDTO());
		return "index.jsp?page=body/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String singup(@Valid MemberDTO member, BindingResult bindingResult) {
		String returnValue = "";
		if(bindingResult.hasErrors()) {
			returnValue = "index.jsp?page=body/signup";
		} else {
			Integer memberMaxNo = memberDAO.getMemeberMaxNo();
			if(memberMaxNo == null) {
				memberMaxNo = 0;
			}
			member.setMemberNo(memberMaxNo + 1);
			memberDAO.insertMemeber(member);
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signinView(Model model) {
		model.addAttribute(new LoginUserDTO());
		return "index.jsp?page=body/signin";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(@Valid LoginUserDTO user, BindingResult bindingResult, HttpSession session) {
		String returnValue = "";
		if(bindingResult.hasErrors()) {
			returnValue = "index.jsp?page=body/signin";
		} else {
			MemberDTO selectMemberResult = memberDAO.selectMember(user);
			if(selectMemberResult == null) {
				returnValue = "redirect:/signin";
			} else {
				session.setAttribute("USER", selectMemberResult);
				returnValue = "redirect:/";
			}
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public Boolean idCheck(@RequestParam String userId) {
		boolean returnValue = false;
		Integer getIdCount = memberDAO.idCheck(userId);
		if(getIdCount == 1) {
			returnValue = true;
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/emailCheck", method = RequestMethod.GET)
	@ResponseBody
	public Boolean emailCheck(@RequestParam String emailId) {
		boolean returnValue = false;
		Integer getEmailCount = memberDAO.emailCheck(emailId);
		if(getEmailCount == 1) {
			returnValue = true;
		}
		return returnValue;
	}
}
