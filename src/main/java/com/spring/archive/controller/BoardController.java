package com.spring.archive.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return "index.jsp?page=body/writing";
	}
	
	@RequestMapping(value = "/writing", method = RequestMethod.POST)
	public String writing(BoardDTO board) {
		Integer maxBoardNo = boardDao.getMaxBoardNo();
		if(maxBoardNo == null) maxBoardNo = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String getTime = format.format(time);
		
		board.setBoard_no(maxBoardNo+1);
		board.setBoard_date(getTime);
		return "redirect:/";
	}
	
}
