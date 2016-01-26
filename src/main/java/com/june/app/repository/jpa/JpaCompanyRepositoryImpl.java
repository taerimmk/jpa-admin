
package com.june.app.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Company;
import com.june.app.model.Imgs;
import com.june.app.repository.CompanyRepository;

/**
 * JPA implementation of the {@link CompanyRepository} interface.
 *
 * @author Mike Keith
 * @since 22.4.2006
 */
@Repository
public class JpaCompanyRepositoryImpl implements CompanyRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Company> getCompanyList(Company company) {
		String searchKey = company.getSearchKey();
		String searchVal = company.getSearchVal();
		String queryFrom = "SELECT DISTINCT company FROM Company company ";
		// String queryWhere = " WHERE company.parent_id = '0' ";
		String queryWhere = " WHERE 1=1  AND company.use_yn='Y' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND exists ( select id from CompanyLocale where locale='ko' AND company.id = company_id AND company_name like '%"
						+ searchVal + "%') ";
			}
		}
		int userId = company.getUser_id();
		if (userId > 0) {
			queryWhere += " AND company.user_id = " + userId + " ";
		}
		String useAt = company.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND company.use_at = '" + useAt + "' ";
		}
		String queryOrder = " ORDER BY company.position";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = company.getPageSize();
		int pageNumber = company.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getCompanyListCnt(Company company) {
		String searchKey = company.getSearchKey();
		String searchVal = company.getSearchVal();
		String queryFrom = "SELECT count(company) FROM Company company ";
		// String queryWhere = " WHERE company.parent_id = '0' ";
		String queryWhere = " WHERE 1=1 AND company.use_yn='Y' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND exists ( select id from CompanyLocale where locale='ko' AND company.id = company_id AND company_name like '%"
						+ searchVal + "%') ";
			}
		}
		int userId = company.getUser_id();
		if (userId > 0) {
			queryWhere += " AND company.user_id = " + userId + " ";
		}
		String useAt = company.getUse_at();
		if (StringUtils.isNoneEmpty(useAt)) {
			queryWhere += " AND company.use_at = '" + useAt + "' ";
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public Company getCompany(Company company) {
		String queryFrom = "SELECT company FROM Company company left join fetch company.companyLocales ";
		String queryWhere = " WHERE company.id = " + company.getId() + " ";

		int userId = company.getUser_id();
		if (userId > 0) {
			queryWhere += " AND company.user_id = " + userId + " ";
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		/*
		 * Query query = this.em.createQuery(
		 * "SELECT company FROM Company company left join fetch company.companyLocales WHERE company.id =:id"
		 * ); query.setParameter("id", company.getId());
		 */
		return (Company) query.getSingleResult();
	}

	@Override
	public void putCompany(Company company) {
		if ("".equals(company.getParent_id())){
			company.setParent_id(0);
		}
		this.em.persist(company);

	}

	@Override
	public void setCompany(Company company) {
		if ("".equals(company.getParent_id())){
			company.setParent_id(0);
		}
		this.em.merge(company);
	}

	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

	@SuppressWarnings("unchecked")
	public List<Company> getCompanyListAll(Company company) {
		Query query = this.em.createQuery("SELECT DISTINCT company FROM Company company WHERE company.use_yn='Y' ");
		return query.getResultList();
	}

	@Override
	public Company getCompanyCoupon(Company company) {
		Query query = this.em.createQuery(
				"SELECT company FROM Company company left join fetch company.companyLocales cl WHERE company.id =:id AND cl.locale = '"
						+ company.getLocale() + "' ");
		query.setParameter("id", company.getId());
		return (Company) query.getSingleResult();
	}

}
