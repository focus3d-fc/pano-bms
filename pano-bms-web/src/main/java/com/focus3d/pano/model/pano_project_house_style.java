package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.focus3d.pano.common.model.CommonModel;

/**
 * 
 * 户型风格关系实体类
 * 
 * @author 熊峰
 * 
 */
public class pano_project_house_style implements Serializable, CommonModel {
	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private Long HOUSE_SN;
	private Long STYLE_SN;
	private Long PANO_ID;
	private Long PROJECT_SN;
	private Long ADDER_SN;
	private String ADDER_NAME;
	private String ADD_TIME;
	private Long UPDATER_SN;
	private String UPDATER_NAME;
	private String UPDATE_TIME;

	private List<pano_project_house> Houses;
	private String NAME;

	public List<pano_project_house> getHouses() {
		return Houses;
	}

	public void setHouses(List<pano_project_house> houses) {
		Houses = houses;
	}

	public Long getSN() {
		return SN;
	}

	public void setSN(Long sN) {
		SN = sN;
	}

	public Long getHOUSE_SN() {
		return HOUSE_SN;
	}

	public void setHOUSE_SN(Long hOUSE_SN) {
		HOUSE_SN = hOUSE_SN;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Long getSTYLE_SN() {
		return STYLE_SN;
	}

	public void setSTYLE_SN(Long sTYLE_SN) {
		STYLE_SN = sTYLE_SN;
	}

	public Long getPANO_ID() {
		return PANO_ID;
	}

	public void setPANO_ID(Long pANO_ID) {
		PANO_ID = pANO_ID;
	}

	public Long getPROJECT_SN() {
		return PROJECT_SN;
	}

	public void setPROJECT_SN(Long pROJECT_SN) {
		PROJECT_SN = pROJECT_SN;
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
