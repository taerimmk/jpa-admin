
package com.june.app.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Theme;
import com.june.app.repository.ThemeRepository;
import com.june.app.service.ThemeService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ThemeServiceImpl extends CommonServiceImpl implements ThemeService {

	@Autowired
	private ThemeRepository themeRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Theme> getThemeList(Theme theme) throws DataAccessException {
		return themeRepository.getThemeList(theme);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Theme> getThemeListAll(Theme theme) throws DataAccessException {
		return themeRepository.getThemeListAll(theme);
	}

	@Override
	@Transactional(readOnly = true)
	public int getThemeListCnt(Theme theme) throws DataAccessException {
		return themeRepository.getThemeListCnt(theme);
	}

	@Override
	@Transactional(readOnly = true)
	public Theme getTheme(Theme theme) throws DataAccessException {
		return themeRepository.getTheme(theme);
	}

	@Override
	@Transactional
	public void putTheme(Theme theme) throws DataAccessException {
		logger.debug("]-------------]themePut before[-------------[ {}", theme);
		themeRepository.putTheme(theme);
		logger.debug("]-------------]themePut after [-------------[ {}", theme);

	}

	@Override
	@Transactional
	public void setTheme(Theme theme) throws DataAccessException {
		themeRepository.setTheme(theme);
	}

}
