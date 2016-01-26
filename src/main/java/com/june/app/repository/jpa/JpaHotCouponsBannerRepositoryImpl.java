
package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Imgs;
import com.june.app.model.HotCouponsBanner;
import com.june.app.repository.HotCouponsBannerRepository;

/**
 * JPA implementation of the {@link HotCouponsBannerRepository} interface.
 *
 * @author Mike Keith
 * @since 22.4.2006
 */
@Repository
public class JpaHotCouponsBannerRepositoryImpl implements HotCouponsBannerRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<HotCouponsBanner> getHotCouponsBannerList(HotCouponsBanner hotCouponsBanner) {
		String searchKey = hotCouponsBanner.getSearchKey();
		String searchVal = hotCouponsBanner.getSearchVal();
		String queryFrom = "SELECT DISTINCT hotCouponsBanner FROM HotCouponsBanner hotCouponsBanner ";
		//String queryWhere = " WHERE hotCouponsBanner.parent_id = '0' ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += "  WHERE hotCouponsBanner.bannername like '%" + searchVal + "%' ";
			}
		}
		
		
		/*int userId = hotCouponsBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND hotCouponsBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = hotCouponsBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND hotCouponsBanner.use_at = '" + useAt + "' ";
		}*/
		String queryOrder = " ORDER BY hotCouponsBanner.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = hotCouponsBanner.getPageSize();
		int pageNumber = hotCouponsBanner.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getHotCouponsBannerListCnt(HotCouponsBanner hotCouponsBanner) {
		String searchKey = hotCouponsBanner.getSearchKey();
		String searchVal = hotCouponsBanner.getSearchVal();
		String queryFrom = "SELECT count(hotCouponsBanner) FROM HotCouponsBanner hotCouponsBanner ";
		String queryWhere = "";
		//String queryWhere = " WHERE hotCouponsBanner.parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE hotCouponsBanner.bannername like '%" + searchVal + "%'";
			}
		}
		/*int userId = hotCouponsBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND hotCouponsBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = hotCouponsBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND hotCouponsBanner.use_at = '" + useAt + "' ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
		
	}

	@Override
	public HotCouponsBanner getHotCouponsBanner(HotCouponsBanner hotCouponsBanner) {
		String queryFrom = "SELECT hotCouponsBanner FROM HotCouponsBanner hotCouponsBanner";
		String queryWhere = " WHERE hotCouponsBanner.id = " + hotCouponsBanner.getId() + " ";

		/*int userId = hotCouponsBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND hotCouponsBanner.user_id = " + userId + " ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		/*
		 * Query query = this.em.createQuery(
		 * "SELECT hotCouponsBanner FROM HotCouponsBanner hotCouponsBanner left join fetch hotCouponsBanner.hotCouponsBannerLocales WHERE hotCouponsBanner.id =:id"
		 * ); query.setParameter("id", hotCouponsBanner.getId());
		 */
		return (HotCouponsBanner) query.getSingleResult();
	}

	@Override
	public void putHotCouponsBanner(HotCouponsBanner hotCouponsBanner) {
		this.em.persist(hotCouponsBanner);

	}

	@Override
	public void setHotCouponsBanner(HotCouponsBanner hotCouponsBanner) {
		this.em.merge(hotCouponsBanner);
	}

	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

}