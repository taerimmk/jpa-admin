
package com.june.app.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Imgs;
import com.june.app.model.MainBanner;
import com.june.app.repository.MainBannerRepository;
import com.june.app.service.MainBannerService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class MainBannerServiceImpl extends CommonServiceImpl implements MainBannerService {

	@Autowired
	private MainBannerRepository mainBannerRepository;

	@Autowired
	private FileMngUtil fileUtil;

	@Override
	@Transactional(readOnly = true)
	public Collection<MainBanner> getMainBannerList(MainBanner mainBanner) throws DataAccessException {
		return mainBannerRepository.getMainBannerList(mainBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public int getMainBannerListCnt(MainBanner mainBanner) throws DataAccessException {
		return mainBannerRepository.getMainBannerListCnt(mainBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public MainBanner getMainBanner(MainBanner mainBanner) throws DataAccessException {
		return mainBannerRepository.getMainBanner(mainBanner);
	}

	@Override
	@Transactional
	public void putMainBanner(MainBanner mainBanner) throws DataAccessException {
		mainBanner = mainBannerFile(mainBanner);
		logger.debug("]-------------]mainBannerPut before[-------------[ {}", mainBanner);
		mainBannerRepository.putMainBanner(mainBanner);
		logger.debug("]-------------]mainBannerPut after [-------------[ {}", mainBanner);

	}

	@Override
	@Transactional
	public void setMainBanner(MainBanner mainBanner) throws DataAccessException {
		logger.debug("]-------------]setMainBanner before [-------------[ {}", mainBanner);
		mainBanner = mainBannerFile(mainBanner);
		logger.debug("]-------------]setMainBanner after [-------------[ {}", mainBanner);
		mainBannerRepository.setMainBanner(mainBanner);
	}

	@Override
	@Transactional
	public void putImgs(List<Imgs> imgs) throws DataAccessException {
		for (Imgs img : imgs) {
			mainBannerRepository.putImgs(img);
		}
	}

	public MainBanner mainBannerFile(MainBanner mainBanner) {
		if (mainBanner.getFile_image_ko() != null) {
			if (!mainBanner.getFile_image_ko().isEmpty()) {
				try {
					String image_ko = fileUtil.parseFileInfCompany(mainBanner.getFile_image_ko(), "mainBanner__ko_", 0,
							"mainBanner");
					logger.debug("===========] call image_ko [============={}", image_ko);
					mainBanner.setImage_ko(image_ko);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (mainBanner.getFile_image_en() != null) {
			if (!mainBanner.getFile_image_en().isEmpty()) {
				try {
					String image_en = fileUtil.parseFileInfCompany(mainBanner.getFile_image_en(), "mainBanner_en_", 0,
							"mainBanner");
					logger.debug("===========] call image_en [============={}", image_en);
					mainBanner.setImage_en(image_en);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (mainBanner.getFile_image_jp() != null) {
			if (!mainBanner.getFile_image_jp().isEmpty()) {
				try {
					String image_jp = fileUtil.parseFileInfCompany(mainBanner.getFile_image_jp(), "mainBanner_jp_", 0,
							"mainBanner");
					mainBanner.setImage_jp(image_jp);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (mainBanner.getFile_image_cn() != null) {
			if (!mainBanner.getFile_image_cn().isEmpty()) {
				try {
					String image_cn = fileUtil.parseFileInfCompany(mainBanner.getFile_image_cn(), "mainBanner_cn_", 0,
							"mainBanner");
					mainBanner.setImage_cn(image_cn);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (mainBanner.getFile_image_tw() != null) {
			if (!mainBanner.getFile_image_tw().isEmpty()) {
				try {
					String image_tw = fileUtil.parseFileInfCompany(mainBanner.getFile_image_tw(), "mainBanner_tw_", 0,
							"mainBanner");
					mainBanner.setImage_tw(image_tw);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		
		return mainBanner;
	}
}