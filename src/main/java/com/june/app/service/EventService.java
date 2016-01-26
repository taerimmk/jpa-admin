package com.june.app.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.model.Event;
import com.june.app.model.Imgs;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 */
public interface EventService {

	Collection<Event> getEventList(Event event) throws DataAccessException;

	int getEventListCnt(Event event) throws DataAccessException;

	Event getEvent(Event event) throws DataAccessException;

	void putEvent(Event event) throws DataAccessException;

	void setEvent(Event event) throws DataAccessException;
	
	void putImgs(Imgs imgs) throws DataAccessException;

}
