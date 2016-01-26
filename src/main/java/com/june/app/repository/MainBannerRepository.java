
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.MainBanner;

public interface MainBannerRepository {

	Collection<MainBanner> getMainBannerList(MainBanner mainBanner) throws DataAccessException;

	int getMainBannerListCnt(MainBanner mainBanner) throws DataAccessException;

	MainBanner getMainBanner(MainBanner mainBanner) throws DataAccessException;

	void putMainBanner(MainBanner mainBanner) throws DataAccessException;

	void setMainBanner(MainBanner mainBanner) throws DataAccessException;
	
	void putImgs(Imgs imgs) throws DataAccessException;
	

}