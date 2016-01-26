
package com.june.app.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Promotion;
import com.june.app.repository.PromotionRepository;
import com.june.app.service.PromotionService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class PromotionServiceImpl extends CommonServiceImpl implements PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Promotion> getPromotionList(Promotion promotion) throws DataAccessException {
		return promotionRepository.getPromotionList(promotion);
	}

	@Override
	@Transactional(readOnly = true)
	public int getPromotionListCnt(Promotion promotion) throws DataAccessException {
		return promotionRepository.getPromotionListCnt(promotion);
	}

	@Override
	@Transactional(readOnly = true)
	public Promotion getPromotion(Promotion promotion) throws DataAccessException {
		return promotionRepository.getPromotion(promotion);
	}

	@Override
	@Transactional
	public void putPromotion(Promotion promotion) throws DataAccessException {
		promotionRepository.putPromotion(promotion);

	}

	@Override
	@Transactional
	public void setPromotion(Promotion promotion) throws DataAccessException {
		promotionRepository.setPromotion(promotion);
	}

}
