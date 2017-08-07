package com.focus3d.pano.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PanoProjectPackage implements Serializable, CommonModel{
	
	private static final long serialVersionUID = 2116671993371130823L;
	private Long sn;         //序列号
	private String name;     //名称
	private Long img_sn;     //图片id
	private String id;       //ID
	private Long style_sn;    //风格s
	private BigDecimal total_price;  //总价
	private Long adder_sn;    //添加人id
	private String adder_name; //添加人姓名
	private Date add_time;     //添加时间
	private Long updater_sn;   //修改人id
	private String updater_name; //修改人姓名
	private Date  update_time;   //修改时间
	
	
	
	
	public PanoProjectPackage() {
		super();
	}
	public PanoProjectPackage(Long sn, String name, Long style_sn,
			BigDecimal total_price, Long adder_sn, String adder_name,
			Date add_time, Long updater_sn, String updater_name,
			Date update_time) {
		super();
		this.sn = sn;
		this.name = name;
		this.style_sn = style_sn;
		this.total_price = total_price;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_time = add_time;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.update_time = update_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sn == null) ? 0 : sn.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PanoProjectPackage other = (PanoProjectPackage) obj;
		if (sn == null) {
			if (other.sn != null)
				return false;
		} else if (!sn.equals(other.sn))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PanoProjectPackage [sn=" + sn + ", name=" + name
				+ ", style_sn=" + style_sn + ", total_price=" + total_price
				+ ", adder_sn=" + adder_sn + ", adder_name=" + adder_name
				+ ", add_time=" + add_time + ", updater_sn=" + updater_sn
				+ ", updater_name=" + updater_name + ", update_time="
				+ update_time + "]";
	}
	
	
	public Long getImg_sn() {
		return img_sn;
	}
	public void setImg_sn(Long img_sn) {
		this.img_sn = img_sn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Long getStyle_sn() {
		return style_sn;
	}
	public void setStyle_sn(Long style_sn) {
		this.style_sn = style_sn;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	public Long getAdder_sn() {
		return adder_sn;
	}
	public void setAdder_sn(Long adder_sn) {
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
	public Long getUpdater_sn() {
		return updater_sn;
	}
	public void setUpdater_sn(Long updater_sn) {
		this.updater_sn = updater_sn;
	}
	public String getUpdater_name() {
		return updater_name;
	}
	public void setUpdater_name(String updater_name) {
		this.updater_name = updater_name;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
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
	public String getEncryptSn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEncryptSn(String encryptSn) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
