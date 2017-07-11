package com.focus3d.pano.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.auth.dao.PanoRoleResourceDao;
import com.focus3d.pano.auth.service.PanoRoleResourceService;
import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.model.PanoRoleResourceModel;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoRoleResourceServiceImpl extends CommonServiceImpl<PanoRoleResourceModel> implements PanoRoleResourceService<PanoRoleResourceModel> {
	@Autowired
	private PanoRoleResourceDao roleResourceDao;
	@Override
	public CommonDao<PanoRoleResourceModel> getDao() {
		return roleResourceDao;
	}
	@Override
	public List<PanoRoleResourceModel> listByRoleId(long roleId) {
		return roleResourceDao.getListByRoleId(roleId);
	}

}
