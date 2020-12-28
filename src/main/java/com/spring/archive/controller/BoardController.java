package com.spring.archive.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.archive.domain.BoardDTO;
import com.spring.archive.domain.CategoryDTO;
import com.spring.archive.domain.CommentDTO;
import com.spring.archive.domain.MemberDTO;
import com.spring.archive.repository.BoardDAO;
import com.spring.archive.repository.CategoryDAO;
import com.spring.archive.repository.CommentDAO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardDao;
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private CommentDAO commentDao;
	
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
			board.setBoardNo(maxBoardNo+1);
			board.setBoardDate(getTime);
			board.setBoardViewCount(0);
			boardDao.insertBoard(board);
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailView(@RequestParam Integer no, Model model, HttpServletRequest request, HttpServletResponse response) {
		boardCnt(no, request, response);
		BoardDTO boardDetail = boardDao.selectBoard(no);
		Integer commentCount = commentDao.getCommentCount(no);
		List<CommentDTO> getComment = commentDao.getCommentList(no);
		model.addAttribute("DETAIL", boardDetail);
		model.addAttribute(new CommentDTO());
		model.addAttribute("COMMENT", getComment);
		model.addAttribute("COUNT", commentCount);
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
					boardDao.boardViewCountUp(no);
				}
			}
		}
		if(flag == 0) {
			Cookie newCookie = new Cookie("visit", no+"");
			response.addCookie(newCookie);
			boardDao.boardViewCountUp(no);
		}
	}
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
	public String boardDelete(@RequestParam Integer no, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		BoardDTO boardDetail = boardDao.selectBoard(no);
		if(getUser.getMemberNo() != boardDetail.getMemberNo()) {
			returnValue = "redirect:/detail?no="+no;
		} else {
			boardDao.boardDelete(no);
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.GET)
	public String boardModifyView(@RequestParam Integer no, Model model, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		BoardDTO boardDetail = boardDao.selectBoard(no);
		if(getUser.getMemberNo() != boardDetail.getMemberNo()) {
			returnValue = "redirect:/detail?no="+no;
		} else {
			List<CategoryDTO> categoryList = categoryDao.getAllCategory();
			model.addAttribute("DETAIL", boardDetail);
			model.addAttribute("CATEGORY", categoryList);
			returnValue = "index.jsp?page=body/modify";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.POST)
	public String boardModify(BoardDTO board) {
		boardDao.boardUpdate(board);
		return "redirect:/";
	}
	
}
