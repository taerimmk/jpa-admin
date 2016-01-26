package com.june.app.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.june.app.model.Event;
import com.june.app.model.Imgs;
import com.june.app.repository.EventRepository;

/**
 * JPA implementation of the {@link EventRepository} interface.
 *
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaEventRepositoryImpl implements EventRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Event> getEventList(Event event) {
		String searchKey = event.getSearchKey();
		String searchVal = event.getSearchVal();
		String queryFrom = "SELECT DISTINCT event FROM Event event ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE event.eventname like '%" + searchVal + "%' ";
			}
		}
		String queryOrder = " ORDER BY event.id desc";

		String queryExcute = queryFrom + queryWhere + queryOrder;
		Query query = this.em.createQuery(queryExcute);
		int pageSize = event.getPageSize();
		int pageNumber = event.getPageIndex();
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getEventListCnt(Event event) {
		String searchKey = event.getSearchKey();
		String searchVal = event.getSearchVal();
		String queryFrom = "SELECT count(event) FROM Event event ";
		String queryWhere = "";
		if (StringUtils.isNotBlank(searchKey) && StringUtils.isNotBlank(searchVal)) {
			if ("001".equals(searchKey)) {
				queryWhere += " WHERE event.eventname like '%" + searchVal + "%'";
			}
		}
		String queryExcute = queryFrom + queryWhere;
		Query query = this.em.createQuery(queryExcute);
		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public Event getEvent(Event event) {
		Query query = this.em.createQuery(
				"SELECT event FROM Event event left join fetch event.eventLocales WHERE event.id =:id");
		query.setParameter("id", event.getId());
		return (Event) query.getSingleResult();
	}

	@Override
	public void putEvent(Event event) {
		this.em.persist(event);

	}

	@Override
	public void setEvent(Event event) {
		this.em.merge(event);
	}
	
	@Override
	public void putImgs(Imgs imgs) {
		this.em.persist(imgs);
	}

}
