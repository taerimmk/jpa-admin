package com.june.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.MainBanner;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface MainBannerService {

	Collection<MainBanner> getMainBannerList(MainBanner mainBanner) throws DataAccessException;

	int getMainBannerListCnt(MainBanner mainBanner) throws DataAccessException;

	MainBanner getMainBanner(MainBanner mainBanner) throws DataAccessException;

	void putMainBanner(MainBanner mainBanner) throws DataAccessException;

	void setMainBanner(MainBanner mainBanner) throws DataAccessException;

	void putImgs(List<Imgs> imgs) throws DataAccessException;

}