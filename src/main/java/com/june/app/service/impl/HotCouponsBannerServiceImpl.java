
package com.june.app.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Imgs;
import com.june.app.model.HotCouponsBanner;
import com.june.app.repository.HotCouponsBannerRepository;
import com.june.app.service.HotCouponsBannerService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class HotCouponsBannerServiceImpl extends CommonServiceImpl implements HotCouponsBannerService {

	@Autowired
	private HotCouponsBannerRepository hotCouponsBannerRepository;

	@Autowired
	private FileMngUtil fileUtil;

	@Override
	@Transactional(readOnly = true)
	public Collection<HotCouponsBanner> getHotCouponsBannerList(HotCouponsBanner hotCouponsBanner) throws DataAccessException {
		return hotCouponsBannerRepository.getHotCouponsBannerList(hotCouponsBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public int getHotCouponsBannerListCnt(HotCouponsBanner hotCouponsBanner) throws DataAccessException {
		return hotCouponsBannerRepository.getHotCouponsBannerListCnt(hotCouponsBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public HotCouponsBanner getHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException {
		return hotCouponsBannerRepository.getHotCouponsBanner(hotCouponsBanner);
	}

	@Override
	@Transactional
	public void putHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException {
		hotCouponsBanner = hotCouponsBannerFile(hotCouponsBanner);
		logger.debug("]-------------]hotCouponsBannerPut before[-------------[ {}", hotCouponsBanner);
		hotCouponsBannerRepository.putHotCouponsBanner(hotCouponsBanner);
		logger.debug("]-------------]hotCouponsBannerPut after [-------------[ {}", hotCouponsBanner);

	}

	@Override
	@Transactional
	public void setHotCouponsBanner(HotCouponsBanner hotCouponsBanner) throws DataAccessException {
		logger.debug("]-------------]setHotCouponsBanner before [-------------[ {}", hotCouponsBanner);
		hotCouponsBanner = hotCouponsBannerFile(hotCouponsBanner);
		logger.debug("]-------------]setHotCouponsBanner after [-------------[ {}", hotCouponsBanner);
		hotCouponsBannerRepository.setHotCouponsBanner(hotCouponsBanner);
	}

	@Override
	@Transactional
	public void putImgs(List<Imgs> imgs) throws DataAccessException {
		for (Imgs img : imgs) {
			hotCouponsBannerRepository.putImgs(img);
		}
	}

	public HotCouponsBanner hotCouponsBannerFile(HotCouponsBanner hotCouponsBanner) {
		if (hotCouponsBanner.getFile_image_ko() != null) {
			if (!hotCouponsBanner.getFile_image_ko().isEmpty()) {
				try {
					String image_ko = fileUtil.parseFileInfCompany(hotCouponsBanner.getFile_image_ko(), "hotCouponsBanner__ko_", 0,
							"hotCouponsBanner");
					logger.debug("===========] call image_ko [============={}", image_ko);
					hotCouponsBanner.setImage_ko(image_ko);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (hotCouponsBanner.getFile_image_en() != null) {
			if (!hotCouponsBanner.getFile_image_en().isEmpty()) {
				try {
					String image_en = fileUtil.parseFileInfCompany(hotCouponsBanner.getFile_image_en(), "hotCouponsBanner_en_", 0,
							"hotCouponsBanner");
					logger.debug("===========] call image_en [============={}", image_en);
					hotCouponsBanner.setImage_en(image_en);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (hotCouponsBanner.getFile_image_jp() != null) {
			if (!hotCouponsBanner.getFile_image_jp().isEmpty()) {
				try {
					String image_jp = fileUtil.parseFileInfCompany(hotCouponsBanner.getFile_image_jp(), "hotCouponsBanner_jp_", 0,
							"hotCouponsBanner");
					hotCouponsBanner.setImage_jp(image_jp);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (hotCouponsBanner.getFile_image_cn() != null) {
			if (!hotCouponsBanner.getFile_image_cn().isEmpty()) {
				try {
					String image_cn = fileUtil.parseFileInfCompany(hotCouponsBanner.getFile_image_cn(), "hotCouponsBanner_cn_", 0,
							"hotCouponsBanner");
					hotCouponsBanner.setImage_cn(image_cn);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (hotCouponsBanner.getFile_image_tw() != null) {
			if (!hotCouponsBanner.getFile_image_tw().isEmpty()) {
				try {
					String image_tw = fileUtil.parseFileInfCompany(hotCouponsBanner.getFile_image_tw(), "hotCouponsBanner_tw_", 0,
							"hotCouponsBanner");
					hotCouponsBanner.setImage_tw(image_tw);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		
		return hotCouponsBanner;
	}
}