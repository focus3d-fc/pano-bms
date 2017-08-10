package com.focus3d.pano.model;

import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PanoProjectPackageStyle implements CommonModel{
		
	private Long sn;  //序列号
	private Long pano_id;  //全景id
	private Long project_sn; //'楼盘sn',
	private Long style_sn;  // '风格sn',
	private Long house_sn; // '户型sn',
	private Integer adder_sn; // 添加人 ID
	private String adder_name; //添加人姓名
	private Date add_time;  // 添加时间
	private Integer updater_sn; //修改人Id
	private String updater_name; //修改人姓名
	private String update_time;  //修改时间
	
	public Long getPano_id() {
		return pano_id;
	}
	public void setPano_id(Long pano_id) {
		this.pano_id = pano_id;
	}
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getProject_sn() {
		return project_sn;
	}
	public void setProject_sn(Long project_sn) {
		this.project_sn = project_sn;
	}
	
	
	public Long getStyle_sn() {
		return style_sn;
	}
	public void setStyle_sn(Long style_sn) {
		this.style_sn = style_sn;
	}
	public Long getHouse_sn() {
		return house_sn;
	}
	public void setHouse_sn(Long house_sn) {
		this.house_sn = house_sn;
	}
	public Integer getAdder_sn() {
		return adder_sn;
	}
	public void setAdder_sn(Integer adder_sn) {
		this.adder_sn = adder_sn;
	}
	public String getAdder_name() {
		return adder_name;
	}
	public void setAdder_name(String adder_name) {
		this.adder_name = adder_name;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Integer getUpdater_sn() {
		return updater_sn;
	}
	public void setUpdater_sn(Integer updater_sn) {
		this.updater_sn = updater_sn;
	}
	public String getUpdater_name() {
		return updater_name;
	}
	public void setUpdater_name(String updater_name) {
		this.updater_name = updater_name;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
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
	public String getEncryptSn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEncryptSn(String encryptSn) {
		// TODO Auto-generated method stub
		
	}
	
	
}
