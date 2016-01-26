package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Menu;
import com.june.app.repository.MenuRepository;

/**
 * JPA implementation of the {@link MenuRepository} interface.
 *
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaMenuRepositoryImpl implements MenuRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Menu> getMenuList(Menu menu) {
		String searchKey = menu.getSearchKey();
		String searchVal = menu.getSearchVal();
		String queryFrom = "SELECT DISTINCT menu FROM Menu menu ";
		String queryWhere = " WHERE parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND exists ( select id from MenuLocale where locale='ko' AND menu.id = menu_id AND name like '%"
						+ searchVal + "%') ";
			}
		}
		String queryOrder = " ORDER BY menu.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = menu.getPageSize();
		int pageNumber = menu.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getMenuListCnt(Menu menu) {
		String searchKey = menu.getSearchKey();
		String searchVal = menu.getSearchVal();
		String queryFrom = "SELECT count(menu) FROM Menu menu ";
		String queryWhere = " WHERE parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND exists ( select id from MenuLocale where locale='ko' AND menu.id = menu_id AND name like '%"
						+ searchVal + "%') ";
			}
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public Collection<Menu> getMenuListAll(Menu menu) {
		Query query = this.em
				.createQuery("SELECT DISTINCT menu FROM Menu menu WHERE parent_id = '0' ORDER BY menu.position");
		return query.getResultList();
	}

	@Override
	public Menu getMenu(Menu menu) {
		Query query = this.em
				.createQuery("SELECT menu FROM Menu menu left join fetch menu.menuLocales WHERE menu.id =:id");
		query.setParameter("id", menu.getId());
		return (Menu) query.getSingleResult();
	}

	@Override
	public void putMenu(Menu menu) {
		this.em.persist(menu);

	}

	@Override
	public void setMenu(Menu menu) {
		this.em.merge(menu);
	}

}
