
package com.june.app.web;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.model.Event;
import com.june.app.service.EventService;

/**
 * @author Trk
 */
@Controller
public class EventController extends CommonController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = { "/event/list/{pageIndex}",
			"/event/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String events(Map<String, Object> model, Event event, HttpServletRequest reques,
			@PathVariable("pageIndex") int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {

		/** 페이지당 보여주는 게시물 수 */
		event.setPageSize(10);
		/** 현재 페이지 */
		event.setPageIndex(pageIndex);
		/** 게시판 LIST */
		Collection<Event> events = eventService.getEventList(event);
		int totalCnt = eventService.getEventListCnt(event);
		event.setTotalCnt(totalCnt);
		model.put("events", events);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "2");
		model.put("menu", "3");
		model.put("menuSub", "2");
		status.setComplete();
		return "event/eventList";
	}

	@RequestMapping(value = "/event/put", method = RequestMethod.GET)
	public String eventPut(Map<String, Object> model) {
		Event event = new Event();
		
		model.put("event", event);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "2");
		model.put("menu", "3");
		model.put("menuSub", "2");
		return "event/eventPut";
	}

	@RequestMapping(value = "/event/put", method = RequestMethod.POST)
	public String eventPutPost(Map<String, Object> model, @Valid Event event, MultipartHttpServletRequest multiRequest,
			SessionStatus status) {
		logger.debug("]-------------]eventPutPost[-------------[ {}", event);
		eventService.putEvent(event);
		status.setComplete();
		model.put("event", event);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "2");
		model.put("menu", "3");
		model.put("menuSub", "2");
		return "redirect:/event/list/1";
	}

	@RequestMapping(value = { "/event/{pageIndex}/{id}",
			"/event/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String eventGet(Map<String, Object> model, Event event, @PathVariable int id, @PathVariable int pageIndex,
			@PathVariable Map<String, String> pathVariables) {
		event.setId(id);
		Event eventRes = eventService.getEvent(event);
		
		logger.debug("===========]eventRes[=========== {}", eventRes);
		model.put("eventRes", eventRes);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "2");
		model.put("menu", "3");
		model.put("menuSub", "2");
		return "event/eventSet";
	}

	@RequestMapping(value = { "/event/set/{pageIndex}/{id}",
			"/event/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String eventSet(Map<String, Object> model, Event event, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", event);
		logger.debug("]-------------]eventSetPost[-------------[ {}", event);
		//logger.debug("]-------------]file [-------------[ {}", event.getFile());
		//logger.debug("]-------------]file class[-------------[ {}", event.getFile().getClass());
		//logger.debug("]-------------]file contentType[-------------[ {}", event.getFile().getContentType());
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		eventService.setEvent(event);
		status.setComplete();

		event.setPageIndex(pageIndex);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "2");
		model.put("menu", "3");
		model.put("menuSub", "2");
		if (StringUtils.isNotEmpty(searchVal)) {
			event.setSearchKey(searchKey);
			event.setSearchVal(searchVal);
			model.put("event", event);
			return "redirect:/event/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("event", event);
			return "redirect:/event/" + pageIndex + "/" + id;
		}
	}

}
