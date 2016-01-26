
package com.june.app.service.impl;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Event;
import com.june.app.model.Imgs;
import com.june.app.repository.EventRepository;
import com.june.app.service.EventService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class EventServiceImpl extends CommonServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private FileMngUtil fileUtil;
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Event> getEventList(Event event) throws DataAccessException {
		return eventRepository.getEventList(event);
	}

	@Override
	@Transactional(readOnly = true)
	public int getEventListCnt(Event event) throws DataAccessException {
		return eventRepository.getEventListCnt(event);
	}

	@Override
	@Transactional(readOnly = true)
	public Event getEvent(Event event) throws DataAccessException {
		return eventRepository.getEvent(event);
	}

	@Override
	@Transactional
	public void putEvent(Event event) throws DataAccessException {
		
		String fileuuid = UUID.randomUUID().toString().replace("-", "");
		event.setFileuuid(fileuuid);
		eventFile(event);
		logger.debug("]-------------]eventPut before[-------------[ {}", event);
		eventRepository.putEvent(event);
		logger.debug("]-------------]eventPut after [-------------[ {}", event);

	}

	@Override
	@Transactional
	public void setEvent(Event event) throws DataAccessException {
		logger.debug("]-------------]setEvent before [-------------[ {}", event);
		
		eventFile(event);
		
		eventRepository.setEvent(event);
		logger.debug("]-------------]setEvent after [-------------[ {}", event);
	}
	
	public void eventFile(Event event) {
		if (event.getFile() != null) {
			if (!event.getFile().isEmpty()) {
				try {
					String image = fileUtil.parseFileInfCompany(event.getFile(), "event_", 0,
							"event");
					logger.debug("===========] call image [============={}", image);
					event.setImage(image);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
	}

	@Override
	@Transactional
	public void putImgs(Imgs imgs) throws DataAccessException {
		eventRepository.putImgs(imgs);
	}

}
