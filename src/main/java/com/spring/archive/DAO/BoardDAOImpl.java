package com.spring.archive.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.archive.DTO.BoardDTO;
import com.spring.archive.VO.PagingVO;

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

	@Override
	public Integer countBoard() {
		return session.selectOne("board.countBoard");
	}

	@Override
	public List<BoardDTO> pagingBoard(PagingVO paging) {
		return session.selectList("board.pagingBoard", paging);
	}

	@Override
	public Integer countCategoryBoard(Integer categoryNo) {
		return session.selectOne("board.countCategoryBoard", categoryNo);
	}

	@Override
	public List<BoardDTO> pagingCategoryBoard(PagingVO paging) {
		return session.selectList("board.pagingCategoryBoard", paging);
	}

}
