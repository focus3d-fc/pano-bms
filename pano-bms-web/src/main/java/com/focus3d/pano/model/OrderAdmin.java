package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class OrderAdmin implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private Long ORDER_SN;// 订单SN
	private Long USER_SN;// 用户SN
	private String NICK_NAME;// 用户昵称
	private int STATUS;// 订单状态
	private int SEND;// 是否发货 0-未发货 1-发货
	private String TOTAL_PRICE;// 订单总价
	private String MOBILE;// 手机
	private String BACKUP_MOBILE;// 备用手机
	private String LOGTC_ID;// 物流编号
	private String ORDER_TIME;// 订单时间
	private String PROVINCE;// 省
	private String CITY;// 城市
	private String AREA;// 区县
	private String STREET;// 街道
	private Long PROJECT_SN;// 楼盘SN
	private String PROJECT_NAME;// 楼盘名称

	public Long getSN() {
		return SN;
	}

	public void setSN(Long sN) {
		SN = sN;
	}

	public Long getORDER_SN() {
		return ORDER_SN;
	}

	public void setORDER_SN(Long oRDER_SN) {
		ORDER_SN = oRDER_SN;
	}

	public Long getUSER_SN() {
		return USER_SN;
	}

	public void setUSER_SN(Long uSER_SN) {
		USER_SN = uSER_SN;
	}

	public String getNICK_NAME() {
		return NICK_NAME;
	}

	public void setNICK_NAME(String nICK_NAME) {
		NICK_NAME = nICK_NAME;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	public int getSEND() {
		return SEND;
	}

	public void setSEND(int sEND) {
		SEND = sEND;
	}

	public String getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}

	public void setTOTAL_PRICE(String tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMOBILE() {
		return MOBILE;
	}

	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}

	public String getBACKUP_MOBILE() {
		return BACKUP_MOBILE;
	}

	public void setBACKUP_MOBILE(String bACKUP_MOBILE) {
		BACKUP_MOBILE = bACKUP_MOBILE;
	}

	public String getLOGTC_ID() {
		return LOGTC_ID;
	}

	public void setLOGTC_ID(String lOGTC_ID) {
		LOGTC_ID = lOGTC_ID;
	}

	public String getORDER_TIME() {
		return ORDER_TIME;
	}

	public void setORDER_TIME(String oRDER_TIME) {
		ORDER_TIME = oRDER_TIME;
	}

	public String getPROVINCE() {
		return PROVINCE;
	}

	public void setPROVINCE(String pROVINCE) {
		PROVINCE = pROVINCE;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getAREA() {
		return AREA;
	}

	public void setAREA(String aREA) {
		AREA = aREA;
	}

	public String getSTREET() {
		return STREET;
	}

	public void setSTREET(String sTREET) {
		STREET = sTREET;
	}

	public Long getPROJECT_SN() {
		return PROJECT_SN;
	}

	public void setPROJECT_SN(Long pROJECT_SN) {
		PROJECT_SN = pROJECT_SN;
	}

	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}

	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
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
