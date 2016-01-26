
package com.june.app.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
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

import com.june.app.model.Company;
import com.june.app.model.Theme;
import com.june.app.service.CompanyService;
import com.june.app.service.ThemeService;

/**
 * @author Trk
 */

@Controller
public class CompanyController extends CommonController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ThemeService themeService;

	@RequestMapping(value = { "/company/list/{pageIndex}",
			"/company/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String companys(Map<String, Object> model, Company company, HttpServletRequest request,
			@RequestParam(value = "use_at", required = false) String use_at, @PathVariable("pageIndex") int pageIndex,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) {

		logger.debug("]-------------]company searchVal[-------------[ {}", pathVariables.get("searchVal"));
		/** 페이지당 보여주는 게시물 수 */
		company.setPageSize(10);
		/** 현재 페이지 */
		company.setPageIndex(pageIndex);
		/** 게시판 LIST */
		company.setUse_at(use_at);
		Collection<Company> companyList = companyService.getCompanyList(company);
		int totalCnt = companyService.getCompanyListCnt(company);
		company.setTotalCnt(totalCnt);
		model.put("companyList", companyList);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		status.setComplete();
		return "company/companyList";
	}

	@RequestMapping(value = "/company/put", method = RequestMethod.GET)
	public String companyPut(Map<String, Object> model, Theme theme) {
		Company company = new Company();
		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("themeList", themeList);
		model.put("company", company);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "company/companyPut";
	}

	@RequestMapping(value = "/company/put", method = RequestMethod.POST)
	public String companyPutPost(Map<String, Object> model, @Valid Company company,
			MultipartHttpServletRequest multiRequest, SessionStatus status) {
		logger.debug("]-------------]companyPutPost[-------------[ {}", company);

		company.setUse_yn("Y");
		companyService.putCompany(company);
		status.setComplete();

		model.put("company", company);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "redirect:/company/list/1";
	}

	@RequestMapping(value = { "/company/{pageIndex}/{id}",
			"/company/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String companyGet(Map<String, Object> model, Company company, Theme theme, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		company.setId(id);
		Company companyRes = companyService.getCompany(company);
		logger.debug("===========]companyRes[=========== {}", companyRes);
		model.put("companyRes", companyRes);

		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("themeList", themeList);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "company/companySet";
	}

	@RequestMapping(value = { "/company/set/{pageIndex}/{id}",
			"/company/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String companySet(Map<String, Object> model, Company company, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", company);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		companyService.setCompany(company);
		status.setComplete();

		company.setPageIndex(pageIndex);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		if (StringUtils.isNotEmpty(searchVal)) {
			company.setSearchKey(searchKey);
			company.setSearchVal(searchVal);
			model.put("company", company);
			return "redirect:/company/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("company", company);
			return "redirect:/company/" + pageIndex + "/" + id;
		}
	}

	@RequestMapping(value = "/company/excelList", method = RequestMethod.GET)
	public String excelCounselling(Map<String, Object> model, Locale locale, Company company) {
		/** 페이지당 보여주는 게시물 수 */

		/** 현재 페이지 */
		/** 게시판 LIST */
		List<Company> companyList = companyService.getCompanyListAll(company);
		model.put("excelList", companyList);
		model.put("target", "companyList");
		return "excelView";

	}

	@RequestMapping(value = { "/company/del/{pageIndex}/{id}",
			"/company/del/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String companyDel(Map<String, Object> model, Company company, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, SessionStatus status)
					throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", company);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		company.setId(id);
		Company companyRes = companyService.getCompany(company);
		companyRes.setUse_yn("N");
		companyService.setCompany(companyRes);
		status.setComplete();

		company.setPageIndex(pageIndex);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		if (StringUtils.isNotEmpty(searchVal)) {
			company.setSearchKey(searchKey);
			company.setSearchVal(searchVal);
			model.put("company", company);
			return "redirect:/company/list/" + pageIndex + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("company", company);
			return "redirect:/company/list/" + pageIndex;
		}
	}

	@RequestMapping(value = { "/coupon/{locale}/{id}" }, method = RequestMethod.GET)
	public String companycCupon(Map<String, Object> model, Company company, HttpServletRequest req,
			@PathVariable("id") int id, @PathVariable("locale") String locale, SessionStatus status) throws Exception {
		company.setId(id);
		company.setLocale(locale);
		Company companyRes = companyService.getCompanyCoupon(company);
		logger.debug("===========]companyRes[=========== {}", companyRes);
		model.put("companyRes", companyRes);
		return "company/companyCoupon_"+locale;
	}

	@RequestMapping(value = { "/coupon/saveCoupon" }, method = RequestMethod.POST)
	public String companycCuponSet(Map<String, Object> model, HttpServletRequest req, SessionStatus status)
			throws Exception {
		req.setCharacterEncoding("utf-8");
		String base64Str = req.getParameter("imgBase64");
		String uuid = req.getParameter("uuid");
		String locale = req.getParameter("locale");
		// 인코딩된 문자열의 처음에 위치한 'data:image/png;base64,' 부분을 제거해야 디코딩에 문제가 없다.
		base64Str = base64Str.substring(base64Str.indexOf(",") + 1, base64Str.length());

		/*
		 * sourceforge에서 배포하는 Base64 클래스를 사용하면 가장 간단하게 디코딩과 이미지 파일에 저장을 동시에 처리한다
		 */
		// Base64.decodeToFile(base64Str, "d:/test/decodedImg.png"); //jpg,png
		// ok

		// java.util.Base64 클래스를 사용하여 디코딩한 후에 ImageIO를 이용하여 이미지 파일에 저장한다
		byte[] decodedBytes = Base64.getDecoder().decode(base64Str); // java.util.Base64
		try {
			BufferedImage bm = ImageIO.read(new ByteArrayInputStream(decodedBytes));
			ImageIO.write(bm, "png", new File("/var/www/html/upload/coupon/"+uuid+"_"+locale+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Apache Base64 클래스를 이용하여 디코딩한 후에 ImageIO를 이용하여 이미지 파일에 저장한다
		/*
		 * byte[] decodedBytes = Base64.decodeBase64(base64Str); //apache Base64
		 * try { BufferedImage bm = ImageIO.read(new
		 * ByteArrayInputStream(decodedBytes)); ImageIO.write(bm, "png", new
		 * File("d:/test/decodedImg.png")); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
		return "jsonView";
	}
}
