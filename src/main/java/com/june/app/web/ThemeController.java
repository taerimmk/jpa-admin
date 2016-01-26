
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

import com.june.app.model.Theme;
import com.june.app.service.ThemeService;

/**
 * @author Trk
 */
@Controller
public class ThemeController extends CommonController {

	@Autowired
	private ThemeService themeService;

	@RequestMapping(value = { "/theme/list/{pageIndex}",
			"/theme/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String themes(Map<String, Object> model, Theme theme, HttpServletRequest reques,
			@PathVariable("pageIndex") int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {

		/** 페이지당 보여주는 게시물 수 */
		theme.setPageSize(10);
		/** 현재 페이지 */
		theme.setPageIndex(pageIndex);
		/** 게시판 LIST */
		theme.setParent_id(0);
		Collection<Theme> themes = themeService.getThemeList(theme);
		int totalCnt = themeService.getThemeListCnt(theme);
		theme.setTotalCnt(totalCnt);
		model.put("themes", themes);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "3");
		status.setComplete();
		return "theme/themeList";
	}

	@RequestMapping(value = "/theme/put", method = RequestMethod.GET)
	public String themePut(Map<String, Object> model) {
		Theme theme = new Theme();
		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "3");
		model.put("themeList", themeList);
		model.put("theme", theme);
		return "theme/themePut";
	}

	@RequestMapping(value = "/theme/put", method = RequestMethod.POST)
	public String themePutPost(Map<String, Object> model, @Valid Theme theme, SessionStatus status) {
		logger.debug("]-------------]themePutPost[-------------[ {}", theme);
		themeService.putTheme(theme);
		status.setComplete();
		model.put("theme", theme);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "3");
		return "redirect:/theme/list/1";
	}

	@RequestMapping(value = { "/theme/{pageIndex}/{id}",
			"/theme/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String themeGet(Map<String, Object> model, Theme theme, @PathVariable int id, @PathVariable int pageIndex,
			@PathVariable Map<String, String> pathVariables) {
		theme.setId(id);
		Theme themeRes = themeService.getTheme(theme);
		// List<ThemeLocale> themeLocales =
		// themeService.getThemeLocaleList(theme);
		logger.debug("===========]themeRes[=========== {}", themeRes);
		model.put("themeRes", themeRes);

		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("themeList", themeList);
		// model.put("themeLocales", themeLocales);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "3");
		return "theme/themeSet";
	}

	@RequestMapping(value = { "/theme/set/{pageIndex}/{id}",
			"/theme/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String themeSet(Map<String, Object> model, Theme theme, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", theme);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		themeService.setTheme(theme);
		status.setComplete();
		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("themeList", themeList);
		theme.setPageIndex(pageIndex);

		model.put("sideMenu", "2");
		model.put("sideMenuSub", "3");
		if (StringUtils.isNotEmpty(searchVal)) {
			theme.setSearchKey(searchKey);
			theme.setSearchVal(searchVal);
			model.put("theme", theme);
			return "redirect:/theme/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("theme", theme);
			return "redirect:/theme/" + pageIndex + "/" + id;
		}
	}

}
