
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.model.UpcomingEventsBanner;
import com.june.app.model.Theme;
import com.june.app.service.UpcomingEventsBannerService;

/**
 * @author Trk
 */

@Controller
public class UpcomingEventsBannerController extends CommonController {

	@Autowired
	private UpcomingEventsBannerService upcomingEventsBannerService;


	@RequestMapping(value = { "/upcomingEventsBanner/list/{pageIndex}",
			"/upcomingEventsBanner/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String upcomingEventsBanners(Map<String, Object> model, UpcomingEventsBanner upcomingEventsBanner, HttpServletRequest request,
			@RequestParam(value = "use_at", required = false) String use_at, @PathVariable("pageIndex") int pageIndex,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) {

		logger.debug("]-------------]upcomingEventsBanner searchVal[-------------[ {}", pathVariables.get("searchVal"));
		/** 페이지당 보여주는 게시물 수 */
		upcomingEventsBanner.setPageSize(10);
		/** 현재 페이지 */
		upcomingEventsBanner.setPageIndex(pageIndex);
		/** 게시판 LIST */
		upcomingEventsBanner.setUse_at(use_at);
		Collection<UpcomingEventsBanner> upcomingEventsBannerList = upcomingEventsBannerService.getUpcomingEventsBannerList(upcomingEventsBanner);
		int totalCnt = upcomingEventsBannerService.getUpcomingEventsBannerListCnt(upcomingEventsBanner);
		upcomingEventsBanner.setTotalCnt(totalCnt);
		model.put("upcomingEventsBannerList", upcomingEventsBannerList);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "4");
		status.setComplete();
		return "upcomingEventsBanner/upcomingEventsBannerList";
	}

	@RequestMapping(value = "/upcomingEventsBanner/put", method = RequestMethod.GET)
	public String upcomingEventsBannerPut(Map<String, Object> model, Theme theme) {
		UpcomingEventsBanner upcomingEventsBanner = new UpcomingEventsBanner();
		model.put("upcomingEventsBanner", upcomingEventsBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "4");
		return "upcomingEventsBanner/upcomingEventsBannerPut";
	}

	@RequestMapping(value = "/upcomingEventsBanner/put", method = RequestMethod.POST)
	public String upcomingEventsBannerPutPost(Map<String, Object> model, @Valid UpcomingEventsBanner upcomingEventsBanner,
			MultipartHttpServletRequest multiRequest, SessionStatus status) {
		logger.debug("]-------------]upcomingEventsBannerPutPost[-------------[ {}", upcomingEventsBanner);

		upcomingEventsBannerService.putUpcomingEventsBanner(upcomingEventsBanner);
		status.setComplete();

		model.put("upcomingEventsBanner", upcomingEventsBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "4");
		return "redirect:/upcomingEventsBanner/list/1";
	}

	@RequestMapping(value = { "/upcomingEventsBanner/{pageIndex}/{id}",
			"/upcomingEventsBanner/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String upcomingEventsBannerGet(Map<String, Object> model, UpcomingEventsBanner upcomingEventsBanner, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		upcomingEventsBanner.setId(id);
		UpcomingEventsBanner upcomingEventsBannerRes = upcomingEventsBannerService.getUpcomingEventsBanner(upcomingEventsBanner);
		logger.debug("===========]upcomingEventsBannerRes[=========== {}", upcomingEventsBannerRes);
		model.put("upcomingEventsBannerRes", upcomingEventsBannerRes);

		model.put("sideMenu", "5");
		model.put("sideMenuSub", "4");
		return "upcomingEventsBanner/upcomingEventsBannerSet";
	}

	@RequestMapping(value = { "/upcomingEventsBanner/set/{pageIndex}/{id}",
			"/upcomingEventsBanner/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String upcomingEventsBannerSet(Map<String, Object> model, UpcomingEventsBanner upcomingEventsBanner, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", upcomingEventsBanner);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		upcomingEventsBannerService.setUpcomingEventsBanner(upcomingEventsBanner);
		status.setComplete();

		upcomingEventsBanner.setPageIndex(pageIndex);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "4");
		if (StringUtils.isNotEmpty(searchVal)) {
			upcomingEventsBanner.setSearchKey(searchKey);
			upcomingEventsBanner.setSearchVal(searchVal);
			model.put("upcomingEventsBanner", upcomingEventsBanner);
			return "redirect:/upcomingEventsBanner/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("upcomingEventsBanner", upcomingEventsBanner);
			return "redirect:/upcomingEventsBanner/" + pageIndex + "/" + id;
		}
	}

}