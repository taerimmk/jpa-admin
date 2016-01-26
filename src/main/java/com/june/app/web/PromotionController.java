
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

import com.june.app.model.Promotion;
import com.june.app.service.PromotionService;

/**
 * @author Trk
 */
@Controller
public class PromotionController extends CommonController {

	@Autowired
	private PromotionService promotionService;

	@RequestMapping(value = { "/promotion/list/{pageIndex}",
			"/promotion/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String promotions(Map<String, Object> model, Promotion promotion, HttpServletRequest reques,
			@PathVariable("pageIndex") int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {

		/** 페이지당 보여주는 게시물 수 */
		promotion.setPageSize(10);
		/** 현재 페이지 */
		promotion.setPageIndex(pageIndex);
		/** 게시판 LIST */
		Collection<Promotion> promotions = promotionService.getPromotionList(promotion);
		int totalCnt = promotionService.getPromotionListCnt(promotion);
		promotion.setTotalCnt(totalCnt);
		model.put("promotions", promotions);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "1");
		status.setComplete();
		return "promotion/promotionList";
	}

	@RequestMapping(value = "/promotion/put", method = RequestMethod.GET)
	public String promotionPut(Map<String, Object> model) {
		Promotion promotion = new Promotion();
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "1");
		model.put("promotion", promotion);
		return "promotion/promotionPut";
	}

	@RequestMapping(value = "/promotion/put", method = RequestMethod.POST)
	public String promotionPutPost(Map<String, Object> model, @Valid Promotion promotion, SessionStatus status) {
		logger.debug("]-------------]promotionPutPost[-------------[ {}", promotion);
		promotionService.putPromotion(promotion);
		status.setComplete();
		model.put("promotion", promotion);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "1");
		return "redirect:/promotion/list/1";
	}

	@RequestMapping(value = { "/promotion/{pageIndex}/{id}",
			"/promotion/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String promotionGet(Map<String, Object> model, Promotion promotion, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		promotion.setId(id);
		Promotion promotionRes = promotionService.getPromotion(promotion);
		logger.debug("===========]promotionRes[=========== {}", promotionRes);
		model.put("promotionRes", promotionRes);

		model.put("sideMenu", "3");
		model.put("sideMenuSub", "1");
		return "promotion/promotionSet";
	}

	@RequestMapping(value = { "/promotion/set/{pageIndex}/{id}",
			"/promotion/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String promotionSet(Map<String, Object> model, Promotion promotion, @PathVariable int id,
			HttpServletRequest req, @PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", promotion);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		promotionService.setPromotion(promotion);
		status.setComplete();
		promotion.setPageIndex(pageIndex);

		model.put("sideMenu", "3");
		model.put("sideMenuSub", "1");
		if (StringUtils.isNotEmpty(searchVal)) {
			promotion.setSearchKey(searchKey);
			promotion.setSearchVal(searchVal);
			model.put("promotion", promotion);
			return "redirect:/promotion/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("promotion", promotion);
			return "redirect:/promotion/" + pageIndex + "/" + id;
		}
	}

}
