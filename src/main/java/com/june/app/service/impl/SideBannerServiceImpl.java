
package com.june.app.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.model.Imgs;
import com.june.app.model.SideBanner;
import com.june.app.repository.SideBannerRepository;
import com.june.app.service.SideBannerService;
import com.june.app.util.FileMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class SideBannerServiceImpl extends CommonServiceImpl implements SideBannerService {

	@Autowired
	private SideBannerRepository sideBannerRepository;

	@Autowired
	private FileMngUtil fileUtil;

	@Override
	@Transactional(readOnly = true)
	public Collection<SideBanner> getSideBannerList(SideBanner sideBanner) throws DataAccessException {
		logger.debug("]-------------]sideBanner.getSearchVal()[-------------[ {}", sideBanner.getSearchVal());
		return sideBannerRepository.getSideBannerList(sideBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public int getSideBannerListCnt(SideBanner sideBanner) throws DataAccessException {
		return sideBannerRepository.getSideBannerListCnt(sideBanner);
	}

	@Override
	@Transactional(readOnly = true)
	public SideBanner getSideBanner(SideBanner sideBanner) throws DataAccessException {
		return sideBannerRepository.getSideBanner(sideBanner);
	}

	@Override
	@Transactional
	public void putSideBanner(SideBanner sideBanner) throws DataAccessException {
		sideBanner = sideBannerFile(sideBanner);
		logger.debug("]-------------]sideBannerPut before[-------------[ {}", sideBanner);
		sideBannerRepository.putSideBanner(sideBanner);
		logger.debug("]-------------]sideBannerPut after [-------------[ {}", sideBanner);

	}

	@Override
	@Transactional
	public void setSideBanner(SideBanner sideBanner) throws DataAccessException {
		logger.debug("]-------------]setSideBanner before [-------------[ {}", sideBanner);
		sideBanner = sideBannerFile(sideBanner);
		logger.debug("]-------------]setSideBanner after [-------------[ {}", sideBanner);
		sideBannerRepository.setSideBanner(sideBanner);
	}

	@Override
	@Transactional
	public void putImgs(List<Imgs> imgs) throws DataAccessException {
		for (Imgs img : imgs) {
			sideBannerRepository.putImgs(img);
		}
	}

	public SideBanner sideBannerFile(SideBanner sideBanner) {
		if (sideBanner.getFile_image_ko() != null) {
			if (!sideBanner.getFile_image_ko().isEmpty()) {
				try {
					String image_ko = fileUtil.parseFileInfCompany(sideBanner.getFile_image_ko(), "sideBanner__ko_", 0,
							"sideBanner");
					logger.debug("===========] call image_ko [============={}", image_ko);
					sideBanner.setImage_ko(image_ko);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (sideBanner.getFile_image_en() != null) {
			if (!sideBanner.getFile_image_en().isEmpty()) {
				try {
					String image_en = fileUtil.parseFileInfCompany(sideBanner.getFile_image_en(), "sideBanner_en_", 0,
							"sideBanner");
					logger.debug("===========] call image_en [============={}", image_en);
					sideBanner.setImage_en(image_en);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (sideBanner.getFile_image_jp() != null) {
			if (!sideBanner.getFile_image_jp().isEmpty()) {
				try {
					String image_jp = fileUtil.parseFileInfCompany(sideBanner.getFile_image_jp(), "sideBanner_jp_", 0,
							"sideBanner");
					sideBanner.setImage_jp(image_jp);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}
		}
		if (sideBanner.getFile_image_cn() != null) {
			if (!sideBanner.getFile_image_cn().isEmpty()) {
				try {
					String image_cn = fileUtil.parseFileInfCompany(sideBanner.getFile_image_cn(), "sideBanner_cn_", 0,
							"sideBanner");
					sideBanner.setImage_cn(image_cn);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		if (sideBanner.getFile_image_tw() != null) {
			if (!sideBanner.getFile_image_tw().isEmpty()) {
				try {
					String image_tw = fileUtil.parseFileInfCompany(sideBanner.getFile_image_tw(), "sideBanner_tw_", 0,
							"sideBanner");
					sideBanner.setImage_tw(image_tw);
				} catch (Exception e) { // TODO Auto-generated catch block
					e.printStackTrace();
					logger.error("===========] call interaction [============={}", e);
				}
			}

		}
		
		return sideBanner;
	}
}