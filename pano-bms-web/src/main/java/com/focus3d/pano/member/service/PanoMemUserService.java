package com.focus3d.pano.member.service;

import com.focus3d.pano.common.service.CommonService;
import com.focus3d.pano.model.PanoMemLoginModel;
/**
 * 
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface PanoMemUserService<T> extends CommonService<T> {
	/**
	 * 
	 * *
	 * @param memLoginModel
	 */
	void insertOrUpdate(PanoMemLoginModel memLoginModel, int type);
}
