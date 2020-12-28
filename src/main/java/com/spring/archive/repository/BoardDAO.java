package com.spring.archive.repository;

import java.util.List;

import com.spring.archive.domain.BoardDTO;
import com.spring.archive.domain.PagingVO;

public interface BoardDAO {
	
	Integer getMaxBoardNo();
	Integer insertBoard(BoardDTO board);
	List<BoardDTO> getAllBoard();
	BoardDTO selectBoard(Integer no);
	void boardViewCountUp(Integer no);
	void boardDelete(Integer no);
	void boardUpdate(BoardDTO board);
	Integer countBoard(String search);
	List<BoardDTO> pagingBoard(PagingVO paging);
	Integer countCategoryBoard(Integer categoryNo, String search);
	List<BoardDTO> pagingCategoryBoard(PagingVO paging);
	
}
