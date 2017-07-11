package com.focus3d.pano.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.login.dao.PanoLoginDao;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.PanoUserModel;
import com.focus3d.pano.model.PanoValidateModel;
import com.focus3d.pano.rm.PanoRpcUtils;
import com.focus3d.pano.user.dao.PanoUserDao;
import com.focus3d.pano.user.service.PanoUserService;
import com.focus3d.pano.validate.dao.PanoValidateDao;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.MD5Util;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoUserServiceImpl extends CommonServiceImpl<PanoUserModel> implements PanoUserService<PanoUserModel> {
	@Autowired
	private PanoUserDao userDao;
	@Autowired
	private PanoLoginDao loginDao;
	@Autowired
	private PanoValidateDao validateDao;
	@Value("${rpc.fs.domain}")
	private String rpcFsDomain;
	@Override
	public CommonDao<PanoUserModel> getDao() {
		return userDao;
	}

	@Override
	public PanoUserModel getByMobile(String mobile) {
		return userDao.getByMobile(mobile);
	}

	@Override
	public void register(PanoUserModel user, PanoValidateModel validate) {
		userDao.insert(user);
		//创建账户
		PanoLoginModel loginModel = new PanoLoginModel();
		loginModel.setUserSn(user.getSn());
		loginModel.setLoginName(user.getLogin().getLoginName());
		loginModel.setPassword(MD5Util.MD5Encode(user.getLogin().getPassword(), ""));
		loginModel.setStatus(1);
		loginDao.insert(loginModel);
		validate.setStatus(0);
		validateDao.updateByKeySelective(validate);
		//分配用户空间
		//String token = defaultEncryptService.encrypt(EncryptUtil.encode(user.getSn()), null);
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		qparams.add(new BasicNameValuePair("userToken", EncryptUtil.encode(user.getSn())));
		PanoRpcUtils panoRpcUtils = new PanoRpcUtils();
		String rv = panoRpcUtils.httpRequest(rpcFsDomain + "/pano/prm/user_space_allocate", qparams, HttpMethod.POST);
		JSONObject rpcJo = JSONObject.fromObject(rv);
		if("1".equals(rpcJo.getString("status"))){
			user.setIsAllocateSpace(1);
			userDao.updateByKeySelective(user);
		}
	}

}
