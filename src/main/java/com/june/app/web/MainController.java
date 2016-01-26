package com.june.app.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.june.app.model.Main;
import com.june.app.service.MainService;

/**
 * @author trk
 */
@Controller
public class MainController extends CommonController {
	@Autowired
	private MainService mainService;

	@RequestMapping(value = { "/", "/admin" }, method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		model.put("sideMenu", "0");
		return "main/index";
	}

	@RequestMapping(value = "/main/config", method = RequestMethod.GET)
	public String mainConfig(Map<String, Object> model, SessionStatus status) {
		logger.debug("===========]mainConfig[===========");
		status.setComplete();
		Main main = new Main();
		main.setId(1);
		main = mainService.getMain(main);
		model.put("main", main);
		model.put("sideMenu", "1");
		model.put("sideMenuSub", "1");
		return "main/config";
	}

	@RequestMapping(value = "/main/config", method = RequestMethod.POST)
	public String mainPut(Map<String, Object> model, Main main, SessionStatus status) {
		logger.debug("===========]mainPut[=========== {}", main);
		mainService.putMain(main);
		status.setComplete();
		model.put("sideMenu", "1");
		model.put("sideMenuSub", "1");
		return "redirect:/main/config";
	}

	@RequestMapping(value = "/main/slide", method = RequestMethod.GET)
	public String main(Map<String, Object> model) {
		model.put("sideMenu", "1");
		model.put("sideMenuSub", "2");
		return "main/slide";
	}

}
