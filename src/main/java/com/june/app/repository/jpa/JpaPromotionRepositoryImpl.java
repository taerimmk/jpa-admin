package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Promotion;
import com.june.app.repository.PromotionRepository;

/**
 * JPA implementation of the {@link PromotionRepository} interface.
 *
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaPromotionRepositoryImpl implements PromotionRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Promotion> getPromotionList(Promotion promotion) {
		String searchKey = promotion.getSearchKey();
		String searchVal = promotion.getSearchVal();
		String queryFrom = "SELECT DISTINCT promotion FROM Promotion promotion ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE promotion.title like '%" + searchVal + "%' ";
			}
		}
		String queryOrder = " ORDER BY promotion.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = promotion.getPageSize();
		int pageNumber = promotion.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getPromotionListCnt(Promotion promotion) {
		String searchKey = promotion.getSearchKey();
		String searchVal = promotion.getSearchVal();
		String queryFrom = "SELECT count(promotion) FROM Promotion promotion ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE promotion.menu like '%" + searchVal + "%'";
			}
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public Promotion getPromotion(Promotion promotion) {
		Query query = this.em.createQuery(
				"SELECT promotion FROM Promotion promotion left join fetch promotion.promotionLocales WHERE promotion.id =:id");
		query.setParameter("id", promotion.getId());
		return (Promotion) query.getSingleResult();
	}

	@Override
	public void putPromotion(Promotion promotion) {
		this.em.persist(promotion);

	}

	@Override
	public void setPromotion(Promotion promotion) {
		this.em.merge(promotion);
	}

}
