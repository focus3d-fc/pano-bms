package com.focus3d.pano.member.dao;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoMemLoginModel;
import com.focus3d.pano.model.ibator.PanoMemLoginCriteria;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Repository
public class PanoMemLoginDao extends CommonDao<PanoMemLoginModel> {
	/**
	 * 
	 * *
	 * @param loginName
	 * @return
	 */
	public PanoMemLoginModel getByLoginName(String loginName){
		PanoMemLoginCriteria criteria = new PanoMemLoginCriteria();
		criteria.createCriteria().andLoginNameEqualTo(loginName);
		return selectFirstByExample(criteria, PanoMemLoginModel.class);
	}
}
