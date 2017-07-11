package com.focus3d.pano.validate.service;

import java.util.List;

import com.focus3d.pano.common.service.CommonService;
import com.focus3d.pano.model.PanoValidateModel;
/**
 * *
 * @author lihaijun
 *
 * @param <T>
 */
public interface PanoValidateService<T> extends CommonService<T> {

	PanoValidateModel getByCode(String sendObject, String smsCode);
	
	void delete(String sendObject);

	void setStatus(T t, int status);

	void save(String mobilePhone, String verifyCode, String ip);

	List<T> listByPerDay(String mobilePhone);
}
