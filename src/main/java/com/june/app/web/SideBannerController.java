
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

import com.june.app.model.SideBanner;
import com.june.app.model.Theme;
import com.june.app.service.SideBannerService;

/**
 * @author Trk
 */

@Controller
public class SideBannerController extends CommonController {

	@Autowired
	private SideBannerService sideBannerService;


	@RequestMapping(value = { "/sideBanner/list/{pageIndex}",
			"/sideBanner/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String sideBanners(Map<String, Object> model, SideBanner sideBanner, HttpServletRequest request,
			@RequestParam(value = "use_at", required = false) String use_at, @PathVariable("pageIndex") int pageIndex,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) {

		logger.debug("]-------------]sideBanner searchVal[-------------[ {}", pathVariables.get("searchVal"));
		/** 페이지당 보여주는 게시물 수 */
		sideBanner.setPageSize(10);
		/** 현재 페이지 */
		sideBanner.setPageIndex(pageIndex);
		/** 게시판 LIST */
		sideBanner.setUse_at(use_at);
		Collection<SideBanner> sideBannerList = sideBannerService.getSideBannerList(sideBanner);
		int totalCnt = sideBannerService.getSideBannerListCnt(sideBanner);
		sideBanner.setTotalCnt(totalCnt);
		model.put("sideBannerList", sideBannerList);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "2");
		status.setComplete();
		return "sideBanner/sideBannerList";
	}

	@RequestMapping(value = "/sideBanner/put", method = RequestMethod.GET)
	public String sideBannerPut(Map<String, Object> model, Theme theme) {
		SideBanner sideBanner = new SideBanner();
		model.put("sideBanner", sideBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "2");
		return "sideBanner/sideBannerPut";
	}

	@RequestMapping(value = "/sideBanner/put", method = RequestMethod.POST)
	public String sideBannerPutPost(Map<String, Object> model, @Valid SideBanner sideBanner,
			MultipartHttpServletRequest multiRequest, SessionStatus status) {
		logger.debug("]-------------]sideBannerPutPost[-------------[ {}", sideBanner);

		sideBannerService.putSideBanner(sideBanner);
		status.setComplete();

		model.put("sideBanner", sideBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "2");
		return "redirect:/sideBanner/list/1";
	}

	@RequestMapping(value = { "/sideBanner/{pageIndex}/{id}",
			"/sideBanner/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String sideBannerGet(Map<String, Object> model, SideBanner sideBanner, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		sideBanner.setId(id);
		SideBanner sideBannerRes = sideBannerService.getSideBanner(sideBanner);
		logger.debug("===========]sideBannerRes[=========== {}", sideBannerRes);
		model.put("sideBannerRes", sideBannerRes);

		model.put("sideMenu", "5");
		model.put("sideMenuSub", "2");
		return "sideBanner/sideBannerSet";
	}

	@RequestMapping(value = { "/sideBanner/set/{pageIndex}/{id}",
			"/sideBanner/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String sideBannerSet(Map<String, Object> model, SideBanner sideBanner, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", sideBanner);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		sideBannerService.setSideBanner(sideBanner);
		status.setComplete();

		sideBanner.setPageIndex(pageIndex);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "2");
		if (StringUtils.isNotEmpty(searchVal)) {
			sideBanner.setSearchKey(searchKey);
			sideBanner.setSearchVal(searchVal);
			model.put("sideBanner", sideBanner);
			return "redirect:/sideBanner/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("sideBanner", sideBanner);
			return "redirect:/sideBanner/" + pageIndex + "/" + id;
		}
	}

}