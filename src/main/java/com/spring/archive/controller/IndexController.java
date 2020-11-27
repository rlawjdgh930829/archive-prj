package com.spring.archive.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.archive.DAO.BoardDAO;
import com.spring.archive.DAO.CategoryDAO;
import com.spring.archive.DAO.MemberDAO;
import com.spring.archive.DTO.BoardDTO;
import com.spring.archive.DTO.CategoryDTO;
import com.spring.archive.DTO.MemberDTO;
import com.spring.archive.VO.PagingVO;

@Controller
public class IndexController {
	
	@Autowired
	private MemberDAO dao;
	@Autowired
	private BoardDAO bDao;
	@Autowired
	private CategoryDAO cDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, PagingVO paging, @RequestParam(required=false)String nowPage, @RequestParam(required=false)Integer categoryNo) {
		Integer total = 0;
		List<BoardDTO> getPagingBoard = null;
		if(nowPage == null) {
			nowPage = "1";
		}
		if(categoryNo == null || categoryNo == 0) {
			total = bDao.countBoard();
			paging = new PagingVO(total, Integer.parseInt(nowPage));
			getPagingBoard = bDao.pagingBoard(paging);
		} else {
			total = bDao.countCategoryBoard(categoryNo);
			paging = new PagingVO(total, Integer.parseInt(nowPage));
			paging.setCategoryNo(categoryNo);
			getPagingBoard = bDao.pagingCategoryBoard(paging);
		}
		List<CategoryDTO> getAllCategory = cDao.getAllCategory();
		model.addAttribute("PAGE", paging);
		model.addAttribute("BOARD", getPagingBoard);
		model.addAttribute("CATEGORY", getAllCategory);
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
