package com.focus3d.pano.user.service;

import com.focus3d.pano.common.service.CommonService;
import com.focus3d.pano.model.PanoUserModel;
import com.focus3d.pano.model.PanoValidateModel;

/**
 * 
 * *
 * @author lihaijun
 *
 */
public interface PanoUserService<T> extends CommonService<T> {

	PanoUserModel getByMobile(String mobile);

	void register(PanoUserModel user, PanoValidateModel messageValidate);

}
