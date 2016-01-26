package com.june.app.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.UserInfo;
import com.june.app.model.UserRoleInfo;
import com.june.app.repository.UserRepository;

@Transactional
@Repository
public class JpaUserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<UserInfo> getUsers(UserInfo user) {
		String searchKey = user.getSearchKey();
		String searchVal = user.getSearchVal();
		String queryFrom = "SELECT DISTINCT user FROM UserInfo user ";
		String queryWhere = " WHERE user.user_id <> 'admin' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND user.name like '%" + searchVal + "%' ";
			}
		}
		String status = user.getStatus();
		if (StringUtils.isNoneEmpty(status)) {
			queryWhere += " AND user.status = '" + status + "' ";
		}
		String queryOrder = " ORDER BY user.id desc";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = user.getPageSize();
		int pageNumber = user.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getUsersCnt(UserInfo user) {
		String searchKey = user.getSearchKey();
		String searchVal = user.getSearchVal();
		String queryFrom = "SELECT count(user) FROM UserInfo user ";
		String queryWhere = " WHERE  user.user_id <> 'admin' ";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND user.name like '%" + searchVal + "%'";
			}
		}
		String status = user.getStatus();
		if (StringUtils.isNoneEmpty(status)) {
			queryWhere += " AND user.status = '" + status + "' ";
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public void setUser(UserInfo user) {
		this.em.merge(user);
	}

	@Override
	public UserInfo getUser(String userId) {
		Query query = this.em.createQuery("SELECT userInfo FROM UserInfo userInfo WHERE userInfo.user_id =:userId");
		query.setParameter("userId", userId);

		return (UserInfo) query.getSingleResult();
	}

	@Override
	public UserInfo getUserByLogin(String userId) {
		Query query = this.em.createQuery("SELECT userInfo FROM UserInfo userInfo WHERE userInfo.user_id =:userId ");
		query.setParameter("userId", userId);

		return (UserInfo) query.getSingleResult();
	}

	@Override
	public Long selectUserId(String userId) {
		Query query = this.em
				.createQuery("SELECT count(userInfo) FROM UserInfo userInfo WHERE userInfo.user_id =:userId");
		query.setParameter("userId", userId);
		return (Long) query.getSingleResult();
	}

	@Override
	public UserInfo registerUser(UserInfo userInfo) {
		this.em.persist(userInfo);
		return userInfo;
	}

	@Override
	public UserRoleInfo registerRole(UserRoleInfo vo) {
		this.em.persist(vo);
		return vo;
	}

	@Override
	public UserInfo getUserById(UserInfo user) {
		Query query = this.em.createQuery("SELECT userInfo FROM UserInfo userInfo WHERE userInfo.id =:userId ");
		query.setParameter("userId", user.getId());

		return (UserInfo) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> getUsersAll(UserInfo user) {
		String queryFrom = "SELECT DISTINCT user FROM UserInfo user ";
		Query query = this.em.createQuery(queryFrom);
		return query.getResultList();
	}
}
