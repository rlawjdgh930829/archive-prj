package com.spring.archive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.archive.DTO.Member;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/signupView", method = RequestMethod.GET)
	public String singupView() {
		return "index.jsp?page=body/signup";
	}
	
	@RequestMapping(value = "/singup", method = RequestMethod.POST)
	public String singup(Member member) {
		System.out.println(member.getMemeber_email());
		return "redirect:/";
	}
}
