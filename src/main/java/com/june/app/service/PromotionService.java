package com.june.app.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Promotion;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface PromotionService {

	Collection<Promotion> getPromotionList(Promotion promotion) throws DataAccessException;

	int getPromotionListCnt(Promotion promotion) throws DataAccessException;

	Promotion getPromotion(Promotion promotion) throws DataAccessException;

	void putPromotion(Promotion promotion) throws DataAccessException;

	void setPromotion(Promotion promotion) throws DataAccessException;

}
