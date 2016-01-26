package com.june.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.FooterBanner;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface FooterBannerService {

	Collection<FooterBanner> getFooterBannerList(FooterBanner footerBanner) throws DataAccessException;

	int getFooterBannerListCnt(FooterBanner footerBanner) throws DataAccessException;

	FooterBanner getFooterBanner(FooterBanner footerBanner) throws DataAccessException;

	void putFooterBanner(FooterBanner footerBanner) throws DataAccessException;

	void setFooterBanner(FooterBanner footerBanner) throws DataAccessException;

	void putImgs(List<Imgs> imgs) throws DataAccessException;

}