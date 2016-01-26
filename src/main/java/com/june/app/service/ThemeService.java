package com.june.app.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Theme;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface ThemeService {

	Collection<Theme> getThemeList(Theme theme) throws DataAccessException;

	Collection<Theme> getThemeListAll(Theme theme) throws DataAccessException;

	int getThemeListCnt(Theme theme) throws DataAccessException;

	Theme getTheme(Theme theme) throws DataAccessException;

	void putTheme(Theme theme) throws DataAccessException;

	void setTheme(Theme theme) throws DataAccessException;

}
