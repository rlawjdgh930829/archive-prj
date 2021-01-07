package com.spring.archive.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.archive.domain.BoardDTO;
import com.spring.archive.domain.CategoryDTO;
import com.spring.archive.domain.PagingVO;
import com.spring.archive.service.CategoryService;
import com.spring.archive.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, PagingVO paging, @RequestParam(required=false)String nowPage, 
			@RequestParam(required=false)Integer categoryNo, @RequestParam(required=false)String search) {
		Integer totalCountBoard = 0;
		List<BoardDTO> getPagingBoard;
		if(nowPage == null || Integer.parseInt(nowPage) < 0) nowPage = "1";
		if(search == null) search = "";
		if(categoryNo == null || categoryNo == 0 || categoryNo < 0 || categoryService.getMaxCategoryNo() < categoryNo) {
			totalCountBoard = homeService.countBoardService(search);
			paging = homeService.createPageService(totalCountBoard, nowPage, search);
			getPagingBoard = homeService.pagingBoardService(paging);
		} else {
			totalCountBoard = homeService.countCategoryBoardService(categoryNo, search);
			paging = homeService.createPageService(totalCountBoard, nowPage, search);
			paging.setCategoryNo(categoryNo);
			getPagingBoard = homeService.pagingCategoryBoard(paging);
		}
		List<CategoryDTO> getAllCategory = categoryService.getAllCategoryService();
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
