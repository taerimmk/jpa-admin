
package com.june.app.repository;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Main;

/**
 * Repository class for <code>Main</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/
 * jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 */
public interface MainRepository {

	Main getMain(Main main) throws DataAccessException;

	void putMain(Main main) throws DataAccessException;

}
