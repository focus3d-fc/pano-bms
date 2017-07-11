package com.focus3d.pano.auth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoRoleModel;
import com.focus3d.pano.model.ibator.PanoBmRoleCriteria;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Repository
public class PanoRoleDao extends CommonDao<PanoRoleModel> {
	/**
	 *
	 * *
	 * @param name
	 * @return
	 */
	public List<PanoRoleModel> getListByParentSn(Long parentSn){
		PanoBmRoleCriteria agentRoleCriteria = new PanoBmRoleCriteria();
		agentRoleCriteria.createCriteria().andParentSnEqualTo(parentSn);
		return selectByCriteria(agentRoleCriteria, PanoRoleModel.class);
	}
}
