package com.focus3d.pano.model;

import com.focus3d.pano.common.model.CommonModel;
import com.focus3d.pano.model.ibator.PanoBmUser;
import com.focus3d.pano.model.ibator.PanoBmUserCriteria;
/**
 * 
 * *
 * @author lihaijun
 *
 */
public class PanoUserModel extends PanoBmUser<PanoUserModel, PanoBmUserCriteria> implements CommonModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PanoLoginModel login;

	public PanoLoginModel getLogin() {
		return login;
	}

	public void setLogin(PanoLoginModel login) {
		this.login = login;
	}
	
	
}
