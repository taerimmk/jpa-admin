
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Board;
import com.june.app.model.BoardMaster;
import com.june.app.model.Imgs;

/**
 * Repository class for <code>Board</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/
 * jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 */
public interface BoardRepository {

	Collection<Board> getBoardList(Board board) throws DataAccessException;

	Collection<BoardMaster> getBoardMasterListAll(BoardMaster boardMaster) throws DataAccessException;

	int getBoardListCnt(Board board) throws DataAccessException;

	Board getBoard(Board board) throws DataAccessException;

	void putBoard(Board board) throws DataAccessException;

	void setBoard(Board board) throws DataAccessException;

	void putImgs(Imgs imgs) throws DataAccessException;

	void delBoard(Board board) throws DataAccessException;

}
