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
import com.spring.archive.DTO.BoardDTO;
import com.spring.archive.DTO.CategoryDTO;
import com.spring.archive.VO.PagingVO;

@Controller
public class IndexController {
	
	@Autowired
	private BoardDAO boardDao;
	@Autowired
	private CategoryDAO categoryDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, PagingVO paging, @RequestParam(required=false)String nowPage, @RequestParam(required=false)Integer categoryNo) {
		Integer totalCountBoard = 0;
		List<BoardDTO> getPagingBoard;
		if(nowPage == null) {
			nowPage = "1";
		}
		if(categoryNo == null || categoryNo == 0) {
			totalCountBoard = boardDao.countBoard();
			paging = new PagingVO(totalCountBoard, Integer.parseInt(nowPage));
			getPagingBoard = boardDao.pagingBoard(paging);
		} else {
			totalCountBoard = boardDao.countCategoryBoard(categoryNo);
			paging = new PagingVO(totalCountBoard, Integer.parseInt(nowPage));
			paging.setCategoryNo(categoryNo);
			getPagingBoard = boardDao.pagingCategoryBoard(paging);
		}
		List<CategoryDTO> getAllCategory = categoryDao.getAllCategory();
		model.addAttribute("PAGE", paging);
		model.addAttribute("BOARD", getPagingBoard);
		model.addAttribute("CATEGORY", getAllCategory);
		return "index.jsp?page=body/home";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
