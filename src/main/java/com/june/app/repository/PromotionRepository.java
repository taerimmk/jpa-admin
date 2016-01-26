
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Promotion;

/**
 * Repository class for <code>Promotion</code> domain objects All method names
 * are compliant with Spring Data naming conventions so this interface can
 * easily be extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/
 * jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 */
public interface PromotionRepository {

	Collection<Promotion> getPromotionList(Promotion promotion) throws DataAccessException;

	int getPromotionListCnt(Promotion promotion) throws DataAccessException;

	Promotion getPromotion(Promotion promotion) throws DataAccessException;

	void putPromotion(Promotion promotion) throws DataAccessException;

	void setPromotion(Promotion promotion) throws DataAccessException;

}
