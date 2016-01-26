package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Board;
import com.june.app.model.BoardMaster;
import com.june.app.model.Imgs;
import com.june.app.repository.BoardRepository;

/**
 * JPA implementation of the {@link BoardRepository} interface.
 *
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaBoardRepositoryImpl implements BoardRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Board> getBoardList(Board board) {
		String searchKey = board.getSearchKey();
		String searchVal = board.getSearchVal();
		int boardMst = board.getBoard_master_id();
		String queryFrom = "SELECT DISTINCT board FROM Board board ";
		String queryWhere = " WHERE 1=1 ";
		if (boardMst > 0) {
			queryWhere += " AND board.board_master_id = " + boardMst;
		}
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND board.boardname like '%" + searchVal + "%' ";
			}
		}
		String queryOrder = " ORDER BY board.created_at desc";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = board.getPageSize();
		int pageNumber = board.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getBoardListCnt(Board board) {
		String searchKey = board.getSearchKey();
		String searchVal = board.getSearchVal();
		int boardMst = board.getBoard_master_id();
		String queryFrom = "SELECT count(board) FROM Board board ";
		String queryWhere = " WHERE 1=1 ";
		if (boardMst > 0) {
			queryWhere += " AND board.board_master_id = " + boardMst;
		}
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " AND board.boardname like '%" + searchVal + "%' ";
			}
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public Collection<BoardMaster> getBoardMasterListAll(BoardMaster boardMaster) {
		Query query = this.em
				.createQuery("SELECT DISTINCT boardMaster FROM BoardMaster boardMaster  ORDER BY boardMaster.id");
		return query.getResultList();
	}

	@Override
	public Board getBoard(Board board) {
		Query query = this.em
				.createQuery("SELECT board FROM Board board left join fetch board.boardLocales WHERE board.id =:id");
		query.setParameter("id", board.getId());
		return (Board) query.getSingleResult();
	}

	@Override
	public void putBoard(Board board) {
		this.em.persist(board);

	}

	@Override
	public void setBoard(Board board) {
		this.em.merge(board);
	}

	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

	@Override
	public void delBoard(Board board) {
		Board boardToBeRemoved = em.getReference(Board.class, board.getId());
		this.em.remove(boardToBeRemoved);
	}

}
