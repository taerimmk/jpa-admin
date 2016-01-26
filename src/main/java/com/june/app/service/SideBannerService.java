package com.june.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.SideBanner;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface SideBannerService {

	Collection<SideBanner> getSideBannerList(SideBanner sideBanner) throws DataAccessException;

	int getSideBannerListCnt(SideBanner sideBanner) throws DataAccessException;

	SideBanner getSideBanner(SideBanner sideBanner) throws DataAccessException;

	void putSideBanner(SideBanner sideBanner) throws DataAccessException;

	void setSideBanner(SideBanner sideBanner) throws DataAccessException;

	void putImgs(List<Imgs> imgs) throws DataAccessException;

}