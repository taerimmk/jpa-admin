package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.BoardMaster;
import com.june.app.repository.BoardMasterRepository;

/**
 * JPA implementation of the {@link BoardMasterMasterRepository} interface.
 *
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaBoardMasterRepositoryImpl implements BoardMasterRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<BoardMaster> getBoardMasterList(BoardMaster boardMaster) {
		String searchKey = boardMaster.getSearchKey();
		String searchVal = boardMaster.getSearchVal();
		String queryFrom = "SELECT DISTINCT boardMaster FROM BoardMaster boardMaster ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE boardMaster.mastername like '%" + searchVal + "%' ";
			}
		}
		String queryOrder = " ORDER BY boardMaster.id  desc";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = boardMaster.getPageSize();
		int pageNumber = boardMaster.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getBoardMasterListCnt(BoardMaster boardMaster) {
		String searchKey = boardMaster.getSearchKey();
		String searchVal = boardMaster.getSearchVal();
		String queryFrom = "SELECT count(boardMaster) FROM BoardMaster boardMaster ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE boardMaster.mastername like '%" + searchVal + "%'";
			}
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public BoardMaster getBoardMaster(BoardMaster boardMaster) {
		Query query = this.em.createQuery(
				"SELECT boardMaster FROM BoardMaster boardMaster WHERE boardMaster.id =:id");
				//"SELECT boardMaster FROM BoardMaster boardMaster left join fetch boardMaster.boardMasterLocales WHERE boardMaster.id =:id");
		query.setParameter("id", boardMaster.getId());
		return (BoardMaster) query.getSingleResult();
	}

	@Override
	public void putBoardMaster(BoardMaster boardMaster) {
		this.em.persist(boardMaster);

	}

	@Override
	public void setBoardMaster(BoardMaster boardMaster) {
		this.em.merge(boardMaster);
	}

}
