package com.focus3d.pano.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.login.dao.PanoLoginDao;
import com.focus3d.pano.login.service.PanoLoginService;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.PanoUserModel;
import com.focus3d.pano.user.dao.PanoUserDao;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoLoginServiceImpl extends CommonServiceImpl<PanoLoginModel> implements PanoLoginService<PanoLoginModel> {
	@Autowired
	private PanoLoginDao panoLoginDao;
	@Autowired
	private PanoUserDao panoUserDao;
	@Override
	public CommonDao<PanoLoginModel> getDao() {
		return panoLoginDao;
	}
	@Override
	public PanoLoginModel getByName(String loginName) {
		PanoLoginModel login = panoLoginDao.getByName(loginName);
		if(login != null){
			PanoUserModel user = panoUserDao.getBySn(login.getUserSn());
			login.setUser(user);
		}
		return login;
	}

}
