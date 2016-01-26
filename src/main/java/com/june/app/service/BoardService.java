package com.june.app.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Board;
import com.june.app.model.BoardMaster;
import com.june.app.model.Imgs;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface BoardService {

	Collection<Board> getBoardList(Board board) throws DataAccessException;

	Collection<BoardMaster> getBoardMasterListAll(BoardMaster boardMaster) throws DataAccessException;

	int getBoardListCnt(Board board) throws DataAccessException;

	Board getBoard(Board board) throws DataAccessException;

	void putBoard(Board board) throws DataAccessException;

	void setBoard(Board board) throws DataAccessException;

	void putImgs(Imgs imgs) throws DataAccessException;

	void delBoard(Board board) throws DataAccessException;
}
