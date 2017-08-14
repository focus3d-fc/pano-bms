package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

/**
 * 
 * 订单中转实体类
 * 
 * @author 熊峰
 * 
 */
public class OrderRelevance implements Serializable, CommonModel {

	private static final long serialVersionUID = -1423892477614156650L;

	private Long SN;
	private String PACKAGE_TYPE;// 套餐类型
	private String STATUS;// 订单状态
	private String STYLE;// 风格
	private String HOUSE;// 户型
	private String TOTAL_PRICE;// 订单总价
	private String LOGTC_PRICE;// 运费
	private String IMG_SN;// 图片
	private String ITEM_AMOUNT;// 商品数量
	private String SUM_PRICE;// 总价+运费

	public Long getSN() {
		return SN;
	}

	public void setSN(Long sN) {
		SN = sN;
	}

	public String getPACKAGE_TYPE() {
		return PACKAGE_TYPE;
	}

	public void setPACKAGE_TYPE(String pACKAGE_TYPE) {
		PACKAGE_TYPE = pACKAGE_TYPE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getSTYLE() {
		return STYLE;
	}

	public void setSTYLE(String sTYLE) {
		STYLE = sTYLE;
	}

	public String getHOUSE() {
		return HOUSE;
	}

	public void setHOUSE(String hOUSE) {
		HOUSE = hOUSE;
	}

	public String getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}

	public void setTOTAL_PRICE(String tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public String getLOGTC_PRICE() {
		return LOGTC_PRICE;
	}

	public void setLOGTC_PRICE(String lOGTC_PRICE) {
		LOGTC_PRICE = lOGTC_PRICE;
	}

	public String getIMG_SN() {
		return IMG_SN;
	}

	public void setIMG_SN(String iMG_SN) {
		IMG_SN = iMG_SN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getITEM_AMOUNT() {
		return ITEM_AMOUNT;
	}

	public void setITEM_AMOUNT(String iTEM_AMOUNT) {
		ITEM_AMOUNT = iTEM_AMOUNT;
	}

	public String getSUM_PRICE() {
		return SUM_PRICE;
	}

	public void setSUM_PRICE(String sUM_PRICE) {
		SUM_PRICE = sUM_PRICE;
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
