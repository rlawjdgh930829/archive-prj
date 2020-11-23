package com.spring.archive.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.archive.DTO.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public Integer getMaxBoardNo() {
		return session.selectOne("board.getMaxBoardNo");
	}

	@Override
	public Integer insertBoard(BoardDTO board) {
		return session.insert("board.insertBoard", board);
	}

	@Override
	public List<BoardDTO> getAllBoard() {
		return session.selectList("board.getAllBoard");
	}

	@Override
	public BoardDTO selectBoard(Integer no) {
		return session.selectOne("board.selectBoard", no);
	}

	@Override
	public void boardCntUp(Integer no) {
		session.update("board.boardCntUp", no);
	}

	@Override
	public void boardDelete(Integer no) {
		session.delete("board.boardDelete", no);
	}

	@Override
	public void boardUpdate(BoardDTO board) {
		session.update("board.boardUpdate", board);
	}

}
