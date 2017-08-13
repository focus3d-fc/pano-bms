package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;


/**
 * 
 * 套餐分类下的产品
 * 
 * @author 熊峰
 *
 */
public class pano_project_package_product implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private Long PACKAGE_TYPE_SN;
	private Long PRODUCT_SN;
	private int ORDER_NUM;
	private Long ADDER_SN;
	private String ADDER_NAME;
	private String ADD_TIME;
	private Long UPDATER_SN;
	private String UPDATER_NAME;
	private String UPDATE_TIME;
	public Long getSN() {
		return SN;
	}
	public void setSN(Long sN) {
		SN = sN;
	}
	public Long getPACKAGE_TYPE_SN() {
		return PACKAGE_TYPE_SN;
	}
	public void setPACKAGE_TYPE_SN(Long pACKAGE_TYPE_SN) {
		PACKAGE_TYPE_SN = pACKAGE_TYPE_SN;
	}
	public Long getPRODUCT_SN() {
		return PRODUCT_SN;
	}
	public void setPRODUCT_SN(Long pRODUCT_SN) {
		PRODUCT_SN = pRODUCT_SN;
	}
	public int getORDER_NUM() {
		return ORDER_NUM;
	}
	public void setORDER_NUM(int oRDER_NUM) {
		ORDER_NUM = oRDER_NUM;
	}
	public Long getADDER_SN() {
		return ADDER_SN;
	}
	public void setADDER_SN(Long aDDER_SN) {
		ADDER_SN = aDDER_SN;
	}
	public String getADDER_NAME() {
		return ADDER_NAME;
	}
	public void setADDER_NAME(String aDDER_NAME) {
		ADDER_NAME = aDDER_NAME;
	}
	public String getADD_TIME() {
		return ADD_TIME;
	}
	public void setADD_TIME(String aDD_TIME) {
		ADD_TIME = aDD_TIME;
	}
	public Long getUPDATER_SN() {
		return UPDATER_SN;
	}
	public void setUPDATER_SN(Long uPDATER_SN) {
		UPDATER_SN = uPDATER_SN;
	}
	public String getUPDATER_NAME() {
		return UPDATER_NAME;
	}
	public void setUPDATER_NAME(String uPDATER_NAME) {
		UPDATER_NAME = uPDATER_NAME;
	}
	public String getUPDATE_TIME() {
		return UPDATE_TIME;
	}
	public void setUPDATE_TIME(String uPDATE_TIME) {
		UPDATE_TIME = uPDATE_TIME;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public Long getAdderSn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAdderSn(Long adderSn) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getAdderName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAdderName(String adderName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Date getAddTime() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAddTime(Date addTime) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Long getUpdaterSn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setUpdaterSn(Long updaterSn) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getUpdaterName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setUpdaterName(String updaterName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Date getUpdateTime() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setUpdateTime(Date updateTime) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Long getSn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setSn(Long sn) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEncryptSn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEncryptSn(String encryptSn) {
		// TODO Auto-generated method stub
		
	}
	
	
}
