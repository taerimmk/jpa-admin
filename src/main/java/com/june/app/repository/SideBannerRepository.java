
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.SideBanner;

public interface SideBannerRepository {

	Collection<SideBanner> getSideBannerList(SideBanner sideBanner) throws DataAccessException;

	int getSideBannerListCnt(SideBanner sideBanner) throws DataAccessException;

	SideBanner getSideBanner(SideBanner sideBanner) throws DataAccessException;

	void putSideBanner(SideBanner sideBanner) throws DataAccessException;

	void setSideBanner(SideBanner sideBanner) throws DataAccessException;
	
	void putImgs(Imgs imgs) throws DataAccessException;
	

}