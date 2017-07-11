package com.focus3d.pano.user.dao;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoUserModel;
import com.focus3d.pano.model.ibator.PanoBmUserCriteria;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Repository
public class PanoUserDao extends CommonDao<PanoUserModel>{
	/**
	 * 
	 * *
	 * @param mobile
	 * @return
	 */
	public PanoUserModel getByMobile(String mobile) {
		PanoBmUserCriteria criteria = new PanoBmUserCriteria();
		criteria.createCriteria().andMobileEqualTo(mobile);
		return selectFirstByExample(criteria, PanoUserModel.class);
	}

	
}
