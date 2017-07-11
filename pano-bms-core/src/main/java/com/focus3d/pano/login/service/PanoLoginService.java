package com.focus3d.pano.login.service;

import com.focus3d.pano.common.service.CommonService;
import com.focus3d.pano.model.PanoLoginModel;
/**
 * 
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface PanoLoginService<T> extends CommonService<T> {

	PanoLoginModel getByName(String loginName);

}
