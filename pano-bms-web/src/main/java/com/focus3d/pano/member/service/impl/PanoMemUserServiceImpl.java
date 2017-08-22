package com.focus3d.pano.member.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.member.dao.PanoMemLoginDao;
import com.focus3d.pano.member.dao.PanoMemUserDao;
import com.focus3d.pano.member.service.PanoMemUserService;
import com.focus3d.pano.model.PanoMemLoginModel;
import com.focus3d.pano.model.PanoMemUserModel;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoMemUserServiceImpl extends CommonServiceImpl<PanoMemUserModel> implements PanoMemUserService<PanoMemUserModel> {
	@Autowired
	private PanoMemUserDao memUserDao;
	@Autowired
	private PanoMemLoginDao memLoginDao;
	@Override
	public CommonDao<PanoMemUserModel> getDao() {
		return memUserDao;
	}
	@Override
	public void insertOrUpdate(PanoMemLoginModel memLoginModel, int type) {
		String loginName = memLoginModel.getLoginName();
		PanoMemLoginModel loginModel = memLoginDao.getByLoginName(loginName);
		if(loginModel != null){
			Long userSn = loginModel.getUserSn();
			PanoMemUserModel userModel = memUserDao.getBySn(userSn);
			memLoginModel.setUser(userModel);
		} else {
			PanoMemUserModel userModel = new PanoMemUserModel();
			memUserDao.insertBySystem(userModel);
			Long userSn = userModel.getSn();
			if(userSn != null){
				memLoginModel.setUserSn(userSn);
				memLoginModel.setPassword("-1");
				memLoginModel.setStatus(1);
				memLoginModel.setType(type);
				memLoginModel.setLoginTimes(1);
				memLoginModel.setLastLoginTime(new Date());
				memLoginDao.insertBySystem(memLoginModel);
				memLoginModel.setUser(userModel);
			}
		}
	}

}
