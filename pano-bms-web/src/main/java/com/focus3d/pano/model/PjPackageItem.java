package com.focus3d.pano.model;

import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PjPackageItem implements CommonModel{
	private Long sn;
	private Long packageSn;
	private Long productSn;
	private Long itemTypeSn;
    private Long adderSn;
    private String adderName;
    private Date addTime;
    private Long updaterSn;
    private String updaterName;
    private Date updateTime;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getPackageSn() {
		return packageSn;
	}
	public void setPackageSn(Long packageSn) {
		this.packageSn = packageSn;
	}
	public Long getProductSn() {
		return productSn;
	}
	public void setProductSn(Long productSn) {
		this.productSn = productSn;
	}
	public Long getItemTypeSn() {
		return itemTypeSn;
	}
	public void setItemTypeSn(Long itemTypeSn) {
		this.itemTypeSn = itemTypeSn;
	}
	public Long getAdderSn() {
		return adderSn;
	}
	public void setAdderSn(Long adderSn) {
		this.adderSn = adderSn;
	}
	public String getAdderName() {
		return adderName;
	}
	public void setAdderName(String adderName) {
		this.adderName = adderName;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Long getUpdaterSn() {
		return updaterSn;
	}
	public void setUpdaterSn(Long updaterSn) {
		this.updaterSn = updaterSn;
	}
	public String getUpdaterName() {
		return updaterName;
	}
	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
