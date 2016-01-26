
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

import com.june.app.model.FooterBanner;
import com.june.app.model.Theme;
import com.june.app.service.FooterBannerService;

/**
 * @author Trk
 */

@Controller
public class FooterBannerController extends CommonController {

	@Autowired
	private FooterBannerService footerBannerService;


	@RequestMapping(value = { "/footerBanner/list/{pageIndex}",
			"/footerBanner/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String footerBanners(Map<String, Object> model, FooterBanner footerBanner, HttpServletRequest request,
			@RequestParam(value = "use_at", required = false) String use_at, @PathVariable("pageIndex") int pageIndex,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) {

		logger.debug("]-------------]footerBanner searchVal[-------------[ {}", pathVariables.get("searchVal"));
		/** 페이지당 보여주는 게시물 수 */
		footerBanner.setPageSize(10);
		/** 현재 페이지 */
		footerBanner.setPageIndex(pageIndex);
		/** 게시판 LIST */
		footerBanner.setUse_at(use_at);
		Collection<FooterBanner> footerBannerList = footerBannerService.getFooterBannerList(footerBanner);
		int totalCnt = footerBannerService.getFooterBannerListCnt(footerBanner);
		footerBanner.setTotalCnt(totalCnt);
		model.put("footerBannerList", footerBannerList);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "5");
		status.setComplete();
		return "footerBanner/footerBannerList";
	}

	@RequestMapping(value = "/footerBanner/put", method = RequestMethod.GET)
	public String footerBannerPut(Map<String, Object> model, Theme theme) {
		FooterBanner footerBanner = new FooterBanner();
		model.put("footerBanner", footerBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "5");
		return "footerBanner/footerBannerPut";
	}

	@RequestMapping(value = "/footerBanner/put", method = RequestMethod.POST)
	public String footerBannerPutPost(Map<String, Object> model, @Valid FooterBanner footerBanner,
			MultipartHttpServletRequest multiRequest, SessionStatus status) {
		logger.debug("]-------------]footerBannerPutPost[-------------[ {}", footerBanner);

		footerBannerService.putFooterBanner(footerBanner);
		status.setComplete();

		model.put("footerBanner", footerBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "5");
		return "redirect:/footerBanner/list/1";
	}

	@RequestMapping(value = { "/footerBanner/{pageIndex}/{id}",
			"/footerBanner/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String footerBannerGet(Map<String, Object> model, FooterBanner footerBanner, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		footerBanner.setId(id);
		FooterBanner footerBannerRes = footerBannerService.getFooterBanner(footerBanner);
		logger.debug("===========]footerBannerRes[=========== {}", footerBannerRes);
		model.put("footerBannerRes", footerBannerRes);

		model.put("sideMenu", "5");
		model.put("sideMenuSub", "5");
		return "footerBanner/footerBannerSet";
	}

	@RequestMapping(value = { "/footerBanner/set/{pageIndex}/{id}",
			"/footerBanner/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String footerBannerSet(Map<String, Object> model, FooterBanner footerBanner, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", footerBanner);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		footerBannerService.setFooterBanner(footerBanner);
		status.setComplete();

		footerBanner.setPageIndex(pageIndex);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "5");
		if (StringUtils.isNotEmpty(searchVal)) {
			footerBanner.setSearchKey(searchKey);
			footerBanner.setSearchVal(searchVal);
			model.put("footerBanner", footerBanner);
			return "redirect:/footerBanner/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("footerBanner", footerBanner);
			return "redirect:/footerBanner/" + pageIndex + "/" + id;
		}
	}

}