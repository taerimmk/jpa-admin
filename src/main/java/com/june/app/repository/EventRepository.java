
package com.june.app.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Event;
import com.june.app.model.Imgs;

/**
 * Repository class for <code>Event</code> domain objects All method names
 * are compliant with Spring Data naming conventions so this interface can
 * easily be extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/
 * jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 */
public interface EventRepository {

	Collection<Event> getEventList(Event event) throws DataAccessException;

	int getEventListCnt(Event event) throws DataAccessException;

	Event getEvent(Event event) throws DataAccessException;

	void putEvent(Event event) throws DataAccessException;

	void setEvent(Event event) throws DataAccessException;

	void putImgs(Imgs imgs) throws DataAccessException;
}
