
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.FooterBanner;

public interface FooterBannerRepository {

	Collection<FooterBanner> getFooterBannerList(FooterBanner footerBanner) throws DataAccessException;

	int getFooterBannerListCnt(FooterBanner footerBanner) throws DataAccessException;

	FooterBanner getFooterBanner(FooterBanner footerBanner) throws DataAccessException;

	void putFooterBanner(FooterBanner footerBanner) throws DataAccessException;

	void setFooterBanner(FooterBanner footerBanner) throws DataAccessException;
	
	void putImgs(Imgs imgs) throws DataAccessException;
	

}