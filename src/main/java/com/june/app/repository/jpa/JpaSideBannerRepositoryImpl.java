
package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Imgs;
import com.june.app.model.SideBanner;
import com.june.app.repository.SideBannerRepository;

/**
 * JPA implementation of the {@link SideBannerRepository} interface.
 *
 * @author Mike Keith
 * @since 22.4.2006
 */
@Repository
public class JpaSideBannerRepositoryImpl implements SideBannerRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<SideBanner> getSideBannerList(SideBanner sideBanner) {
		String searchKey = sideBanner.getSearchKey();
		String searchVal = sideBanner.getSearchVal();
		String queryFrom = "SELECT DISTINCT sideBanner FROM SideBanner sideBanner ";
		//String queryWhere = " WHERE sideBanner.parent_id = '0' ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += "  WHERE sideBanner.bannername like '%" + searchVal + "%' ";
			}
		}
		
		
		/*int userId = sideBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND sideBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = sideBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND sideBanner.use_at = '" + useAt + "' ";
		}*/
		String queryOrder = " ORDER BY sideBanner.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = sideBanner.getPageSize();
		int pageNumber = sideBanner.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getSideBannerListCnt(SideBanner sideBanner) {
		String searchKey = sideBanner.getSearchKey();
		String searchVal = sideBanner.getSearchVal();
		String queryFrom = "SELECT count(sideBanner) FROM SideBanner sideBanner ";
		String queryWhere = "";
		//String queryWhere = " WHERE sideBanner.parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE sideBanner.bannername like '%" + searchVal + "%'";
			}
		}
		/*int userId = sideBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND sideBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = sideBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND sideBanner.use_at = '" + useAt + "' ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
		
	}

	@Override
	public SideBanner getSideBanner(SideBanner sideBanner) {
		String queryFrom = "SELECT sideBanner FROM SideBanner sideBanner";
		String queryWhere = " WHERE sideBanner.id = " + sideBanner.getId() + " ";

		/*int userId = sideBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND sideBanner.user_id = " + userId + " ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		/*
		 * Query query = this.em.createQuery(
		 * "SELECT sideBanner FROM SideBanner sideBanner left join fetch sideBanner.sideBannerLocales WHERE sideBanner.id =:id"
		 * ); query.setParameter("id", sideBanner.getId());
		 */
		return (SideBanner) query.getSingleResult();
	}

	@Override
	public void putSideBanner(SideBanner sideBanner) {
		this.em.persist(sideBanner);

	}

	@Override
	public void setSideBanner(SideBanner sideBanner) {
		this.em.merge(sideBanner);
	}

	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

}