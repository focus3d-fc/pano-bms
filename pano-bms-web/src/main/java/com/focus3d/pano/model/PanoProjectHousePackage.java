package com.focus3d.pano.model;

import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PanoProjectHousePackage implements CommonModel{
	private Long sn;			//序列
	private Long house_style_sn;	//户型风格sn
	private Long package_sn;		//套餐SN
	private Long package_price;		// 套餐价格
	private Long adderSn;    //添加人id
	private String adderName; //添加人姓名
	private Date addTime;     //添加时间
	private Long updaterSn;   //修改人id
	private String updaterName; //修改人姓名
	private Date  updateTime;   //修改时间
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getHouse_style_sn() {
		return house_style_sn;
	}
	public void setHouse_style_sn(Long house_style_sn) {
		this.house_style_sn = house_style_sn;
	}
	public Long getPackage_sn() {
		return package_sn;
	}
	public void setPackage_sn(Long package_sn) {
		this.package_sn = package_sn;
	}
	public Long getPackage_price() {
		return package_price;
	}
	public void setPackage_price(Long package_price) {
		this.package_price = package_price;
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
