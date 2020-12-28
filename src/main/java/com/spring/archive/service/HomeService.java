package com.spring.archive.service;

import java.util.List;

import com.spring.archive.domain.BoardDTO;
import com.spring.archive.domain.PagingVO;

public interface HomeService {

	Integer countBoardService(String search);
	Integer countCategoryBoardService(Integer categoryNo, String search);
	PagingVO createPageService(Integer totalCountBoard, String nowPage, String search);
	List<BoardDTO> pagingBoardService(PagingVO paging);
	List<BoardDTO> pagingCategoryBoard(PagingVO paging);
	
}
