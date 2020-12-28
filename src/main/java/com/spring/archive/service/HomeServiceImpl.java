package com.spring.archive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.archive.domain.BoardDTO;
import com.spring.archive.domain.PagingVO;
import com.spring.archive.repository.BoardDAO;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public Integer countBoardService(String search) {
		return boardDao.countBoard(search);
	}
	
	@Override
	public Integer countCategoryBoardService(Integer categoryNo, String search) {
		return boardDao.countCategoryBoard(categoryNo, search);
	}

	@Override
	public PagingVO createPageService(Integer totalCountBoard, String nowPage, String search) {
		return new PagingVO(totalCountBoard, Integer.parseInt(nowPage), search);
	}

	@Override
	public List<BoardDTO> pagingBoardService(PagingVO paging) {
		return boardDao.pagingBoard(paging);
	}

	@Override
	public List<BoardDTO> pagingCategoryBoard(PagingVO paging) {
		return boardDao.pagingCategoryBoard(paging);
	}

}
