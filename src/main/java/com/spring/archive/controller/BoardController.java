package com.spring.archive.controller;

import java.util.List;

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
import com.spring.archive.repository.CommentDAO;
import com.spring.archive.service.BoardService;
import com.spring.archive.service.CategoryService;

@Controller
public class BoardController {
	
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private CommentDAO commentDao;
	
	@RequestMapping(value = "/writing", method = RequestMethod.GET)
	public String writingView(Model model) {
		List<CategoryDTO> categoryList = categoryService.getAllCategoryService();
		model.addAttribute("CATEGORY", categoryList);
		model.addAttribute(new BoardDTO());
		return "index.jsp?page=body/writing";
	}
	
	@RequestMapping(value = "/writing", method = RequestMethod.POST)
	public String writing(@Valid BoardDTO board, BindingResult bindingResult, Model model) {
		String returnValue = "";
		if(bindingResult.hasErrors()) {
			List<CategoryDTO> categoryList = categoryService.getAllCategoryService();
			model.addAttribute("CATEGORY", categoryList);
			returnValue = "index.jsp?page=body/writing";
		} else {
			boardService.boardWritingService(board);
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailView(@RequestParam Integer no, Model model, HttpServletRequest request, HttpServletResponse response) {
		boardService.boardViewCountUpService(no, request, response);
		BoardDTO boardDetail = boardService.selectBoardService(no);
		Integer commentCount = commentDao.getCommentCount(no);
		List<CommentDTO> getComment = commentDao.getCommentList(no);
		model.addAttribute("DETAIL", boardDetail);
		model.addAttribute(new CommentDTO());
		model.addAttribute("COMMENT", getComment);
		model.addAttribute("COUNT", commentCount);
		return "index.jsp?page=body/detail";
	}
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
	public String boardDelete(@RequestParam Integer no, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		BoardDTO boardDetail = boardService.selectBoardService(no);
		if(getUser.getMemberNo() != boardDetail.getMemberNo()) {
			returnValue = "redirect:/detail?no="+no;
		} else {
			boardService.boardDeleteService(no);
			returnValue = "redirect:/";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.GET)
	public String boardModifyView(@RequestParam Integer no, Model model, HttpSession session) {
		String returnValue = "";
		MemberDTO getUser = (MemberDTO)session.getAttribute("USER");
		BoardDTO boardDetail = boardService.selectBoardService(no);
		if(getUser.getMemberNo() != boardDetail.getMemberNo()) {
			returnValue = "redirect:/detail?no="+no;
		} else {
			List<CategoryDTO> categoryList = categoryService.getAllCategoryService();
			model.addAttribute("DETAIL", boardDetail);
			model.addAttribute("CATEGORY", categoryList);
			returnValue = "index.jsp?page=body/modify";
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.POST)
	public String boardModify(BoardDTO board) {
		boardService.boardUpdateService(board);
		return "redirect:/";
	}
	
}
