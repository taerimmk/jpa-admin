package com.june.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.HotCouponsBanner;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface HotCouponsBannerService {

	Collection<HotCouponsBanner> getHotCouponsBannerList(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	int getHotCouponsBannerListCnt(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	HotCouponsBanner getHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	void putHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	void setHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	void putImgs(List<Imgs> imgs) throws DataAccessException;

}