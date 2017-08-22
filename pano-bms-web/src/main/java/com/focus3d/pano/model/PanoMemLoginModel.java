package com.focus3d.pano.model;

import com.focus3d.pano.common.model.CommonModel;
import com.focus3d.pano.model.ibator.PanoMemLogin;
import com.focus3d.pano.model.ibator.PanoMemLoginCriteria;
/**
 * 
 * *
 * @author lihaijun
 *
 */
public class PanoMemLoginModel extends PanoMemLogin<PanoMemLoginModel, PanoMemLoginCriteria> implements CommonModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String smsCode;
	
	private PanoMemUserModel user;

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public PanoMemUserModel getUser() {
		return user;
	}

	public void setUser(PanoMemUserModel user) {
		this.user = user;
	}

}
