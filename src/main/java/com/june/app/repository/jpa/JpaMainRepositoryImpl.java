package com.june.app.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.june.app.model.Main;
import com.june.app.repository.MainRepository;

/**
 * JPA implementation of the {@link MainRepository} interface.
 *
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaMainRepositoryImpl implements MainRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Main getMain(Main main) {
		Query query = this.em.createQuery("SELECT main FROM Main main");
		query.setFirstResult(0);
		query.setMaxResults(1);
		// query.setParameter("id", main.getId());
		Main mainNew = null;
		try {
			mainNew = (Main) query.getSingleResult();
		} catch (NoResultException nre) {
			// Code for handling NoResultException
		} catch (NonUniqueResultException nure) {
			// Code for handling NonUniqueResultException
		}
		return mainNew;
	}

	@Override
	public void putMain(Main main) {
		if (main.getId() == null || main.getId() < 1) {
			this.em.persist(main);
		} else {
			this.em.merge(main);
		}

	}

}
