package com.focus3d.pano.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;


/**
 * 
 * 风格实体类
 * 
 * @author 熊峰
 *
 */
public class project_style implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;
	
	private Long SN;
	private String NAME;
	private Long IMG_SN;
	private BigDecimal START_PRICE;
	private BigDecimal END_PRICE;
	private Long ADDER_SN;
	private String ADDER_NAME;
	private String ADD_TIME;
	private Long UPDATER_SN;
	private String UPDATER_NAME;
	private String UPDATE_TIME;
	private Long PROJECT_SN;
	public Long getSN() {
		return SN;
	}
	public void setSN(Long sN) {
		SN = sN;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public Long getIMG_SN() {
		return IMG_SN;
	}
	public void setIMG_SN(Long iMG_SN) {
		IMG_SN = iMG_SN;
	}
	public BigDecimal getSTART_PRICE() {
		return START_PRICE;
	}
	public void setSTART_PRICE(BigDecimal sTART_PRICE) {
		START_PRICE = sTART_PRICE;
	}
	public BigDecimal getEND_PRICE() {
		return END_PRICE;
	}
	public void setEND_PRICE(BigDecimal eND_PRICE) {
		END_PRICE = eND_PRICE;
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
	public Long getPROJECT_SN() {
		return PROJECT_SN;
	}
	public void setPROJECT_SN(Long pROJECT_SN) {
		PROJECT_SN = pROJECT_SN;
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
