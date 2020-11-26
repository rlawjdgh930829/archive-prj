package com.spring.archive.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.archive.DAO.BoardDAO;
import com.spring.archive.DAO.CategoryDAO;
import com.spring.archive.DTO.BoardDTO;
import com.spring.archive.DTO.CategoryDTO;

@Controller
public class BoardController {
	
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private BoardDAO boardDao;
	
	@RequestMapping(value = "/writing", method = RequestMethod.GET)
	public String writingView(Model model) {
		List<CategoryDTO> categoryList = categoryDao.getAllCategory();
		model.addAttribute("CATEGORY", categoryList);
		model.addAttribute(new BoardDTO());
		return "index.jsp?page=body/writing";
	}
	
	@RequestMapping(value = "/writing", method = RequestMethod.POST)
	public String writing(@Valid BoardDTO board, BindingResult bindingResult, Model model) {
		String returnValue = "";
		if(bindingResult.hasErrors()) {
			List<CategoryDTO> categoryList = categoryDao.getAllCategory();
			model.addAttribute("CATEGORY", categoryList);
			returnValue = "index.jsp?page=body/writing";
		} else {
			Integer maxBoardNo = boardDao.getMaxBoardNo();
			if(maxBoardNo == null) maxBoardNo = 0;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			String getTime = format.format(time);
			board.setBoard_no(maxBoardNo+1);
			board.setBoard_date(getTime);
			board.setBoard_cnt(0);
			boardDao.insertBoard(board);
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailView(@RequestParam Integer no, Model model, HttpServletRequest request, HttpServletResponse response) {
		boardCnt(no, request, response);
		BoardDTO boardDetail = boardDao.selectBoard(no);
		model.addAttribute("DETAIL", boardDetail);
		return "index.jsp?page=body/detail";
	}
	
	void boardCnt(Integer no, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		int flag = 0;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("visit")) {
				flag = 1;
				if(!cookie.getValue().contains(no+"")) {
					cookie.setValue(cookie.getValue()+"_"+no);
					response.addCookie(cookie);
					boardDao.boardCntUp(no);
				}
			}
		}
		if(flag == 0) {
			Cookie newCookie = new Cookie("visit", no+"");
			response.addCookie(newCookie);
			boardDao.boardCntUp(no);
		}
	}
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
	public String boardDelete(@RequestParam Integer no) {
		boardDao.boardDelete(no);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.GET)
	public String boardModifyView(@RequestParam Integer no, Model model) {
		BoardDTO boardDetail = boardDao.selectBoard(no);
		List<CategoryDTO> categoryList = categoryDao.getAllCategory();
		model.addAttribute("DETAIL", boardDetail);
		model.addAttribute("CATEGORY", categoryList);
		return "index.jsp?page=body/modify";
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.POST)
	public String boardModify(BoardDTO board) {
		boardDao.boardUpdate(board);
		return "redirect:/";
	}
	
}
