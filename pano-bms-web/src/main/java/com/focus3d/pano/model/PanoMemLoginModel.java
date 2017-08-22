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
	
	private String verifyCode;

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
