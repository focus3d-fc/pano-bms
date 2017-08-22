package com.focus3d.pano.sms.dao;

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
public class SmsValidateDao extends CommonDao<PanoValidateModel> {

	public List<PanoValidateModel> getListByPerDay(String mobilePhone) {
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

	public PanoValidateModel selectByMobilePhone(String mobilePhone, int status) {
		PanoValidateCriteria criteria = new PanoValidateCriteria();
		criteria.createCriteria().andSendObjEqualTo(mobilePhone).andStatusEqualTo(status);
		return selectFirstByExample(criteria, PanoValidateModel.class);
	}

	public void delete(String mobilePhone, String verifyCode) {
		PanoValidateCriteria criteria = new PanoValidateCriteria();
		criteria.createCriteria().andSendObjEqualTo(mobilePhone).andCodeEqualTo(verifyCode);
		deleteByCriteria(criteria);
	}

	public PanoValidateModel selectByMobilePhone(String mobilePhone, String smsCodeC) {
		PanoValidateCriteria criteria = new PanoValidateCriteria();
		criteria.createCriteria().andSendObjEqualTo(mobilePhone).andCodeEqualTo(smsCodeC).andStatusEqualTo(1);
		return selectFirstByExample(criteria, PanoValidateModel.class);
	}
}
