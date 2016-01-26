
package com.june.app.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Imgs;
import com.june.app.model.FooterBanner;
import com.june.app.repository.FooterBannerRepository;
import com.june.app.service.FooterBannerService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class FooterBannerServiceImpl extends CommonServiceImpl implements FooterBannerService {

	@Autowired
	private FooterBannerRepository footerBannerRepository;

	@Autowired
	private FileMngUtil fileUtil;

	@Override
	@Transactional(readOnly = true)
	public Collection<FooterBanner> getFooterBannerList(FooterBanner footerBanner) throws DataAccessException {
		return footerBannerRepository.getFooterBannerList(footerBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public int getFooterBannerListCnt(FooterBanner footerBanner) throws DataAccessException {
		return footerBannerRepository.getFooterBannerListCnt(footerBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public FooterBanner getFooterBanner(FooterBanner footerBanner) throws DataAccessException {
		return footerBannerRepository.getFooterBanner(footerBanner);
	}

	@Override
	@Transactional
	public void putFooterBanner(FooterBanner footerBanner) throws DataAccessException {
		footerBanner = footerBannerFile(footerBanner);
		logger.debug("]-------------]footerBannerPut before[-------------[ {}", footerBanner);
		footerBannerRepository.putFooterBanner(footerBanner);
		logger.debug("]-------------]footerBannerPut after [-------------[ {}", footerBanner);

	}

	@Override
	@Transactional
	public void setFooterBanner(FooterBanner footerBanner) throws DataAccessException {
		logger.debug("]-------------]setFooterBanner before [-------------[ {}", footerBanner);
		footerBanner = footerBannerFile(footerBanner);
		logger.debug("]-------------]setFooterBanner after [-------------[ {}", footerBanner);
		footerBannerRepository.setFooterBanner(footerBanner);
	}

	@Override
	@Transactional
	public void putImgs(List<Imgs> imgs) throws DataAccessException {
		for (Imgs img : imgs) {
			footerBannerRepository.putImgs(img);
		}
	}

	public FooterBanner footerBannerFile(FooterBanner footerBanner) {
		if (footerBanner.getFile_image_ko() != null) {
			if (!footerBanner.getFile_image_ko().isEmpty()) {
				try {
					String image_ko = fileUtil.parseFileInfCompany(footerBanner.getFile_image_ko(), "footerBanner__ko_", 0,
							"footerBanner");
					logger.debug("===========] call image_ko [============={}", image_ko);
					footerBanner.setImage_ko(image_ko);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (footerBanner.getFile_image_en() != null) {
			if (!footerBanner.getFile_image_en().isEmpty()) {
				try {
					String image_en = fileUtil.parseFileInfCompany(footerBanner.getFile_image_en(), "footerBanner_en_", 0,
							"footerBanner");
					logger.debug("===========] call image_en [============={}", image_en);
					footerBanner.setImage_en(image_en);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (footerBanner.getFile_image_jp() != null) {
			if (!footerBanner.getFile_image_jp().isEmpty()) {
				try {
					String image_jp = fileUtil.parseFileInfCompany(footerBanner.getFile_image_jp(), "footerBanner_jp_", 0,
							"footerBanner");
					footerBanner.setImage_jp(image_jp);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (footerBanner.getFile_image_cn() != null) {
			if (!footerBanner.getFile_image_cn().isEmpty()) {
				try {
					String image_cn = fileUtil.parseFileInfCompany(footerBanner.getFile_image_cn(), "footerBanner_cn_", 0,
							"footerBanner");
					footerBanner.setImage_cn(image_cn);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (footerBanner.getFile_image_tw() != null) {
			if (!footerBanner.getFile_image_tw().isEmpty()) {
				try {
					String image_tw = fileUtil.parseFileInfCompany(footerBanner.getFile_image_tw(), "footerBanner_tw_", 0,
							"footerBanner");
					footerBanner.setImage_tw(image_tw);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		
		return footerBanner;
	}
}