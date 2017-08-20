package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

/**
 * 风格管理表实体类
 * @author Administrator
 *
 */
public class pano_project_style implements Serializable, CommonModel{
	private Long sn; //序号
	private String name; //名称
	private Long img_sn; //效果图
	private double start_price; //预计最低价格区间
	private double end_pricep; //预计最高价格区间
	private Integer adder_sn; // 添加人ID
	private String adder_name; //添加人姓名
	private Date add_time;  // 添加时间
	private Integer updater_sn; //修改人Id
	private String updater_name; //修改人姓名
	private String update_time;  //修改时间
	
	
	
	public Long getImg_sn() {
		return img_sn;
	}
	public void setImg_sn(Long img_sn) {
		this.img_sn = img_sn;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getStart_price() {
		return start_price;
	}
	public void setStart_price(double start_price) {
		this.start_price = start_price;
	}
	public double getEnd_pricep() {
		return end_pricep;
	}
	public void setEnd_pricep(double end_pricep) {
		this.end_pricep = end_pricep;
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
	public void setAdd_timeat(Date add_time) {
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
		return null;
	}
	@Override
	public void setAdderSn(Long adderSn) {
		
	}
	@Override
	public String getAdderName() {
		return null;
	}
	@Override
	public void setAdderName(String adderName) {
		
	}
	@Override
	public Date getAddTime() {
		return null;
	}
	@Override
	public void setAddTime(Date addTime) {
		
	}
	@Override
	public Long getUpdaterSn() {
		return null;
	}
	@Override
	public void setUpdaterSn(Long updaterSn) {
		
	}
	@Override
	public String getUpdaterName() {
		return null;
	}
	@Override
	public void setUpdaterName(String updaterName) {
		
	}
	@Override
	public Date getUpdateTime() {
		return null;
	}
	@Override
	public void setUpdateTime(Date updateTime) {
		
	}
	@Override
	public String getEncryptSn() {
		return null;
	}
	@Override
	public void setEncryptSn(String encryptSn) {
		
	}
	
}	
