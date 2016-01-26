
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.UpcomingEventsBanner;

public interface UpcomingEventsBannerRepository {

	Collection<UpcomingEventsBanner> getUpcomingEventsBannerList(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	int getUpcomingEventsBannerListCnt(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	UpcomingEventsBanner getUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	void putUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;

	void setUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException;
	
	void putImgs(Imgs imgs) throws DataAccessException;
	

}