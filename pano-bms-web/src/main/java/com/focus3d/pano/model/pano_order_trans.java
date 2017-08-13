package com.focus3d.pano.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

/**
 * 
 * 订单交易记录
 * 
 * @author 熊峰
 * 
 */
public class pano_order_trans implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;
	
	private Long SN;
	private String ORDER_ID;
	private String BANK_CODE;
	private String BANK_NAME;
	private String TRANS_DATE;
	private String TRANS_TYPE;
	private int TRANS_PLATFORM_TYPE;
	private String TRANS_ACCOUNT;
	private BigDecimal TRANS_MONEY;
	private String MER_ID;
	private String CURRENCY_ID;
	private String TRANS_STATUS;
	private String TRANS_ID;
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
	public String getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(String oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}
	public String getBANK_NAME() {
		return BANK_NAME;
	}
	public void setBANK_NAME(String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}
	public String getTRANS_DATE() {
		return TRANS_DATE;
	}
	public void setTRANS_DATE(String tRANS_DATE) {
		TRANS_DATE = tRANS_DATE;
	}
	public String getTRANS_TYPE() {
		return TRANS_TYPE;
	}
	public void setTRANS_TYPE(String tRANS_TYPE) {
		TRANS_TYPE = tRANS_TYPE;
	}
	public int getTRANS_PLATFORM_TYPE() {
		return TRANS_PLATFORM_TYPE;
	}
	public void setTRANS_PLATFORM_TYPE(int tRANS_PLATFORM_TYPE) {
		TRANS_PLATFORM_TYPE = tRANS_PLATFORM_TYPE;
	}
	public String getTRANS_ACCOUNT() {
		return TRANS_ACCOUNT;
	}
	public void setTRANS_ACCOUNT(String tRANS_ACCOUNT) {
		TRANS_ACCOUNT = tRANS_ACCOUNT;
	}
	public BigDecimal getTRANS_MONEY() {
		return TRANS_MONEY;
	}
	public void setTRANS_MONEY(BigDecimal tRANS_MONEY) {
		TRANS_MONEY = tRANS_MONEY;
	}
	public String getMER_ID() {
		return MER_ID;
	}
	public void setMER_ID(String mER_ID) {
		MER_ID = mER_ID;
	}
	public String getCURRENCY_ID() {
		return CURRENCY_ID;
	}
	public void setCURRENCY_ID(String cURRENCY_ID) {
		CURRENCY_ID = cURRENCY_ID;
	}
	public String getTRANS_STATUS() {
		return TRANS_STATUS;
	}
	public void setTRANS_STATUS(String tRANS_STATUS) {
		TRANS_STATUS = tRANS_STATUS;
	}
	public String getTRANS_ID() {
		return TRANS_ID;
	}
	public void setTRANS_ID(String tRANS_ID) {
		TRANS_ID = tRANS_ID;
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
