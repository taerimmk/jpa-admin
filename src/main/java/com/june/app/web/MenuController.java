
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

import com.june.app.model.Menu;
import com.june.app.service.MenuService;

/**
 * @author Trk
 */
@Controller
public class MenuController extends CommonController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = { "/menu/list/{pageIndex}",
			"/menu/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String menus(Map<String, Object> model, Menu menu, HttpServletRequest reques,
			@PathVariable("pageIndex") int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {

		/** 페이지당 보여주는 게시물 수 */
		menu.setPageSize(10);
		/** 현재 페이지 */
		menu.setPageIndex(pageIndex);
		/** 게시판 LIST */
		menu.setParent_id(0);
		Collection<Menu> menuList = menuService.getMenuList(menu);
		int totalCnt = menuService.getMenuListCnt(menu);
		menu.setTotalCnt(totalCnt);
		model.put("menuList", menuList);
		model.put("sideMenu", "1");
		model.put("sideMenuSub", "2");
		status.setComplete();
		return "menu/menuList";
	}

	@RequestMapping(value = "/menu/put", method = RequestMethod.GET)
	public String menuPut(Map<String, Object> model) {
		Menu menu = new Menu();
		Collection<Menu> menuList = menuService.getMenuListAll(menu);
		model.put("menuList", menuList);
		model.put("sideMenu", "1");
		model.put("sideMenuSub", "2");
		model.put("menu", menu);
		return "menu/menuPut";
	}

	@RequestMapping(value = "/menu/put", method = RequestMethod.POST)
	public String menuPutPost(Map<String, Object> model, @Valid Menu menu, SessionStatus status) {
		logger.debug("]-------------]menuPutPost[-------------[ {}", menu);
		menuService.putMenu(menu);
		status.setComplete();
		model.put("menu", menu);
		model.put("sideMenu", "1");
		model.put("sideMenuSub", "2");
		return "redirect:/menu/list/1";
	}

	@RequestMapping(value = { "/menu/{pageIndex}/{id}",
			"/menu/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String menuGet(Map<String, Object> model, Menu menu, @PathVariable int id, @PathVariable int pageIndex,
			@PathVariable Map<String, String> pathVariables) {
		menu.setId(id);
		Menu menuRes = menuService.getMenu(menu);
		// List<MenuLocale> menuLocales =
		// menuService.getMenuLocaleList(menu);
		logger.debug("===========]menuRes[=========== {}", menuRes);
		model.put("menuRes", menuRes);

		Collection<Menu> menuList = menuService.getMenuListAll(menu);
		model.put("menuList", menuList);
		// model.put("menuLocales", menuLocales);
		model.put("sideMenu", "1");
		model.put("sideMenuSub", "2");
		return "menu/menuSet";
	}

	@RequestMapping(value = { "/menu/set/{pageIndex}/{id}",
			"/menu/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String menuSet(Map<String, Object> model, Menu menu, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", menu);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		menuService.setMenu(menu);
		status.setComplete();
		Collection<Menu> menuList = menuService.getMenuListAll(menu);
		model.put("menuList", menuList);
		menu.setPageIndex(pageIndex);

		model.put("sideMenu", "1");
		model.put("sideMenuSub", "2");
		if (StringUtils.isNotEmpty(searchVal)) {
			menu.setSearchKey(searchKey);
			menu.setSearchVal(searchVal);
			model.put("menu", menu);
			return "redirect:/menu/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("menu", menu);
			return "redirect:/menu/" + pageIndex + "/" + id;
		}
	}

}
