package com.focus3d.pano.login.dao;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.ibator.PanoBmLoginCriteria;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Repository
public class PanoLoginDao extends CommonDao<PanoLoginModel> {
	/**
	 * 
	 * *
	 * @param loginName
	 * @return
	 */
	public PanoLoginModel getByName(String loginName) {
		PanoBmLoginCriteria criteria = new PanoBmLoginCriteria();
		criteria.createCriteria().andLoginNameEqualTo(loginName);
		return selectFirstByExample(criteria, PanoLoginModel.class);
		
	}

}
