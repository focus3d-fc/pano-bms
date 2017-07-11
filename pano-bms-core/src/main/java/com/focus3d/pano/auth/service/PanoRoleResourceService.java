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
public interface PanoRoleResourceService<T> extends CommonService<T> {
	/**
	 * *
	 * @param roleId
	 * @return
	 */
	List<T> listByRoleId(long roleId);
}
