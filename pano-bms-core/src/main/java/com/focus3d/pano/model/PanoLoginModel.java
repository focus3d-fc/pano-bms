package com.focus3d.pano.model;

import com.focus3d.pano.common.model.CommonModel;
import com.focus3d.pano.model.ibator.PanoBmLogin;
import com.focus3d.pano.model.ibator.PanoBmLoginCriteria;
/**
 * 
 * *
 * @author lihaijun
 *
 */
public class PanoLoginModel extends PanoBmLogin<PanoLoginModel, PanoBmLoginCriteria> implements CommonModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String validCode;//验证码
	private String smsCode;//短信验证码
	private String password;
	private String passwordNew;
	private String passwordConfirm;//确认新密码
	private Boolean showValidateCode = false;
	private PanoUserModel user;
	public String getValidCode() {
		return validCode;
	}
	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}
	
	public PanoUserModel getUser() {
		return user;
	}
	public void setUser(PanoUserModel user) {
		this.user = user;
	}
	public Boolean getShowValidateCode() {
		return showValidateCode;
	}
	public void setShowValidateCode(Boolean showValidateCode) {
		this.showValidateCode = showValidateCode;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
}
