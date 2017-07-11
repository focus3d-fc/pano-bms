package com.focus3d.pano.validate.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoValidateModel;
import com.focus3d.pano.model.ibator.PanoValidateCriteria;
import com.focustech.common.utils.DateUtils;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Repository
public class PanoValidateDao extends CommonDao<PanoValidateModel> {
	/**
	 * 
	 * *
	 * @param sendObject
	 * @param code
	 * @return
	 */
	public PanoValidateModel getInfo(String sendObject, String code) {
		PanoValidateCriteria criteria = new PanoValidateCriteria();
		criteria.createCriteria().andSendObjEqualTo(sendObject).andCodeEqualTo(code).andStatusEqualTo(1);
		return selectFirstByExample(criteria, PanoValidateModel.class);
	}
	
	/**
	 *
	 * *
	 * @param sendObject
	 * @param verifyCode
	 * @param status
	 * @return
	 */
	public PanoValidateModel getInfo(String sendObject, int status) {
		PanoValidateCriteria criteria = new PanoValidateCriteria();
		criteria.createCriteria().andSendObjEqualTo(sendObject).andStatusEqualTo(status);
		return selectFirstByExample(criteria, PanoValidateModel.class);
	}
	/**
	 * 
	 * *
	 * @param mobilePhone
	 */
	public void deleteByMobilePhone(String mobilePhone) {
		PanoValidateCriteria criteria = new PanoValidateCriteria();
		criteria.createCriteria().andSendObjEqualTo(mobilePhone);
		deleteByCriteria(criteria);
	}
	/**
	 * 
	 * *
	 * @param mobilePhone
	 * @return
	 */
	public List<PanoValidateModel> listByPerDay(String mobilePhone) {
		PanoValidateCriteria criteria = new PanoValidateCriteria();
		String curDate = DateUtils.getCurDate(DateUtils.DEFAULT_FORMATE);
		DateFormat df = new SimpleDateFormat(DateUtils.DEFAULT_FORMATE);
		Date date = null;
		try {
			date = df.parse(curDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		criteria.createCriteria().andSendObjEqualTo(mobilePhone).andCreateDateEqualTo(date);
		return selectByCriteria(criteria, PanoValidateModel.class);
	}

}
