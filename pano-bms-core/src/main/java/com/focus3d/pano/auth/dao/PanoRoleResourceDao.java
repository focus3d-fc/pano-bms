package com.focus3d.pano.auth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoRoleResourceModel;
import com.focus3d.pano.model.ibator.PanoBmRoleResourceCriteria;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class PanoRoleResourceDao extends CommonDao<PanoRoleResourceModel> {
	/**
	 *
	 * *
	 * @param roleId
	 * @return
	 */
	public List<PanoRoleResourceModel> getListByRoleId(long roleId) {
		PanoBmRoleResourceCriteria criteria = new PanoBmRoleResourceCriteria();
		criteria.createCriteria().andRoleSnEqualTo(roleId);
		return selectByCriteria(criteria, PanoRoleResourceModel.class);
	}

}
