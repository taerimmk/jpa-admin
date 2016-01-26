
package com.june.app.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Imgs;
import com.june.app.model.UpcomingEventsBanner;
import com.june.app.repository.UpcomingEventsBannerRepository;
import com.june.app.service.UpcomingEventsBannerService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class UpcomingEventsBannerServiceImpl extends CommonServiceImpl implements UpcomingEventsBannerService {

	@Autowired
	private UpcomingEventsBannerRepository upcomingEventsBannerRepository;

	@Autowired
	private FileMngUtil fileUtil;

	@Override
	@Transactional(readOnly = true)
	public Collection<UpcomingEventsBanner> getUpcomingEventsBannerList(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException {
		return upcomingEventsBannerRepository.getUpcomingEventsBannerList(upcomingEventsBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public int getUpcomingEventsBannerListCnt(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException {
		return upcomingEventsBannerRepository.getUpcomingEventsBannerListCnt(upcomingEventsBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public UpcomingEventsBanner getUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException {
		return upcomingEventsBannerRepository.getUpcomingEventsBanner(upcomingEventsBanner);
	}

	@Override
	@Transactional
	public void putUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException {
		upcomingEventsBanner = upcomingEventsBannerFile(upcomingEventsBanner);
		logger.debug("]-------------]upcomingEventsBannerPut before[-------------[ {}", upcomingEventsBanner);
		upcomingEventsBannerRepository.putUpcomingEventsBanner(upcomingEventsBanner);
		logger.debug("]-------------]upcomingEventsBannerPut after [-------------[ {}", upcomingEventsBanner);

	}

	@Override
	@Transactional
	public void setUpcomingEventsBanner(UpcomingEventsBanner upcomingEventsBanner) throws DataAccessException {
		logger.debug("]-------------]setUpcomingEventsBanner before [-------------[ {}", upcomingEventsBanner);
		upcomingEventsBanner = upcomingEventsBannerFile(upcomingEventsBanner);
		logger.debug("]-------------]setUpcomingEventsBanner after [-------------[ {}", upcomingEventsBanner);
		upcomingEventsBannerRepository.setUpcomingEventsBanner(upcomingEventsBanner);
	}

	@Override
	@Transactional
	public void putImgs(List<Imgs> imgs) throws DataAccessException {
		for (Imgs img : imgs) {
			upcomingEventsBannerRepository.putImgs(img);
		}
	}

	public UpcomingEventsBanner upcomingEventsBannerFile(UpcomingEventsBanner upcomingEventsBanner) {
		if (upcomingEventsBanner.getFile_image_ko() != null) {
			if (!upcomingEventsBanner.getFile_image_ko().isEmpty()) {
				try {
					String image_ko = fileUtil.parseFileInfCompany(upcomingEventsBanner.getFile_image_ko(), "upcomingEventsBanner__ko_", 0,
							"upcomingEventsBanner");
					logger.debug("===========] call image_ko [============={}", image_ko);
					upcomingEventsBanner.setImage_ko(image_ko);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (upcomingEventsBanner.getFile_image_en() != null) {
			if (!upcomingEventsBanner.getFile_image_en().isEmpty()) {
				try {
					String image_en = fileUtil.parseFileInfCompany(upcomingEventsBanner.getFile_image_en(), "upcomingEventsBanner_en_", 0,
							"upcomingEventsBanner");
					logger.debug("===========] call image_en [============={}", image_en);
					upcomingEventsBanner.setImage_en(image_en);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (upcomingEventsBanner.getFile_image_jp() != null) {
			if (!upcomingEventsBanner.getFile_image_jp().isEmpty()) {
				try {
					String image_jp = fileUtil.parseFileInfCompany(upcomingEventsBanner.getFile_image_jp(), "upcomingEventsBanner_jp_", 0,
							"upcomingEventsBanner");
					upcomingEventsBanner.setImage_jp(image_jp);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (upcomingEventsBanner.getFile_image_cn() != null) {
			if (!upcomingEventsBanner.getFile_image_cn().isEmpty()) {
				try {
					String image_cn = fileUtil.parseFileInfCompany(upcomingEventsBanner.getFile_image_cn(), "upcomingEventsBanner_cn_", 0,
							"upcomingEventsBanner");
					upcomingEventsBanner.setImage_cn(image_cn);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (upcomingEventsBanner.getFile_image_tw() != null) {
			if (!upcomingEventsBanner.getFile_image_tw().isEmpty()) {
				try {
					String image_tw = fileUtil.parseFileInfCompany(upcomingEventsBanner.getFile_image_tw(), "upcomingEventsBanner_tw_", 0,
							"upcomingEventsBanner");
					upcomingEventsBanner.setImage_tw(image_tw);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		
		return upcomingEventsBanner;
	}
}