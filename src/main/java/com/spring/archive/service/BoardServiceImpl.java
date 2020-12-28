package com.spring.archive.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.archive.domain.BoardDTO;
import com.spring.archive.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public void boardWritingService(BoardDTO board) {
		Integer maxBoardNo = boardDao.getMaxBoardNo();
		if(maxBoardNo == null) maxBoardNo = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String getTime = format.format(time);
		board.setBoardNo(maxBoardNo+1);
		board.setBoardDate(getTime);
		board.setBoardViewCount(0);
		boardDao.insertBoard(board);
	}

	@Override
	public BoardDTO selectBoardService(Integer no) {
		return boardDao.selectBoard(no);
	}

	@Override
	public void boardViewCountUpService(Integer no, HttpServletRequest request, HttpServletResponse response) {
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

	@Override
	public void boardDeleteService(Integer no) {
		boardDao.boardDelete(no);
	}

	@Override
	public void boardUpdateService(BoardDTO board) {
		boardDao.boardUpdate(board);
	}

}
