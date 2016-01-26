package com.june.app.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.june.app.model.UserInfo;
import com.june.app.service.UserService;

@Controller
@SessionAttributes(types = UserInfo.class)
public class ResisterController extends CommonController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register/registerUser", method = RequestMethod.GET)
	public String home(UserInfo userInfo, Model model) {
		// UserInfo selectUser = userService.selectUser(1);

		return "user/register";
	}

	@RequestMapping(value = "/register/idDupCheck", method = RequestMethod.POST)
	public String home(@RequestParam(value = "userId", required = true) String userId, Model model) {
		Long selectUserCnt = userService.selectUserId(userId);
		model.addAttribute("result", selectUserCnt);

		return "user/register";
	}

	@RequestMapping(value = "/register/registerUser", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("userInfo") UserInfo userInfo, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			logger.debug("================]err[======== {}", result.getAllErrors());
			model.addAttribute("result", result);
			model.addAttribute("userInfo", userInfo);
			return "user/register";
		} else {
			String userId = userInfo.getUser_id();
			logger.debug("================]userId[======== {}", userId);
			Long selectUserCnt = userService.selectUserId(userId);

			logger.debug("================]selectUserCnt[======== {}", selectUserCnt);
			if (selectUserCnt == 0) {
				userService.registerUser(userInfo);
				status.setComplete();
			} else {
				model.addAttribute("result", "98");
				return "user/register";
			}
		}

		return "redirect:/login";
	}

}
