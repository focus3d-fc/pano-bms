package com.focus3d.pano.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.auth.dao.PanoResourceDao;
import com.focus3d.pano.auth.service.PanoResourceService;
import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.model.PanoResourceModel;
/**
 *
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoResourceServiceImpl extends CommonServiceImpl<PanoResourceModel> implements PanoResourceService<PanoResourceModel> {
	@Autowired
	private PanoResourceDao resourceDao;
	@Override
	public CommonDao<PanoResourceModel> getDao() {
		return resourceDao;
	}

}
