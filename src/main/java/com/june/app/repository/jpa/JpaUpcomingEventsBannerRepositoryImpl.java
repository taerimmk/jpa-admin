
package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Imgs;
import com.june.app.model.UpcomingEventsBanner;
import com.june.app.repository.UpcomingEventsBannerRepository;

/**
 * JPA implementation of the {@link UpcomingEventsBannerRepository} interface.
 *
 * @author Mike Keith
 * @since 22.4.2006
 */
@Repository
public class JpaUpcomingEventsBannerRepositoryImpl implements UpcomingEventsBannerRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<UpcomingEventsBanner> getUpcomingEventsBannerList(UpcomingEventsBanner upcomingEventsBanner) {
		String searchKey = upcomingEventsBanner.getSearchKey();
		String searchVal = upcomingEventsBanner.getSearchVal();
		String queryFrom = "SELECT DISTINCT upcomingEventsBanner FROM UpcomingEventsBanner upcomingEventsBanner ";
		//String queryWhere = " WHERE upcomingEventsBanner.parent_id = '0' ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += "  WHERE upcomingEventsBanner.bannername like '%" + searchVal + "%' ";
			}
		}
		
		
		/*int userId = upcomingEventsBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND upcomingEventsBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = upcomingEventsBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND upcomingEventsBanner.use_at = '" + useAt + "' ";
		}*/
		String queryOrder = " ORDER BY upcomingEventsBanner.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = upcomingEventsBanner.getPageSize();
		int pageNumber = upcomingEventsBanner.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getUpcomingEventsBannerListCnt(UpcomingEventsBanner upcomingEventsBanner) {
		String searchKey = upcomingEventsBanner.getSearchKey();
		String searchVal = upcomingEventsBanner.getSearchVal();
		String queryFrom = "SELECT count(upcomingEventsBanner) FROM UpcomingEventsBanner upcomingEventsBanner ";
		String queryWhere = "";
		//String queryWhere = " WHERE upcomingEventsBanner.parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE upcomingEventsBanner.bannername like '%" + searchVal + "%'";
			}
		}
		/*int userId = upcomingEventsBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND upcomingEventsBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = upcomingEventsBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND upcomingEventsBanner.use_at = '" + useAt + "' ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
		
	}

	@Override
	public UpcomingEventsBanner getUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) {
		String queryFrom = "SELECT upcomingEventsBanner FROM UpcomingEventsBanner upcomingEventsBanner";
		String queryWhere = " WHERE upcomingEventsBanner.id = " + upcomingEventsBanner.getId() + " ";

		/*int userId = upcomingEventsBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND upcomingEventsBanner.user_id = " + userId + " ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		/*
		 * Query query = this.em.createQuery(
		 * "SELECT upcomingEventsBanner FROM UpcomingEventsBanner upcomingEventsBanner left join fetch upcomingEventsBanner.upcomingEventsBannerLocales WHERE upcomingEventsBanner.id =:id"
		 * ); query.setParameter("id", upcomingEventsBanner.getId());
		 */
		return (UpcomingEventsBanner) query.getSingleResult();
	}

	@Override
	public void putUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) {
		this.em.persist(upcomingEventsBanner);

	}

	@Override
	public void setUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) {
		this.em.merge(upcomingEventsBanner);
	}

	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

}