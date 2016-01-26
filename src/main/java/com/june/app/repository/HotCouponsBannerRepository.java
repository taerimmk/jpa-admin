
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Imgs;
import com.june.app.model.HotCouponsBanner;

public interface HotCouponsBannerRepository {

	Collection<HotCouponsBanner> getHotCouponsBannerList(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	int getHotCouponsBannerListCnt(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	HotCouponsBanner getHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	void putHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException;

	void setHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException;
	
	void putImgs(Imgs imgs) throws DataAccessException;
	

}