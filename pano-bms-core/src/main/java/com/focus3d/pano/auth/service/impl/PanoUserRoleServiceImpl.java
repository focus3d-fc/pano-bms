package com.focus3d.pano.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.auth.dao.PanoUserRoleDao;
import com.focus3d.pano.auth.service.PanoUserRoleService;
import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.model.PanoUserRoleModel;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoUserRoleServiceImpl extends CommonServiceImpl<PanoUserRoleModel> implements PanoUserRoleService<PanoUserRoleModel> {
	@Autowired
	private PanoUserRoleDao userRoleDao;
	@Override
	public CommonDao<PanoUserRoleModel> getDao() {
		return userRoleDao;
	}
	@Override
	public List<PanoUserRoleModel> listByUserId(Long userId) {
		return userRoleDao.getListByUserId(userId);
	}

}
