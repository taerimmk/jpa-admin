
package com.june.app.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.util.FileMngUtil;

/**
 * @author Trk
 */
@Controller
public class EditorController extends CommonController {

	@Autowired
	private FileMngUtil fileMngUtil;

	@RequestMapping(value = "/common/ajax/saveimage")
	public Object saveimage(HttpServletRequest req, HttpServletResponse res, Model model,
			MultipartHttpServletRequest multiRequest) throws Exception {
		logger.debug("############# saveimage #############");
		MultipartFile file = multiRequest.getFile("file");
		logger.debug("===========] call files [=============" + file);
		String result = "";
		if (file != null) {
			result = fileMngUtil.parseFileInfSingle(file, "editor_", "editor");
		}
		logger.debug("############# result #############" + result);

		model.addAttribute("url", result);
		return "jsonView";
	}

}
