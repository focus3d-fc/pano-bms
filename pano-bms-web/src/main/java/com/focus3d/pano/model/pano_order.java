package com.focus3d.pano.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

/**
 * 
 * 订单
 * 
 * @author 熊峰
 * 
 */
public class pano_order implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private String ORDER_NUM;
	private String ORDER_TIME;
	private int STATUS;
	private Long ADDRESS_SN;
	private Long USER_SN;
	private BigDecimal TOTAL_PRICE;
	private String PAY_TIME;
	private byte[] PREPAY_ID;
	private String EXTEND;
	private String REMARK;
	private String CERT_USER_NAME;
	private int CERT_USER_SEX;
	private String CERT_USER_MOBILE;
	private int CERT_TYPE;
	private String CERT_NO;
	private String REASON;
	private String REASON_DETAIL;
	private String REFUND_TIME;
	private BigDecimal REFUND_MONEY;
	private BigDecimal PAY_TO_MONEY;
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

	public String getORDER_NUM() {
		return ORDER_NUM;
	}

	public void setORDER_NUM(String oRDER_NUM) {
		ORDER_NUM = oRDER_NUM;
	}

	public String getORDER_TIME() {
		return ORDER_TIME;
	}

	public void setORDER_TIME(String oRDER_TIME) {
		ORDER_TIME = oRDER_TIME;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	public Long getADDRESS_SN() {
		return ADDRESS_SN;
	}

	public void setADDRESS_SN(Long aDDRESS_SN) {
		ADDRESS_SN = aDDRESS_SN;
	}

	public Long getUSER_SN() {
		return USER_SN;
	}

	public void setUSER_SN(Long uSER_SN) {
		USER_SN = uSER_SN;
	}

	public BigDecimal getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}

	public void setTOTAL_PRICE(BigDecimal tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public String getPAY_TIME() {
		return PAY_TIME;
	}

	public void setPAY_TIME(String pAY_TIME) {
		PAY_TIME = pAY_TIME;
	}

	public byte[] getPREPAY_ID() {
		return PREPAY_ID;
	}

	public void setPREPAY_ID(byte[] pREPAY_ID) {
		PREPAY_ID = pREPAY_ID;
	}

	public String getEXTEND() {
		return EXTEND;
	}

	public void setEXTEND(String eXTEND) {
		EXTEND = eXTEND;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public String getCERT_USER_NAME() {
		return CERT_USER_NAME;
	}

	public void setCERT_USER_NAME(String cERT_USER_NAME) {
		CERT_USER_NAME = cERT_USER_NAME;
	}

	public int getCERT_USER_SEX() {
		return CERT_USER_SEX;
	}

	public void setCERT_USER_SEX(int cERT_USER_SEX) {
		CERT_USER_SEX = cERT_USER_SEX;
	}

	public String getCERT_USER_MOBILE() {
		return CERT_USER_MOBILE;
	}

	public void setCERT_USER_MOBILE(String cERT_USER_MOBILE) {
		CERT_USER_MOBILE = cERT_USER_MOBILE;
	}

	public int getCERT_TYPE() {
		return CERT_TYPE;
	}

	public void setCERT_TYPE(int cERT_TYPE) {
		CERT_TYPE = cERT_TYPE;
	}

	public String getCERT_NO() {
		return CERT_NO;
	}

	public void setCERT_NO(String cERT_NO) {
		CERT_NO = cERT_NO;
	}

	public String getREASON() {
		return REASON;
	}

	public void setREASON(String rEASON) {
		REASON = rEASON;
	}

	public String getREASON_DETAIL() {
		return REASON_DETAIL;
	}

	public void setREASON_DETAIL(String rEASON_DETAIL) {
		REASON_DETAIL = rEASON_DETAIL;
	}

	public String getREFUND_TIME() {
		return REFUND_TIME;
	}

	public void setREFUND_TIME(String rEFUND_TIME) {
		REFUND_TIME = rEFUND_TIME;
	}

	public BigDecimal getREFUND_MONEY() {
		return REFUND_MONEY;
	}

	public void setREFUND_MONEY(BigDecimal rEFUND_MONEY) {
		REFUND_MONEY = rEFUND_MONEY;
	}

	public BigDecimal getPAY_TO_MONEY() {
		return PAY_TO_MONEY;
	}

	public void setPAY_TO_MONEY(BigDecimal pAY_TO_MONEY) {
		PAY_TO_MONEY = pAY_TO_MONEY;
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

	public Long getADDER_SN() {
		return ADDER_SN;
	}

	public void setADDER_SN(Long aDDER_SN) {
		ADDER_SN = aDDER_SN;
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
