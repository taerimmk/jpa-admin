
package com.june.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Main;
import com.june.app.repository.MainRepository;
import com.june.app.service.MainService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class MainServiceImpl extends CommonServiceImpl implements MainService {

	@Autowired
	private MainRepository mainRepository;

	@Override
	@Transactional(readOnly = true)
	public Main getMain(Main main) throws DataAccessException {
		return mainRepository.getMain(main);
	}

	@Override
	@Transactional
	public void putMain(Main main) throws DataAccessException {
		mainRepository.putMain(main);

	}
	

}
