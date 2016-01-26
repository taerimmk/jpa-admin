
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Menu;

/**
 * Repository class for <code>Menu</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/
 * jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 */
public interface MenuRepository {

	Collection<Menu> getMenuList(Menu menu) throws DataAccessException;

	Collection<Menu> getMenuListAll(Menu menu) throws DataAccessException;

	int getMenuListCnt(Menu menu) throws DataAccessException;

	Menu getMenu(Menu menu) throws DataAccessException;

	void putMenu(Menu menu) throws DataAccessException;

	void setMenu(Menu menu) throws DataAccessException;

}
