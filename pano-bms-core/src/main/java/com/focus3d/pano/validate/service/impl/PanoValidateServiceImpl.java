package com.focus3d.pano.validate.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.common.service.impl.CommonServiceImpl;
import com.focus3d.pano.model.PanoValidateModel;
import com.focus3d.pano.validate.dao.PanoValidateDao;
import com.focus3d.pano.validate.service.PanoValidateService;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Service
@Transactional
public class PanoValidateServiceImpl extends CommonServiceImpl<PanoValidateModel> implements PanoValidateService<PanoValidateModel> {
	@Autowired
	private PanoValidateDao panoValidateDao;
	
	@Override
	public CommonDao<PanoValidateModel> getDao() {
		return panoValidateDao;
	}
	
	@Override
	public PanoValidateModel getByCode(String sendObject, String smsCode) {
		return panoValidateDao.getInfo(sendObject, smsCode);
	}
	
	@Override
	public void delete(String sendObject) {
		panoValidateDao.deleteByMobilePhone(sendObject);
	}
	
	@Override
	public void setStatus(PanoValidateModel t, int status) {
		t.setStatus(status);
		panoValidateDao.updateByKeySelective(t);
	}
	
	@Override
	public void save(String sendObject, String verifyCode, String ip) {
		//先删除之前记录
		PanoValidateModel validateModel = panoValidateDao.getInfo(sendObject, 1);
		if(validateModel != null){
			setStatus(validateModel, 0);
		}
		//保存一条新记录
		validateModel = new PanoValidateModel();
		validateModel.setSendObj(sendObject);
		validateModel.setCode(verifyCode);
		validateModel.setStatus(1);
		validateModel.setIpAddr(ip);
		validateModel.setIpPosition("");
		validateModel.setCreateDate(new Date());
		panoValidateDao.insert(validateModel);
	}
	
	@Override
	public List<PanoValidateModel> listByPerDay(String sendObject) {
		return panoValidateDao.listByPerDay(sendObject);
	}
	
}
