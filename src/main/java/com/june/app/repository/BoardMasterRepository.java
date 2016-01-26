
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.BoardMaster;

/**
 * Repository class for <code>BoardMaster</code> domain objects All method names
 * are compliant with Spring Data naming conventions so this interface can
 * easily be extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/
 * jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 */
public interface BoardMasterRepository {

	Collection<BoardMaster> getBoardMasterList(BoardMaster boardMaster) throws DataAccessException;

	int getBoardMasterListCnt(BoardMaster boardMaster) throws DataAccessException;

	BoardMaster getBoardMaster(BoardMaster boardMaster) throws DataAccessException;

	void putBoardMaster(BoardMaster boardMaster) throws DataAccessException;

	void setBoardMaster(BoardMaster boardMaster) throws DataAccessException;

}
