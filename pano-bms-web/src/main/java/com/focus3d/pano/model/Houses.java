package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class Houses implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private String NAME;
	private String PROVINCE;
	private String CITY;
	private String AREA;
	private Long ADDER_SN;
	private String ADDER_NAME;
	private Date ADD_TIME;
	private Long UPDATER_SN;
	private String UPDATER_NAME;
	private Date UPDATE_TIME;

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

	public Date getADD_TIME() {
		return ADD_TIME;
	}

	public void setADD_TIME(Date aDD_TIME) {
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

	public Date getUPDATE_TIME() {
		return UPDATE_TIME;
	}

	public void setUPDATE_TIME(Date uPDATE_TIME) {
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
