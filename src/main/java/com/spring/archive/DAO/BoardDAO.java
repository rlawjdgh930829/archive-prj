package com.spring.archive.DAO;

import java.util.List;

import com.spring.archive.DTO.BoardDTO;

public interface BoardDAO {
	
	Integer getMaxBoardNo();
	Integer insertBoard(BoardDTO board);
	List<BoardDTO> getAllBoard();
	BoardDTO selectBoard(Integer no);
	void boardCntUp(Integer no);
	void boardDelete(Integer no);
	void boardUpdate(BoardDTO board);
	
}
