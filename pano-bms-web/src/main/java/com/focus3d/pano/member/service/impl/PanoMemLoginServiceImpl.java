package com.focus3d.pano.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.member.dao.PanoMemLoginDao;
import com.focus3d.pano.member.service.PanoMemLoginService;
import com.focus3d.pano.model.PanoMemLoginModel;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoMemLoginServiceImpl extends CommonServiceImpl<PanoMemLoginModel> implements PanoMemLoginService<PanoMemLoginModel> {
	@Autowired
	private PanoMemLoginDao memLoginDao;
	@Override
	public CommonDao<PanoMemLoginModel> getDao() {
		return memLoginDao;
	}

}
