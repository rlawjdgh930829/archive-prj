package com.spring.archive.DAO;

import java.util.List;

import com.spring.archive.DTO.BoardDTO;
import com.spring.archive.VO.PagingVO;

public interface BoardDAO {
	
	Integer getMaxBoardNo();
	Integer insertBoard(BoardDTO board);
	List<BoardDTO> getAllBoard();
	BoardDTO selectBoard(Integer no);
	void boardCntUp(Integer no);
	void boardDelete(Integer no);
	void boardUpdate(BoardDTO board);
	Integer countBoard();
	List<BoardDTO> pagingBoard(PagingVO paging);
	
}
