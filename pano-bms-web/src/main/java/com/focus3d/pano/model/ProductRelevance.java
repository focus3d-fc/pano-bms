package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

/**
 * 
 * 产品中转实体类
 * 
 * @author 熊峰
 * 
 */
public class ProductRelevance implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private Long PRODUCT_SN;// 产品SN
	private String PRODUCT_NAME;// 产品名称
	private String BRAND;// 品牌
	private int LENGTH;// 尺寸长
	private int WIDE;// 尺寸宽
	private int HEIGHT;// 尺寸高
	private String REMARK;// 备注
	private Long IMG_SN;// 图片
	private Long LEFT_IMG_SN;
	private Long DOWN_IMG_SN;
	private Long FULL_IMG_SN;
	private Long BANNER_IMG_SN;
	private Long MATERIAL_IMG_SN;
	private Long FABRIC_IMG_SN;

	public Long getLEFT_IMG_SN() {
		return LEFT_IMG_SN;
	}

	public void setLEFT_IMG_SN(Long lEFT_IMG_SN) {
		LEFT_IMG_SN = lEFT_IMG_SN;
	}

	public Long getDOWN_IMG_SN() {
		return DOWN_IMG_SN;
	}

	public void setDOWN_IMG_SN(Long dOWN_IMG_SN) {
		DOWN_IMG_SN = dOWN_IMG_SN;
	}

	public Long getFULL_IMG_SN() {
		return FULL_IMG_SN;
	}

	public void setFULL_IMG_SN(Long fULL_IMG_SN) {
		FULL_IMG_SN = fULL_IMG_SN;
	}

	public Long getBANNER_IMG_SN() {
		return BANNER_IMG_SN;
	}

	public void setBANNER_IMG_SN(Long bANNER_IMG_SN) {
		BANNER_IMG_SN = bANNER_IMG_SN;
	}

	public Long getMATERIAL_IMG_SN() {
		return MATERIAL_IMG_SN;
	}

	public void setMATERIAL_IMG_SN(Long mATERIAL_IMG_SN) {
		MATERIAL_IMG_SN = mATERIAL_IMG_SN;
	}

	public Long getFABRIC_IMG_SN() {
		return FABRIC_IMG_SN;
	}

	public void setFABRIC_IMG_SN(Long fABRIC_IMG_SN) {
		FABRIC_IMG_SN = fABRIC_IMG_SN;
	}

	public Long getSN() {
		return SN;
	}

	public void setSN(Long sN) {
		SN = sN;
	}

	public Long getPRODUCT_SN() {
		return PRODUCT_SN;
	}

	public void setPRODUCT_SN(Long pRODUCT_SN) {
		PRODUCT_SN = pRODUCT_SN;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getBRAND() {
		return BRAND;
	}

	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}

	public int getLENGTH() {
		return LENGTH;
	}

	public void setLENGTH(int lENGTH) {
		LENGTH = lENGTH;
	}

	public int getWIDE() {
		return WIDE;
	}

	public void setWIDE(int wIDE) {
		WIDE = wIDE;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public Long getIMG_SN() {
		return IMG_SN;
	}

	public void setIMG_SN(Long iMG_SN) {
		IMG_SN = iMG_SN;
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
