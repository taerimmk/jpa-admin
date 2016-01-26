
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

import com.june.app.model.MainBanner;
import com.june.app.model.Theme;
import com.june.app.service.MainBannerService;

/**
 * @author Trk
 */

@Controller
public class MainBannerController extends CommonController {

	@Autowired
	private MainBannerService mainBannerService;


	@RequestMapping(value = { "/mainBanner/list/{pageIndex}",
			"/mainBanner/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String mainBanners(Map<String, Object> model, MainBanner mainBanner, HttpServletRequest request,
			@RequestParam(value = "use_at", required = false) String use_at, @PathVariable("pageIndex") int pageIndex,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) {

		logger.debug("]-------------]mainBanner searchVal[-------------[ {}", pathVariables.get("searchVal"));
		/** 페이지당 보여주는 게시물 수 */
		mainBanner.setPageSize(10);
		/** 현재 페이지 */
		mainBanner.setPageIndex(pageIndex);
		/** 게시판 LIST */
		mainBanner.setUse_at(use_at);
		Collection<MainBanner> mainBannerList = mainBannerService.getMainBannerList(mainBanner);
		int totalCnt = mainBannerService.getMainBannerListCnt(mainBanner);
		mainBanner.setTotalCnt(totalCnt);
		model.put("mainBannerList", mainBannerList);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "1");
		status.setComplete();
		return "mainBanner/mainBannerList";
	}

	@RequestMapping(value = "/mainBanner/put", method = RequestMethod.GET)
	public String mainBannerPut(Map<String, Object> model, Theme theme) {
		MainBanner mainBanner = new MainBanner();
		model.put("mainBanner", mainBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "1");
		return "mainBanner/mainBannerPut";
	}

	@RequestMapping(value = "/mainBanner/put", method = RequestMethod.POST)
	public String mainBannerPutPost(Map<String, Object> model, @Valid MainBanner mainBanner,
			MultipartHttpServletRequest multiRequest, SessionStatus status) {
		logger.debug("]-------------]mainBannerPutPost[-------------[ {}", mainBanner);

		mainBannerService.putMainBanner(mainBanner);
		status.setComplete();

		model.put("mainBanner", mainBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "1");
		return "redirect:/mainBanner/list/1";
	}

	@RequestMapping(value = { "/mainBanner/{pageIndex}/{id}",
			"/mainBanner/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String mainBannerGet(Map<String, Object> model, MainBanner mainBanner, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		mainBanner.setId(id);
		MainBanner mainBannerRes = mainBannerService.getMainBanner(mainBanner);
		logger.debug("===========]mainBannerRes[=========== {}", mainBannerRes);
		model.put("mainBannerRes", mainBannerRes);

		model.put("sideMenu", "5");
		model.put("sideMenuSub", "1");
		return "mainBanner/mainBannerSet";
	}

	@RequestMapping(value = { "/mainBanner/set/{pageIndex}/{id}",
			"/mainBanner/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String mainBannerSet(Map<String, Object> model, MainBanner mainBanner, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", mainBanner);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		mainBannerService.setMainBanner(mainBanner);
		status.setComplete();

		mainBanner.setPageIndex(pageIndex);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "1");
		if (StringUtils.isNotEmpty(searchVal)) {
			mainBanner.setSearchKey(searchKey);
			mainBanner.setSearchVal(searchVal);
			model.put("mainBanner", mainBanner);
			return "redirect:/mainBanner/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("mainBanner", mainBanner);
			return "redirect:/mainBanner/" + pageIndex + "/" + id;
		}
	}

}