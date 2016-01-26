
package com.june.app.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Menu;
import com.june.app.repository.MenuRepository;
import com.june.app.service.MenuService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class MenuServiceImpl extends CommonServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Menu> getMenuList(Menu menu) throws DataAccessException {
		return menuRepository.getMenuList(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Menu> getMenuListAll(Menu menu) throws DataAccessException {
		return menuRepository.getMenuListAll(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public int getMenuListCnt(Menu menu) throws DataAccessException {
		return menuRepository.getMenuListCnt(menu);
	}

	@Override
	@Transactional(readOnly = true)
	public Menu getMenu(Menu menu) throws DataAccessException {
		return menuRepository.getMenu(menu);
	}

	@Override
	@Transactional
	public void putMenu(Menu menu) throws DataAccessException {
		logger.debug("]-------------]menuPut before[-------------[ {}", menu);
		menuRepository.putMenu(menu);
		logger.debug("]-------------]menuPut after [-------------[ {}", menu);

	}

	@Override
	@Transactional
	public void setMenu(Menu menu) throws DataAccessException {
		menuRepository.setMenu(menu);
	}

}
