package com.focus3d.pano.sms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.model.PanoValidateModel;
import com.focus3d.pano.sms.dao.SmsValidateDao;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
public class SmsValidateService {
	@Autowired
	private SmsValidateDao smsValidateDao;

	public List<PanoValidateModel> getListByPerDay(String mobilePhone) {
		return smsValidateDao.getListByPerDay(mobilePhone);
	}

	public void save(String mobilePhone, String verifyCode, String ipAddr) {
		//先删除之前记录
		PanoValidateModel existObj = smsValidateDao.selectByMobilePhone(mobilePhone, 1);
		if(existObj != null){
			setStatus(existObj, 0);
		}
		//保存一条新记录
		PanoValidateModel mobileValidate = new PanoValidateModel();
		mobileValidate.setSendObj(mobilePhone);
		mobileValidate.setCode(verifyCode);
		mobileValidate.setStatus(1);
		mobileValidate.setIpAddr(ipAddr);
		mobileValidate.setCreateDate(new Date());
		smsValidateDao.insertBySystem(mobileValidate);
	}
	
	public void delete(String mobilePhone, String verifyCode){
		smsValidateDao.delete(mobilePhone, verifyCode);
	}
	
	public void setStatus(PanoValidateModel smsValidateModel, int status){
		smsValidateModel.setStatus(status);
		smsValidateDao.updateBySystem(smsValidateModel);
	}

	public PanoValidateModel selectByMobilePhone(String mobilePhone, String smsCodeC) {
		return smsValidateDao.selectByMobilePhone(mobilePhone, smsCodeC);
	}
	
	
}
