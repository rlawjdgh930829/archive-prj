package com.spring.archive.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.archive.domain.BoardDTO;

public interface BoardService {
	
	void boardWritingService(BoardDTO board);
	BoardDTO selectBoardService(Integer no);
	void boardViewCountUpService(Integer no, HttpServletRequest request, HttpServletResponse response);
	void boardDeleteService(Integer no);
	void boardUpdateService(BoardDTO board);
	
}
