package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class OrderAdmin implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private Long ORDER_SN;// 订单SN
	private Long ORDER_NUM;//订单号
	private Long USER_SN;// 用户SN
	private String NICK_NAME;// 用户昵称
	private int STATUS;// 订单状态
	private int SEND;// 是否发货 0-未发货 1-发货
	private String SUM_MONEY;// 订单总价
	private String PAY_MONEY;//已支付金额
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
	private String STYLE_NAME;
	private String HOUSE_NAME;
	private String PACKAGE_NAME;

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
	
	public Long getORDER_NUM() {
		return ORDER_NUM;
	}

	public void setORDER_NUM(Long oRDER_NUM) {
		ORDER_NUM = oRDER_NUM;
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

	public String getSUM_MONEY() {
		return SUM_MONEY;
	}

	public void setSUM_MONEY(String tOTAL_PRICE) {
		SUM_MONEY = tOTAL_PRICE;
	}
	
	public String getPAY_MONEY() {
		return PAY_MONEY;
	}

	public void setPAY_MONEY(String pAY_MONEY) {
		PAY_MONEY = pAY_MONEY;
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
	
	public String getSTYLE_NAME() {
		return STYLE_NAME;
	}

	public void setSTYLE_NAME(String sTYLE_NAME) {
		STYLE_NAME = sTYLE_NAME;
	}

	public String getHOUSE_NAME() {
		return HOUSE_NAME;
	}

	public void setHOUSE_NAME(String hOUSE_NAME) {
		HOUSE_NAME = hOUSE_NAME;
	}
	
	public String getPACKAGE_NAME() {
		return PACKAGE_NAME;
	}

	public void setPACKAGE_NAME(String pACKAGE_NAME) {
		PACKAGE_NAME = pACKAGE_NAME;
	}
}
