package com.june.app.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.BoardMaster;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface BoardMasterService {

	Collection<BoardMaster> getBoardMasterList(BoardMaster boardMaster) throws DataAccessException;

	int getBoardMasterListCnt(BoardMaster boardMaster) throws DataAccessException;

	BoardMaster getBoardMaster(BoardMaster boardMaster) throws DataAccessException;

	void putBoardMaster(BoardMaster boardMaster) throws DataAccessException;

	void setBoardMaster(BoardMaster boardMaster) throws DataAccessException;

}
