package com.june.app.service;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Main;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface MainService {

	Main getMain(Main main) throws DataAccessException;

	void putMain(Main main) throws DataAccessException;


}
