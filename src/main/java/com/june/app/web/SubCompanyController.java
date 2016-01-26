
package com.june.app.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.model.Company;
import com.june.app.model.CompanyLocale;
import com.june.app.model.Login;
import com.june.app.model.Theme;
import com.june.app.service.CompanyService;
import com.june.app.service.ThemeService;

/**
 * @author Trk
 */

@Controller
public class SubCompanyController extends CommonController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ThemeService themeService;

	@RequestMapping(value = "/subadmin", method = RequestMethod.GET)
	public String submain(Map<String, Object> model, Theme theme, HttpServletRequest request) {
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		if (logininfo == null) {
			return "redirect:/login";
		}
		logger.debug("]-------------]company logininfo[-------------[ {}", logininfo);

		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "redirect:/sub/company/list/1";
	}

	@RequestMapping(value = { "/sub/company/list/{pageIndex}",
			"/sub/company/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String companys(Map<String, Object> model, Company company, HttpServletRequest request,
			@PathVariable("pageIndex") int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		if (logininfo == null) {
			return "redirect:/login";
		}
		int user_id = logininfo.getUserInfo().getId();
		logger.debug("]-------------]company user_id[-------------[ {}", user_id);
		company.setUser_id(user_id);
		/** 페이지당 보여주는 게시물 수 */
		company.setPageSize(10);
		/** 현재 페이지 */
		company.setPageIndex(pageIndex);
		/** 게시판 LIST */

		Collection<Company> companyList = companyService.getCompanyList(company);
		int totalCnt = companyService.getCompanyListCnt(company);
		company.setTotalCnt(totalCnt);
		model.put("companyList", companyList);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		status.setComplete();
		return "subcompany/companyList";
	}

	@RequestMapping(value = "/sub/company/put", method = RequestMethod.GET)
	public String companyPut(Map<String, Object> model, Theme theme) {
		Company company = new Company();
		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("themeList", themeList);
		model.put("company", company);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "subcompany/companyPut";
	}

	@RequestMapping(value = "/sub/company/put", method = RequestMethod.POST)
	public String companyPutPost(Map<String, Object> model, @Valid Company company,
			MultipartHttpServletRequest multiRequest, HttpServletRequest request, SessionStatus status) {
		logger.debug("]-------------]companyPutPost[-------------[ {}", company);
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		if (logininfo == null) {
			return "redirect:/login";
		}
		int user_id = logininfo.getUserInfo().getId();
		logger.debug("]-------------]company user_id[-------------[ {}", user_id);
		company.setUser_id(user_id);
		company.setMain_view("N");
		company.setUse_at("N");
		company.setSeason_off("N");
		companyService.putCompany(company);
		status.setComplete();

		model.put("company", company);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "redirect:/sub/company/list/1";
	}

	@RequestMapping(value = { "/sub/company/{pageIndex}/{id}",
			"/sub/company/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String companyGet(Map<String, Object> model, Company company, Theme theme, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, HttpServletRequest request) {
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		if (logininfo == null) {
			return "redirect:/login";
		}
		int user_id = logininfo.getUserInfo().getId();
		logger.debug("]-------------]company user_id[-------------[ {}", user_id);
		company.setUser_id(user_id);
		company.setId(id);
		Company companyRes = companyService.getCompany(company);
		logger.debug("===========]companyRes[=========== {}", companyRes);
		model.put("companyRes", companyRes);

		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("themeList", themeList);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "subcompany/companySet";
	}

	@RequestMapping(value = { "/sub/company/copy/{pageIndex}/{id}" }, method = RequestMethod.GET)
	public String companyGetCopy(Map<String, Object> model, Company company, Theme theme, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables, HttpServletRequest request) {
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		if (logininfo == null) {
			return "redirect:/login";
		}
		int user_id = logininfo.getUserInfo().getId();
		logger.debug("]-------------]company user_id[-------------[ {}", user_id);
		company.setUser_id(user_id);
		company.setId(id);
		Company companyRes = companyService.getCompany(company);
		logger.debug("===========]companyRes[=========== {}", companyRes);
		model.put("companyRes", companyRes);

		Collection<Theme> themeList = themeService.getThemeListAll(theme);
		model.put("themeList", themeList);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		return "subcompany/companySetCopy";
	}

	@RequestMapping(value = { "/sub/company/set/{pageIndex}/{id}",
			"/sub/company/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String companySet(Map<String, Object> model, Company company, @PathVariable int id,
			HttpServletRequest request, @PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) throws Exception {
		logger.debug("========title======== {}", request.getParameter("title"));
		logger.debug("================ {}", company);
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		if (logininfo == null) {
			return "redirect:/login";
		}
		int user_id = logininfo.getUserInfo().getId();
		logger.debug("]-------------]company user_id[-------------[ {}", user_id);
		company.setUser_id(user_id);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		company.setMain_view("N");
		company.setUse_at("N");
		company.setSeason_off("N");
		companyService.setCompany(company);
		status.setComplete();

		company.setPageIndex(pageIndex);
		model.put("sideMenu", "2");
		model.put("sideMenuSub", "1");
		if (StringUtils.isNotEmpty(searchVal)) {
			company.setSearchKey(searchKey);
			company.setSearchVal(searchVal);
			model.put("company", company);
			return "redirect:/sub/company/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("company", company);
			return "redirect:/sub/company/" + pageIndex + "/" + id;
		}
	}

	@RequestMapping(value = "/admin/today/compExcelUpload", method = RequestMethod.POST)
	public String excelUpload(MultipartHttpServletRequest req, HttpServletRequest request) throws ParseException {

		MultipartFile file = req.getFile("excel");

		ArrayList<Company> companyList = new ArrayList<>();
		Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		if (logininfo == null) {
			return "redirect:/login";
		}
		int user_id = logininfo.getUserInfo().getId();

		if (file != null && file.getSize() > 0) {
			try {
				Workbook wb = new HSSFWorkbook(file.getInputStream());
				Sheet sheet = wb.getSheetAt(0);

				int last = sheet.getLastRowNum();
				System.out.println("Last : " + last);
				String headstore = "N";
				int theme_id = 0;
				String lat = "";
				String lon = "";
				int position = 1;
				String year = "2016";
				String main_view = "N";
				String use_at = "N";
				int parent_id = 0;
				String image1_wl = "";
				String image1_ws = "";
				String image2_wl = "";
				String image2_ws = "";
				String image3_wl = "";
				String image3_ws = "";

				String image_main = "";
				String image_list = "";
				String season_off = "N";

				String ko_locale = "";
				String ko_company_name = "";
				String ko_branch_name = "";
				String ko_benefit = "";
				String ko_conditions = "";
				String ko_working_hour = "";
				String ko_rest_day = "";
				String ko_phone_number = "";
				String ko_homepage = "";
				String ko_items = "";
				String ko_descs = "";
				String ko_first_address = "";
				String ko_middle_address = "";
				String ko_last_address = "";
				String ko_view_yn = "";

				String en_locale = "";
				String en_company_name = "";
				String en_branch_name = "";
				String en_benefit = "";
				String en_conditions = "";
				String en_working_hour = "";
				String en_rest_day = "";
				String en_phone_number = "";
				String en_homepage = "";
				String en_items = "";
				String en_descs = "";
				String en_first_address = "";
				String en_middle_address = "";
				String en_last_address = "";
				String en_view_yn = "";

				String jp_locale = "";
				String jp_company_name = "";
				String jp_branch_name = "";
				String jp_benefit = "";
				String jp_conditions = "";
				String jp_working_hour = "";
				String jp_rest_day = "";
				String jp_phone_number = "";
				String jp_homepage = "";
				String jp_items = "";
				String jp_descs = "";
				String jp_first_address = "";
				String jp_middle_address = "";
				String jp_last_address = "";
				String jp_view_yn = "";

				String cn_locale = "";
				String cn_company_name = "";
				String cn_branch_name = "";
				String cn_benefit = "";
				String cn_conditions = "";
				String cn_working_hour = "";
				String cn_rest_day = "";
				String cn_phone_number = "";
				String cn_homepage = "";
				String cn_items = "";
				String cn_descs = "";
				String cn_first_address = "";
				String cn_middle_address = "";
				String cn_last_address = "";
				String cn_view_yn = "";

				String tw_locale = "";
				String tw_company_name = "";
				String tw_branch_name = "";
				String tw_benefit = "";
				String tw_conditions = "";
				String tw_working_hour = "";
				String tw_rest_day = "";
				String tw_phone_number = "";
				String tw_homepage = "";
				String tw_items = "";
				String tw_descs = "";
				String tw_first_address = "";
				String tw_middle_address = "";
				String tw_last_address = "";
				String tw_view_yn = "";

				for (int i = 1; i <= last; i++) {
					Row row = sheet.getRow(i);

					lat = row.getCell(0, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					lon = row.getCell(1, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					image1_wl = row.getCell(2, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					image1_ws = row.getCell(3, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					image2_wl = row.getCell(4, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					image2_ws = row.getCell(5, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					image3_wl = row.getCell(6, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					image3_ws = row.getCell(7, Row.CREATE_NULL_AS_BLANK).getStringCellValue();

					image_main = row.getCell(8, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					image_list = row.getCell(9, Row.CREATE_NULL_AS_BLANK).getStringCellValue();

					ko_locale = row.getCell(10, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_company_name = row.getCell(11, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_branch_name = row.getCell(12, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_benefit = row.getCell(13, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_conditions = row.getCell(14, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_working_hour = row.getCell(15, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_rest_day = row.getCell(16, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_phone_number = row.getCell(17, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_homepage = row.getCell(18, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_items = row.getCell(19, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_descs = row.getCell(20, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_first_address = row.getCell(21, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_middle_address = row.getCell(22, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_last_address = row.getCell(23, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					ko_view_yn = row.getCell(24, Row.CREATE_NULL_AS_BLANK).getStringCellValue();

					en_locale = row.getCell(25, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_company_name = row.getCell(26, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_branch_name = row.getCell(27, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_benefit = row.getCell(28, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_conditions = row.getCell(29, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_working_hour = row.getCell(30, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_rest_day = row.getCell(31, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_phone_number = row.getCell(32, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_homepage = row.getCell(33, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_items = row.getCell(34, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_descs = row.getCell(35, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_first_address = row.getCell(36, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_middle_address = row.getCell(37, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_last_address = row.getCell(38, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					en_view_yn = row.getCell(39, Row.CREATE_NULL_AS_BLANK).getStringCellValue();

					jp_locale = row.getCell(40, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_company_name = row.getCell(41, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_branch_name = row.getCell(42, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_benefit = row.getCell(43, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_conditions = row.getCell(44, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_working_hour = row.getCell(45, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_rest_day = row.getCell(46, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_phone_number = row.getCell(47, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_homepage = row.getCell(48, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_items = row.getCell(49, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_descs = row.getCell(50, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_first_address = row.getCell(51, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_middle_address = row.getCell(52, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_last_address = row.getCell(53, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					jp_view_yn = row.getCell(54, Row.CREATE_NULL_AS_BLANK).getStringCellValue();

					cn_locale = row.getCell(55, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_company_name = row.getCell(56, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_branch_name = row.getCell(57, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_benefit = row.getCell(58, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_conditions = row.getCell(59, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_working_hour = row.getCell(60, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_rest_day = row.getCell(61, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_phone_number = row.getCell(62, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_homepage = row.getCell(63, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_items = row.getCell(64, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_descs = row.getCell(65, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_first_address = row.getCell(67, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_middle_address = row.getCell(68, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_last_address = row.getCell(69, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					cn_view_yn = row.getCell(70, Row.CREATE_NULL_AS_BLANK).getStringCellValue();

					tw_locale = row.getCell(71, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_company_name = row.getCell(72, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_branch_name = row.getCell(73, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_benefit = row.getCell(74, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_conditions = row.getCell(75, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_working_hour = row.getCell(76, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_rest_day = row.getCell(77, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_phone_number = row.getCell(78, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_homepage = row.getCell(79, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_items = row.getCell(80, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_descs = row.getCell(81, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_first_address = row.getCell(82, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_middle_address = row.getCell(83, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_last_address = row.getCell(84, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
					tw_view_yn = row.getCell(85, Row.CREATE_NULL_AS_BLANK).getStringCellValue();

					Company company = new Company();

					company.setParent_id(parent_id);
					company.setHeadstore(headstore);
					company.setUser_id(user_id);
					company.setTheme_id(theme_id);
					company.setLat(lat);
					company.setLon(lon);
					company.setPosition(position);
					company.setYear(year);
					company.setMain_view(main_view);
					company.setUse_at(use_at);

					company.setImage1_wl(image1_wl);
					company.setImage1_ws(image1_ws);
					company.setImage2_wl(image2_wl);
					company.setImage2_ws(image2_ws);
					company.setImage3_wl(image3_wl);
					company.setImage3_ws(image3_ws);
					company.setImage_main(image_main);
					company.setImage_list(image_list);

					company.setSeason_off(season_off);

					CompanyLocale company_ko = new CompanyLocale();

					CompanyLocale company_en = new CompanyLocale();
					CompanyLocale company_jp = new CompanyLocale();
					CompanyLocale company_cn = new CompanyLocale();
					CompanyLocale company_tw = new CompanyLocale();

					company_ko.setLocale(ko_locale);
					company_ko.setCompany_name(ko_company_name);
					company_ko.setBranch_name(ko_branch_name);
					company_ko.setBenefit(ko_benefit);
					company_ko.setConditions(ko_conditions);
					company_ko.setWorking_hour(ko_working_hour);
					company_ko.setRest_day(ko_rest_day);
					company_ko.setPhone_number(ko_phone_number);
					company_ko.setHomepage(ko_homepage);
					company_ko.setItems(ko_items);
					company_ko.setDescs(ko_descs);
					company_ko.setFirst_address(ko_first_address);
					company_ko.setMiddle_address(ko_middle_address);
					company_ko.setLast_address(ko_last_address);
					company_ko.setView_yn(ko_view_yn);

					company_en.setLocale(en_locale);
					company_en.setCompany_name(en_company_name);
					company_en.setBranch_name(en_branch_name);
					company_en.setBenefit(en_benefit);
					company_en.setConditions(en_conditions);
					company_en.setWorking_hour(en_working_hour);
					company_en.setRest_day(en_rest_day);
					company_en.setPhone_number(en_phone_number);
					company_en.setHomepage(en_homepage);
					company_en.setItems(en_items);
					company_en.setDescs(en_descs);
					company_en.setFirst_address(en_first_address);
					company_en.setMiddle_address(en_middle_address);
					company_en.setLast_address(en_last_address);
					company_en.setView_yn(en_view_yn);

					company_jp.setLocale(jp_locale);
					company_jp.setCompany_name(jp_company_name);
					company_jp.setBranch_name(jp_branch_name);
					company_jp.setBenefit(jp_benefit);
					company_jp.setConditions(jp_conditions);
					company_jp.setWorking_hour(jp_working_hour);
					company_jp.setRest_day(jp_rest_day);
					company_jp.setPhone_number(jp_phone_number);
					company_jp.setHomepage(jp_homepage);
					company_jp.setItems(jp_items);
					company_jp.setDescs(jp_descs);
					company_jp.setFirst_address(jp_first_address);
					company_jp.setMiddle_address(jp_middle_address);
					company_jp.setLast_address(jp_last_address);
					company_jp.setView_yn(jp_view_yn);

					company_cn.setLocale(cn_locale);
					company_cn.setCompany_name(cn_company_name);
					company_cn.setBranch_name(cn_branch_name);
					company_cn.setBenefit(cn_benefit);
					company_cn.setConditions(cn_conditions);
					company_cn.setWorking_hour(cn_working_hour);
					company_cn.setRest_day(cn_rest_day);
					company_cn.setPhone_number(cn_phone_number);
					company_cn.setHomepage(cn_homepage);
					company_cn.setItems(cn_items);
					company_cn.setDescs(cn_descs);
					company_cn.setFirst_address(cn_first_address);
					company_cn.setMiddle_address(cn_middle_address);
					company_cn.setLast_address(cn_last_address);
					company_cn.setView_yn(cn_view_yn);

					company_tw.setLocale(tw_locale);
					company_tw.setCompany_name(tw_company_name);
					company_tw.setBranch_name(tw_branch_name);
					company_tw.setBenefit(tw_benefit);
					company_tw.setConditions(tw_conditions);
					company_tw.setWorking_hour(tw_working_hour);
					company_tw.setRest_day(tw_rest_day);
					company_tw.setPhone_number(tw_phone_number);
					company_tw.setHomepage(tw_homepage);
					company_tw.setItems(tw_items);
					company_tw.setDescs(tw_descs);
					company_tw.setFirst_address(tw_first_address);
					company_tw.setMiddle_address(tw_middle_address);
					company_tw.setLast_address(tw_last_address);
					company_tw.setView_yn(tw_view_yn);

					company.getCompanyLocales().add(company_ko);
					company.getCompanyLocales().add(company_en);
					company.getCompanyLocales().add(company_jp);
					company.getCompanyLocales().add(company_cn);
					company.getCompanyLocales().add(company_tw);
					companyList.add(company);
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		logger.debug("]-------------]company companyList[-------------[ {}", companyList);

		return "jsonView";

	}

}
