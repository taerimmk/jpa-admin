
package com.june.app.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.BoardMaster;
import com.june.app.repository.BoardMasterRepository;
import com.june.app.service.BoardMasterService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class BoardMasterServiceImpl extends CommonServiceImpl implements BoardMasterService {

	@Autowired
	private BoardMasterRepository boardMasterRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<BoardMaster> getBoardMasterList(BoardMaster boardMaster) throws DataAccessException {
		return boardMasterRepository.getBoardMasterList(boardMaster);
	}

	@Override
	@Transactional(readOnly = true)
	public int getBoardMasterListCnt(BoardMaster boardMaster) throws DataAccessException {
		return boardMasterRepository.getBoardMasterListCnt(boardMaster);
	}

	@Override
	@Transactional(readOnly = true)
	public BoardMaster getBoardMaster(BoardMaster boardMaster) throws DataAccessException {
		return boardMasterRepository.getBoardMaster(boardMaster);
	}

	@Override
	@Transactional
	public void putBoardMaster(BoardMaster boardMaster) throws DataAccessException {
		boardMasterRepository.putBoardMaster(boardMaster);

	}

	@Override
	@Transactional
	public void setBoardMaster(BoardMaster boardMaster) throws DataAccessException {
		boardMasterRepository.setBoardMaster(boardMaster);
	}

}
