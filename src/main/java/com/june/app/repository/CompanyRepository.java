
package com.june.app.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Company;
import com.june.app.model.Imgs;

public interface CompanyRepository {

	Collection<Company> getCompanyList(Company company) throws DataAccessException;

	int getCompanyListCnt(Company company) throws DataAccessException;

	Company getCompany(Company company) throws DataAccessException;

	void putCompany(Company company) throws DataAccessException;

	void setCompany(Company company) throws DataAccessException;

	void putImgs(Imgs imgs) throws DataAccessException;

	List<Company> getCompanyListAll(Company company) throws DataAccessException;

	Company getCompanyCoupon(Company company) throws DataAccessException;

}
