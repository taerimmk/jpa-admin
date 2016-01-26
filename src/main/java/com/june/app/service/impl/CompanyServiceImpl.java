
package com.june.app.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Company;
import com.june.app.model.Imgs;
import com.june.app.repository.CompanyRepository;
import com.june.app.service.CompanyService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class CompanyServiceImpl extends CommonServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private FileMngUtil fileUtil;

	@Override
	@Transactional(readOnly = true)
	public Collection<Company> getCompanyList(Company company) throws DataAccessException {
		return companyRepository.getCompanyList(company);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCompanyListCnt(Company company) throws DataAccessException {
		return companyRepository.getCompanyListCnt(company);
	}

	@Override
	@Transactional(readOnly = true)
	public Company getCompany(Company company) throws DataAccessException {
		return companyRepository.getCompany(company);
	}

	@Override
	@Transactional
	public void putCompany(Company company) throws DataAccessException {
		String fileuuid = UUID.randomUUID().toString().replace("-", "");
		company.setFileuuid(fileuuid);
		company = companyFile(company);
		logger.debug("]-------------]companyPut before[-------------[ {}", company);
		companyRepository.putCompany(company);
		logger.debug("]-------------]companyPut after [-------------[ {}", company);

	}

	@Override
	@Transactional
	public void setCompany(Company company) throws DataAccessException {
		logger.debug("]-------------]setCompany before [-------------[ {}", company);
		company = companyFile(company);
		logger.debug("]-------------]setCompany after [-------------[ {}", company);
		companyRepository.setCompany(company);
	}

	@Override
	@Transactional
	public void putImgs(List<Imgs> imgs) throws DataAccessException {
		for (Imgs img : imgs) {
			companyRepository.putImgs(img);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> getCompanyListAll(Company company) throws DataAccessException {
		return companyRepository.getCompanyListAll(company);
	}

	@Override
	@Transactional(readOnly = true)
	public Company getCompanyCoupon(Company company) throws DataAccessException {
		return companyRepository.getCompanyCoupon(company);
	}

	public Company companyFile(Company company) {
		if (company.getFile_image1_wl() != null) {
			if (!company.getFile_image1_wl().isEmpty()) {
				try {
					String image1_wl = fileUtil.parseFileInfCompany(company.getFile_image1_wl(), "company__w1_", 0,
							"company");
					logger.debug("===========] call image1_wl [============={}", image1_wl);
					company.setImage1_wl(image1_wl);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image2_wl() != null) {
			if (!company.getFile_image2_wl().isEmpty()) {
				try {
					String image2_wl = fileUtil.parseFileInfCompany(company.getFile_image2_wl(), "company_w2_", 0,
							"company");
					logger.debug("===========] call image2_wl [============={}", image2_wl);
					company.setImage2_wl(image2_wl);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image3_wl() != null) {
			if (!company.getFile_image3_wl().isEmpty()) {
				try {
					String image3_wl = fileUtil.parseFileInfCompany(company.getFile_image3_wl(), "company_w3_", 0,
							"company");
					company.setImage3_wl(image3_wl);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (company.getFile_image4_wl() != null) {
			if (!company.getFile_image4_wl().isEmpty()) {
				try {
					String image4_wl = fileUtil.parseFileInfCompany(company.getFile_image4_wl(), "company_w4_", 0,
							"company");
					company.setImage4_wl(image4_wl);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image5_wl() != null) {
			if (!company.getFile_image5_wl().isEmpty()) {
				try {
					String image5_wl = fileUtil.parseFileInfCompany(company.getFile_image5_wl(), "company_w5_", 0,
							"company");
					company.setImage5_wl(image5_wl);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image1_ws() != null) {
			if (!company.getFile_image1_ws().isEmpty()) {
				try {
					String image1_ws = fileUtil.parseFileInfCompany(company.getFile_image1_ws(), "company_s1_", 0,
							"company");
					company.setImage1_ws(image1_ws);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image2_ws() != null) {
			if (!company.getFile_image2_ws().isEmpty()) {
				try {
					String image2_ws = fileUtil.parseFileInfCompany(company.getFile_image2_ws(), "company_s2_", 0,
							"company");
					company.setImage2_ws(image2_ws);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image3_ws() != null) {
			if (!company.getFile_image3_ws().isEmpty()) {
				try {
					String image3_ws = fileUtil.parseFileInfCompany(company.getFile_image3_ws(), "company_s3_", 0,
							"company");
					company.setImage3_ws(image3_ws);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (company.getFile_image4_ws() != null) {
			if (!company.getFile_image4_ws().isEmpty()) {
				try {
					String image4_ws = fileUtil.parseFileInfCompany(company.getFile_image4_ws(), "company_s4_", 0,
							"company");
					company.setImage4_ws(image4_ws);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image5_ws() != null) {
			if (!company.getFile_image5_ws().isEmpty()) {
				try {
					String image5_ws = fileUtil.parseFileInfCompany(company.getFile_image5_ws(), "company_s5_", 0,
							"company");
					company.setImage5_ws(image5_ws);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (company.getFile_image_cp() != null) {
			if (!company.getFile_image_cp().isEmpty()) {
				try {
					String image_cp = fileUtil.parseFileInfCompany(company.getFile_image_cp(), "company_cp_", 0,
							"company");

					company.setImage_cp(image_cp);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image_main() != null) {
			if (!company.getFile_image_main().isEmpty()) {
				try {
					String image_main = fileUtil.parseFileInfCompany(company.getFile_image_main(), "company_main_", 0,
							"company");

					company.setImage_main(image_main);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (company.getFile_image_list() != null) {
			if (!company.getFile_image_list().isEmpty()) {
				try {
					String image_list = fileUtil.parseFileInfCompany(company.getFile_image_list(), "company_list_", 0,
							"company");
					company.setImage_list(image_list);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		return company;
	}
}
