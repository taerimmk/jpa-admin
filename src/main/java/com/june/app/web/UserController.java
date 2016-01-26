package com.june.app.web;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.june.app.model.UserInfo;
import com.june.app.service.UserService;

@Controller
@SessionAttributes(types = UserInfo.class)
public class UserController extends CommonController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/user/list/{pageIndex}",
			"/user/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String users(Map<String, Object> model, UserInfo user, HttpServletRequest reques,
			@PathVariable("pageIndex") int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {

		/** 페이지당 보여주는 게시물 수 */
		user.setPageSize(10);
		/** 현재 페이지 */
		user.setPageIndex(pageIndex);
		/** 게시판 LIST */
		Collection<UserInfo> users = userService.getUsers(user);
		int totalCnt = userService.getUsersCnt(user);
		user.setTotalCnt(totalCnt);
		model.put("users", users);
		model.put("user", user);
		model.put("sideMenu", "4");
		model.put("sideMenuSub", "1");
		status.setComplete();
		return "user/userList";
	}

	@RequestMapping(value = { "/user/{pageIndex}/{id}",
			"/user/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String userGet(Map<String, Object> model, UserInfo user, @PathVariable int id, @PathVariable int pageIndex,
			@PathVariable Map<String, String> pathVariables) {
		user.setId(id);
		UserInfo userRes = userService.getUserById(user);
		logger.debug("===========]userRes[=========== {}", userRes);
		model.put("userRes", userRes);
		model.put("user", user);
		model.put("sideMenu", "4");
		model.put("sideMenuSub", "1");
		return "user/userSet";
	}

	@RequestMapping(value = { "/user/set/{pageIndex}/{id}",
			"/user/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String userSet(Map<String, Object> model, UserInfo user, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", user);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		user.setRole("ROLE_USER");
		userService.setUser(user);
		status.setComplete();
		user.setPageIndex(pageIndex);
		model.put("user", user);
		model.put("sideMenu", "4");
		model.put("sideMenuSub", "1");
		if (StringUtils.isNotEmpty(searchVal)) {
			user.setSearchKey(searchKey);
			user.setSearchVal(searchVal);
			model.put("user", user);
			return "redirect:/user/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("user", user);
			return "redirect:/user/" + pageIndex + "/" + id;
		}
	}

	@RequestMapping(value = "/user/excelList", method = RequestMethod.GET)
	public String excelCounselling(Map<String, Object> model, Locale locale, UserInfo user) {

		List<UserInfo> userList = userService.getUsersAll(user);
		model.put("excelList", userList);
		model.put("target", "userList");
		return "excelView";

	}

}
