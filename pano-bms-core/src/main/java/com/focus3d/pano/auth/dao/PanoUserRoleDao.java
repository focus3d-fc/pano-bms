package com.focus3d.pano.auth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoUserRoleModel;
import com.focus3d.pano.model.ibator.PanoBmUserRoleCriteria;
/**
 *
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class PanoUserRoleDao extends CommonDao<PanoUserRoleModel> {
	/**
	 *
	 * *
	 * @param userId
	 * @return
	 */
	public List<PanoUserRoleModel> getListByUserId(Long userId) {
		PanoBmUserRoleCriteria criteria = new PanoBmUserRoleCriteria();
		criteria.createCriteria().andUserSnEqualTo(userId);
		return selectByCriteria(criteria, PanoUserRoleModel.class);
	}
	/**
	 *
	 * *
	 * @param userSn
	 */
	public void deleteByUserSn(long userSn){
		PanoBmUserRoleCriteria criteria = new PanoBmUserRoleCriteria();
		criteria.createCriteria().andUserSnEqualTo(userSn);
		deleteByCriteria(criteria);
	}

}
