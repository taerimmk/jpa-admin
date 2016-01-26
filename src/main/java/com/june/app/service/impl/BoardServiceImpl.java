
package com.june.app.service.impl;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Board;
import com.june.app.model.BoardMaster;
import com.june.app.model.Imgs;
import com.june.app.repository.BoardRepository;
import com.june.app.service.BoardService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class BoardServiceImpl extends CommonServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private FileMngUtil fileUtil;

	@Override
	@Transactional(readOnly = true)
	public Collection<Board> getBoardList(Board board) throws DataAccessException {
		return boardRepository.getBoardList(board);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BoardMaster> getBoardMasterListAll(BoardMaster boardMaster) throws DataAccessException {
		return boardRepository.getBoardMasterListAll(boardMaster);
	}

	@Override
	@Transactional(readOnly = true)
	public int getBoardListCnt(Board board) throws DataAccessException {
		return boardRepository.getBoardListCnt(board);
	}

	@Override
	@Transactional(readOnly = true)
	public Board getBoard(Board board) throws DataAccessException {
		return boardRepository.getBoard(board);
	}

	@Override
	@Transactional
	public void putBoard(Board board) throws DataAccessException {

		String fileuuid = UUID.randomUUID().toString().replace("-", "");
		board.setFileuuid(fileuuid);
		boardFile(board);
		boardRepository.putBoard(board);

	}

	public void boardFile(Board board) {
		if (board.getFile() != null) {
			if (!board.getFile().isEmpty()) {
				try {
					String image = fileUtil.parseFileInfCompany(board.getFile(), "board_", 0, "board");
					logger.debug("===========] call image [============={}", image);
					board.setImage(image);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
	}

	@Override
	@Transactional
	public void setBoard(Board board) throws DataAccessException {

		boardFile(board);
		boardRepository.setBoard(board);
	}

	@Override
	@Transactional
	public void putImgs(Imgs imgs) throws DataAccessException {
		boardRepository.putImgs(imgs);
	}

	@Override
	@Transactional
	public void delBoard(Board board) throws DataAccessException {
		boardRepository.delBoard(board);
	}

}
