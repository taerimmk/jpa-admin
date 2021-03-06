
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Theme;

/**
 * Repository class for <code>Theme</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/
 * jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 */
public interface ThemeRepository {

	Collection<Theme> getThemeList(Theme theme) throws DataAccessException;

	Collection<Theme> getThemeListAll(Theme theme) throws DataAccessException;

	int getThemeListCnt(Theme theme) throws DataAccessException;

	Theme getTheme(Theme theme) throws DataAccessException;

	void putTheme(Theme theme) throws DataAccessException;

	void setTheme(Theme theme) throws DataAccessException;

}
