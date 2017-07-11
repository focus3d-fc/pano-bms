package com.focus3d.pano.auth.service;

import java.util.List;

import com.focus3d.pano.common.service.CommonService;
/**
 *
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface PanoUserRoleService<T> extends CommonService<T> {
	/**
	 * 
	 * *
	 * @param userId
	 * @return
	 */
	public List<T> listByUserId(Long userId);
}
