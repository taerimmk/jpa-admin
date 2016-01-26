package com.june.app.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Menu;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface MenuService {

	Collection<Menu> getMenuList(Menu menu) throws DataAccessException;

	Collection<Menu> getMenuListAll(Menu menu) throws DataAccessException;

	int getMenuListCnt(Menu menu) throws DataAccessException;

	Menu getMenu(Menu menu) throws DataAccessException;

	void putMenu(Menu menu) throws DataAccessException;

	void setMenu(Menu menu) throws DataAccessException;

}
