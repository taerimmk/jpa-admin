
package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Imgs;
import com.june.app.model.FooterBanner;
import com.june.app.repository.FooterBannerRepository;

/**
 * JPA implementation of the {@link FooterBannerRepository} interface.
 *
 * @author Mike Keith
 * @since 22.4.2006
 */
@Repository
public class JpaFooterBannerRepositoryImpl implements FooterBannerRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<FooterBanner> getFooterBannerList(FooterBanner footerBanner) {
		String searchKey = footerBanner.getSearchKey();
		String searchVal = footerBanner.getSearchVal();
		String queryFrom = "SELECT DISTINCT footerBanner FROM FooterBanner footerBanner ";
		//String queryWhere = " WHERE footerBanner.parent_id = '0' ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += "  WHERE footerBanner.bannername like '%" + searchVal + "%' ";
			}
		}
		
		
		/*int userId = footerBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND footerBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = footerBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND footerBanner.use_at = '" + useAt + "' ";
		}*/
		String queryOrder = " ORDER BY footerBanner.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = footerBanner.getPageSize();
		int pageNumber = footerBanner.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getFooterBannerListCnt(FooterBanner footerBanner) {
		String searchKey = footerBanner.getSearchKey();
		String searchVal = footerBanner.getSearchVal();
		String queryFrom = "SELECT count(footerBanner) FROM FooterBanner footerBanner ";
		String queryWhere = "";
		//String queryWhere = " WHERE footerBanner.parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE footerBanner.bannername like '%" + searchVal + "%'";
			}
		}
		/*int userId = footerBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND footerBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = footerBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND footerBanner.use_at = '" + useAt + "' ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
		
	}

	@Override
	public FooterBanner getFooterBanner(FooterBanner footerBanner) {
		String queryFrom = "SELECT footerBanner FROM FooterBanner footerBanner";
		String queryWhere = " WHERE footerBanner.id = " + footerBanner.getId() + " ";

		/*int userId = footerBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND footerBanner.user_id = " + userId + " ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		/*
		 * Query query = this.em.createQuery(
		 * "SELECT footerBanner FROM FooterBanner footerBanner left join fetch footerBanner.footerBannerLocales WHERE footerBanner.id =:id"
		 * ); query.setParameter("id", footerBanner.getId());
		 */
		return (FooterBanner) query.getSingleResult();
	}

	@Override
	public void putFooterBanner(FooterBanner footerBanner) {
		this.em.persist(footerBanner);

	}

	@Override
	public void setFooterBanner(FooterBanner footerBanner) {
		this.em.merge(footerBanner);
	}

	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

}