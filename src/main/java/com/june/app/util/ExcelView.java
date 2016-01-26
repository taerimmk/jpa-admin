package com.june.app.util;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.june.app.model.Company;
import com.june.app.model.CompanyLocale;
import com.june.app.model.UserInfo;

public class ExcelView extends AbstractXlsView {

	private Logger logger = LoggerFactory.getLogger(ExcelView.class);

	@Override
	protected void buildExcelDocument(Map<String, Object> ModelMap, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String excelName = ModelMap.get("target").toString();
		Sheet worksheet = null;
		Row row = null;
		if (excelName.equals("companyList")) {
			excelName = URLEncoder.encode("company", "UTF-8");
			worksheet = workbook.createSheet(excelName + " WorkSheet");
			@SuppressWarnings("unchecked")
			List<Company> list = (List<Company>) ModelMap.get("excelList");
			row = worksheet.createRow(0);
			row.createCell(0).setCellValue("순번");

			row.createCell(1).setCellValue("기업명(ko)");
			row.createCell(2).setCellValue("지점명(ko)");
			row.createCell(3).setCellValue("혜택(ko)");
			row.createCell(4).setCellValue("할인내용(ko)");
			row.createCell(5).setCellValue("영업시간(ko)");
			row.createCell(6).setCellValue("휴뮤일(ko)");
			row.createCell(7).setCellValue("연락처(ko)");
			row.createCell(8).setCellValue("홈페이지(ko)");
			row.createCell(9).setCellValue("판매품목(ko)");
			row.createCell(10).setCellValue("시/도(ko)");
			row.createCell(11).setCellValue("구/군(ko)");
			row.createCell(12).setCellValue("상세주소(ko)");
			row.createCell(13).setCellValue("기업설명(ko)");

			row.createCell(14).setCellValue("기업명(en)");
			row.createCell(15).setCellValue("지점명(en)");
			row.createCell(16).setCellValue("혜택(en)");
			row.createCell(17).setCellValue("할인내용(en)");
			row.createCell(18).setCellValue("영업시간(en)");
			row.createCell(19).setCellValue("휴뮤일(en)");
			row.createCell(20).setCellValue("연락처(en)");
			row.createCell(21).setCellValue("홈페이지(en)");
			row.createCell(22).setCellValue("판매품목(en)");
			row.createCell(23).setCellValue("시/도(en)");
			row.createCell(24).setCellValue("구/군(en)");
			row.createCell(25).setCellValue("상세주소(en)");
			row.createCell(26).setCellValue("기업설명(en)");

			row.createCell(27).setCellValue("기업명(jp)");
			row.createCell(28).setCellValue("지점명(jp)");
			row.createCell(29).setCellValue("혜택(jp)");
			row.createCell(30).setCellValue("할인내용(jp)");
			row.createCell(31).setCellValue("영업시간(jp)");
			row.createCell(32).setCellValue("휴뮤일(jp)");
			row.createCell(33).setCellValue("연락처(jp)");
			row.createCell(34).setCellValue("홈페이지(jp)");
			row.createCell(35).setCellValue("판매품목(jp)");
			row.createCell(36).setCellValue("시/도(jp)");
			row.createCell(37).setCellValue("구/군(jp)");
			row.createCell(38).setCellValue("상세주소(jp)");
			row.createCell(39).setCellValue("기업설명(jp)");

			row.createCell(40).setCellValue("기업명(cn)");
			row.createCell(41).setCellValue("지점명(cn)");
			row.createCell(42).setCellValue("혜택(cn)");
			row.createCell(43).setCellValue("할인내용(cn)");
			row.createCell(44).setCellValue("영업시간(cn)");
			row.createCell(45).setCellValue("휴뮤일(cn)");
			row.createCell(46).setCellValue("연락처(cn)");
			row.createCell(47).setCellValue("홈페이지(cn)");
			row.createCell(48).setCellValue("판매품목(cn)");
			row.createCell(49).setCellValue("시/도(cn)");
			row.createCell(50).setCellValue("구/군(cn)");
			row.createCell(51).setCellValue("상세주소(cn)");
			row.createCell(52).setCellValue("기업설명(cn)");

			row.createCell(53).setCellValue("기업명(tw)");
			row.createCell(54).setCellValue("지점명(tw)");
			row.createCell(55).setCellValue("혜택(tw)");
			row.createCell(56).setCellValue("할인내용(tw)");
			row.createCell(57).setCellValue("영업시간(tw)");
			row.createCell(58).setCellValue("휴뮤일(tw)");
			row.createCell(59).setCellValue("연락처(tw)");
			row.createCell(60).setCellValue("홈페이지(tw)");
			row.createCell(61).setCellValue("판매품목(tw)");
			row.createCell(62).setCellValue("시/도(tw)");
			row.createCell(63).setCellValue("구/군(tw)");
			row.createCell(64).setCellValue("상세주소(tw)");
			row.createCell(65).setCellValue("기업설명(tw)");

			for (int i = 1; i < list.size() + 1; i++) {
				row = worksheet.createRow(i);
				row.createCell(0).setCellValue(list.get(i - 1).getId());

				for (CompanyLocale obj : list.get(i - 1).getCompanyLocales()) {
					if ("ko".equals(obj.getLocale())) {
						row.createCell(1).setCellValue(obj.getCompany_name());
						row.createCell(2).setCellValue(obj.getBranch_name());
						row.createCell(3).setCellValue(obj.getBenefit());
						row.createCell(4).setCellValue(obj.getConditions());
						row.createCell(5).setCellValue(obj.getWorking_hour());
						row.createCell(6).setCellValue(obj.getRest_day());
						row.createCell(7).setCellValue(obj.getPhone_number());
						row.createCell(8).setCellValue(obj.getHomepage());
						row.createCell(9).setCellValue(obj.getItems());
						row.createCell(10).setCellValue(obj.getFirst_address());
						row.createCell(11).setCellValue(obj.getMiddle_address());
						row.createCell(12).setCellValue(obj.getLast_address());
						row.createCell(13).setCellValue(obj.getDescs());
					} else if ("en".equals(obj.getLocale())) {
						row.createCell(14).setCellValue(obj.getCompany_name());
						row.createCell(15).setCellValue(obj.getBranch_name());
						row.createCell(16).setCellValue(obj.getBenefit());
						row.createCell(17).setCellValue(obj.getConditions());
						row.createCell(18).setCellValue(obj.getWorking_hour());
						row.createCell(19).setCellValue(obj.getRest_day());
						row.createCell(20).setCellValue(obj.getPhone_number());
						row.createCell(21).setCellValue(obj.getHomepage());
						row.createCell(22).setCellValue(obj.getItems());
						row.createCell(23).setCellValue(obj.getFirst_address());
						row.createCell(24).setCellValue(obj.getMiddle_address());
						row.createCell(25).setCellValue(obj.getLast_address());
						row.createCell(26).setCellValue(obj.getDescs());
					} else if ("jp".equals(obj.getLocale())) {
						row.createCell(27).setCellValue(obj.getCompany_name());
						row.createCell(28).setCellValue(obj.getBranch_name());
						row.createCell(29).setCellValue(obj.getBenefit());
						row.createCell(30).setCellValue(obj.getConditions());
						row.createCell(31).setCellValue(obj.getWorking_hour());
						row.createCell(32).setCellValue(obj.getRest_day());
						row.createCell(33).setCellValue(obj.getPhone_number());
						row.createCell(34).setCellValue(obj.getHomepage());
						row.createCell(35).setCellValue(obj.getItems());
						row.createCell(36).setCellValue(obj.getFirst_address());
						row.createCell(37).setCellValue(obj.getMiddle_address());
						row.createCell(38).setCellValue(obj.getLast_address());
						row.createCell(39).setCellValue(obj.getDescs());
					} else if ("cn".equals(obj.getLocale())) {
						row.createCell(40).setCellValue(obj.getCompany_name());
						row.createCell(41).setCellValue(obj.getBranch_name());
						row.createCell(42).setCellValue(obj.getBenefit());
						row.createCell(43).setCellValue(obj.getConditions());
						row.createCell(44).setCellValue(obj.getWorking_hour());
						row.createCell(45).setCellValue(obj.getRest_day());
						row.createCell(46).setCellValue(obj.getPhone_number());
						row.createCell(47).setCellValue(obj.getHomepage());
						row.createCell(48).setCellValue(obj.getItems());
						row.createCell(49).setCellValue(obj.getFirst_address());
						row.createCell(50).setCellValue(obj.getMiddle_address());
						row.createCell(51).setCellValue(obj.getLast_address());
						row.createCell(52).setCellValue(obj.getDescs());

					} else if ("tw".equals(obj.getLocale())) {
						row.createCell(53).setCellValue(obj.getCompany_name());
						row.createCell(54).setCellValue(obj.getBranch_name());
						row.createCell(55).setCellValue(obj.getBenefit());
						row.createCell(56).setCellValue(obj.getConditions());
						row.createCell(57).setCellValue(obj.getWorking_hour());
						row.createCell(58).setCellValue(obj.getRest_day());
						row.createCell(59).setCellValue(obj.getPhone_number());
						row.createCell(60).setCellValue(obj.getHomepage());
						row.createCell(61).setCellValue(obj.getItems());
						row.createCell(62).setCellValue(obj.getFirst_address());
						row.createCell(63).setCellValue(obj.getMiddle_address());
						row.createCell(64).setCellValue(obj.getLast_address());
						row.createCell(65).setCellValue(obj.getDescs());
					}

				}

			}
		} else if (excelName.equals("userList")) {
			excelName = URLEncoder.encode("user", "UTF-8");
			worksheet = workbook.createSheet(excelName + " WorkSheet");
			@SuppressWarnings("unchecked")
			List<UserInfo> list = (List<UserInfo>) ModelMap.get("excelList");
			row = worksheet.createRow(0);
			row.createCell(0).setCellValue("순번");

			row.createCell(1).setCellValue("기업명)");
			row.createCell(2).setCellValue("아이디");
			row.createCell(3).setCellValue("이름");
			row.createCell(4).setCellValue("연락처");
			row.createCell(5).setCellValue("이메일");
			row.createCell(6).setCellValue("부서");
			row.createCell(7).setCellValue("직책");
			row.createCell(8).setCellValue("휴대폰번호");
			
			for (int i = 1; i < list.size() + 1; i++) {
				row = worksheet.createRow(i);
				row.createCell(0).setCellValue(list.get(i - 1).getId());
				row.createCell(1).setCellValue(list.get(i - 1).getCompany_name());
				row.createCell(2).setCellValue(list.get(i - 1).getUser_id());
				row.createCell(3).setCellValue(list.get(i - 1).getName());
				row.createCell(4).setCellValue(list.get(i - 1).getPhone());
				row.createCell(5).setCellValue(list.get(i - 1).getEmail());
				row.createCell(6).setCellValue(list.get(i - 1).getPart());
				row.createCell(7).setCellValue(list.get(i - 1).getDegree());
				row.createCell(8).setCellValue(list.get(i - 1).getMobile());

			}
		}

		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "ATTachment; Filename=" + excelName + "-excel.xls");
	}
}
