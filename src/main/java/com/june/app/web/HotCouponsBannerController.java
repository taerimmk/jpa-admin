
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

import com.june.app.model.HotCouponsBanner;
import com.june.app.model.Theme;
import com.june.app.service.HotCouponsBannerService;

/**
 * @author Trk
 */

@Controller
public class HotCouponsBannerController extends CommonController {

	@Autowired
	private HotCouponsBannerService hotCouponsBannerService;


	@RequestMapping(value = { "/hotCouponsBanner/list/{pageIndex}",
			"/hotCouponsBanner/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String hotCouponsBanners(Map<String, Object> model, HotCouponsBanner hotCouponsBanner, HttpServletRequest request,
			@RequestParam(value = "use_at", required = false) String use_at, @PathVariable("pageIndex") int pageIndex,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) {

		logger.debug("]-------------]hotCouponsBanner searchVal[-------------[ {}", pathVariables.get("searchVal"));
		/** 페이지당 보여주는 게시물 수 */
		hotCouponsBanner.setPageSize(10);
		/** 현재 페이지 */
		hotCouponsBanner.setPageIndex(pageIndex);
		/** 게시판 LIST */
		hotCouponsBanner.setUse_at(use_at);
		Collection<HotCouponsBanner> hotCouponsBannerList = hotCouponsBannerService.getHotCouponsBannerList(hotCouponsBanner);
		int totalCnt = hotCouponsBannerService.getHotCouponsBannerListCnt(hotCouponsBanner);
		hotCouponsBanner.setTotalCnt(totalCnt);
		model.put("hotCouponsBannerList", hotCouponsBannerList);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "3");
		status.setComplete();
		return "hotCouponsBanner/hotCouponsBannerList";
	}

	@RequestMapping(value = "/hotCouponsBanner/put", method = RequestMethod.GET)
	public String hotCouponsBannerPut(Map<String, Object> model, Theme theme) {
		HotCouponsBanner hotCouponsBanner = new HotCouponsBanner();
		model.put("hotCouponsBanner", hotCouponsBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "3");
		return "hotCouponsBanner/hotCouponsBannerPut";
	}

	@RequestMapping(value = "/hotCouponsBanner/put", method = RequestMethod.POST)
	public String hotCouponsBannerPutPost(Map<String, Object> model, @Valid HotCouponsBanner hotCouponsBanner,
			MultipartHttpServletRequest multiRequest, SessionStatus status) {
		logger.debug("]-------------]hotCouponsBannerPutPost[-------------[ {}", hotCouponsBanner);

		hotCouponsBannerService.putHotCouponsBanner(hotCouponsBanner);
		status.setComplete();

		model.put("hotCouponsBanner", hotCouponsBanner);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "3");
		return "redirect:/hotCouponsBanner/list/1";
	}

	@RequestMapping(value = { "/hotCouponsBanner/{pageIndex}/{id}",
			"/hotCouponsBanner/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String hotCouponsBannerGet(Map<String, Object> model, HotCouponsBanner hotCouponsBanner, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		hotCouponsBanner.setId(id);
		HotCouponsBanner hotCouponsBannerRes = hotCouponsBannerService.getHotCouponsBanner(hotCouponsBanner);
		logger.debug("===========]hotCouponsBannerRes[=========== {}", hotCouponsBannerRes);
		model.put("hotCouponsBannerRes", hotCouponsBannerRes);

		model.put("sideMenu", "5");
		model.put("sideMenuSub", "3");
		return "hotCouponsBanner/hotCouponsBannerSet";
	}

	@RequestMapping(value = { "/hotCouponsBanner/set/{pageIndex}/{id}",
			"/hotCouponsBanner/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String hotCouponsBannerSet(Map<String, Object> model, HotCouponsBanner hotCouponsBanner, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", hotCouponsBanner);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		hotCouponsBannerService.setHotCouponsBanner(hotCouponsBanner);
		status.setComplete();

		hotCouponsBanner.setPageIndex(pageIndex);
		model.put("sideMenu", "5");
		model.put("sideMenuSub", "3");
		if (StringUtils.isNotEmpty(searchVal)) {
			hotCouponsBanner.setSearchKey(searchKey);
			hotCouponsBanner.setSearchVal(searchVal);
			model.put("hotCouponsBanner", hotCouponsBanner);
			return "redirect:/hotCouponsBanner/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("hotCouponsBanner", hotCouponsBanner);
			return "redirect:/hotCouponsBanner/" + pageIndex + "/" + id;
		}
	}

}