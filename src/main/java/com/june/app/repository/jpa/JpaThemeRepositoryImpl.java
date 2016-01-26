package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Theme;
import com.june.app.repository.ThemeRepository;

/**
 * JPA implementation of the {@link ThemeRepository} interface.
 *
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaThemeRepositoryImpl implements ThemeRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Theme> getThemeList(Theme theme) {
		String searchKey = theme.getSearchKey();
		String searchVal = theme.getSearchVal();
		String queryFrom = "SELECT DISTINCT theme FROM Theme theme ";
		String queryWhere = " WHERE parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND theme.title like '%" + searchVal + "%' ";
			}
		}
		String queryOrder = " ORDER BY theme.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = theme.getPageSize();
		int pageNumber = theme.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getThemeListCnt(Theme theme) {
		String searchKey = theme.getSearchKey();
		String searchVal = theme.getSearchVal();
		String queryFrom = "SELECT count(theme) FROM Theme theme ";
		String queryWhere = " WHERE parent_id = '0' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND theme.title like '%" + searchVal + "%'";
			}
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public Collection<Theme> getThemeListAll(Theme theme) {
		Query query = this.em
				.createQuery("SELECT DISTINCT theme FROM Theme theme WHERE parent_id = '0' ORDER BY theme.position");
		return query.getResultList();
	}

	@Override
	public Theme getTheme(Theme theme) {
		Query query = this.em
				.createQuery("SELECT theme FROM Theme theme left join fetch theme.themeLocales WHERE theme.id =:id");
		query.setParameter("id", theme.getId());
		return (Theme) query.getSingleResult();
	}

	@Override
	public void putTheme(Theme theme) {
		this.em.persist(theme);

	}

	@Override
	public void setTheme(Theme theme) {
		this.em.merge(theme);
	}

}
