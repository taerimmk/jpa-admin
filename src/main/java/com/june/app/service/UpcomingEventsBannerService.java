package com.june.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.UpcomingEventsBanner;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface UpcomingEventsBannerService {

	Collection<UpcomingEventsBanner> getUpcomingEventsBannerList(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	int getUpcomingEventsBannerListCnt(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	UpcomingEventsBanner getUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	void putUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	void setUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	void putImgs(List<Imgs> imgs) throws DataAccessException;

}