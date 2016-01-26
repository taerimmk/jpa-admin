
package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Imgs;
import com.june.app.model.MainBanner;
import com.june.app.repository.MainBannerRepository;

/**
 * JPA implementation of the {@link MainBannerRepository} interface.
 *
 * @author Mike Keith
 * @since 22.4.2006
 */
@Repository
public class JpaMainBannerRepositoryImpl implements MainBannerRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<MainBanner> getMainBannerList(MainBanner mainBanner) {
		String searchKey = mainBanner.getSearchKey();
		String searchVal = mainBanner.getSearchVal();
		String queryFrom = "SELECT DISTINCT mainBanner FROM MainBanner mainBanner ";
		//String queryWhere = " WHERE mainBanner.parent_id = '0' ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += "  WHERE mainBanner.bannername like '%" + searchVal + "%' ";
			}
		}
		
		
		/*int userId = mainBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND mainBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = mainBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND mainBanner.use_at = '" + useAt + "' ";
		}*/
		String queryOrder = " ORDER BY mainBanner.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = mainBanner.getPageSize();
		int pageNumber = mainBanner.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getMainBannerListCnt(MainBanner mainBanner) {
		String searchKey = mainBanner.getSearchKey();
		String searchVal = mainBanner.getSearchVal();
		String queryFrom = "SELECT count(mainBanner) FROM MainBanner mainBanner ";
		String queryWhere = "";
		//String queryWhere = " WHERE mainBanner.parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE mainBanner.bannername like '%" + searchVal + "%'";
			}
		}
		/*int userId = mainBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND mainBanner.user_id = " + userId + " ";
		}*/
		/*String useAt = mainBanner.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND mainBanner.use_at = '" + useAt + "' ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
		
	}

	@Override
	public MainBanner getMainBanner(MainBanner mainBanner) {
		String queryFrom = "SELECT mainBanner FROM MainBanner mainBanner";
		String queryWhere = " WHERE mainBanner.id = " + mainBanner.getId() + " ";

		/*int userId = mainBanner.getUser_id();
		if (userId > 0) {
			queryWhere += " AND mainBanner.user_id = " + userId + " ";
		}*/
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		/*
		 * Query query = this.em.createQuery(
		 * "SELECT mainBanner FROM MainBanner mainBanner left join fetch mainBanner.mainBannerLocales WHERE mainBanner.id =:id"
		 * ); query.setParameter("id", mainBanner.getId());
		 */
		return (MainBanner) query.getSingleResult();
	}

	@Override
	public void putMainBanner(MainBanner mainBanner) {
		this.em.persist(mainBanner);

	}

	@Override
	public void setMainBanner(MainBanner mainBanner) {
		this.em.merge(mainBanner);
	}

	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

}