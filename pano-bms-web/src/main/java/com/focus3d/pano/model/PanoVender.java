package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PanoVender implements Serializable, CommonModel{

	private static final long serialVersionUID = 3923543172046924582L;
	private Long sn; //序号
	private String name; //名称
	private String province; //省
	private String city; //市
	private String area; //区
	private Integer adder_sn; // 添加人 ID
	private String adder_name; //添加人姓名
	private Date add_timeat;  // 添加时间
	private Integer updater_sn; //修改人Id
	private String updater_name; //修改人姓名
	private String update_time;  //修改时间
	
	
	
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


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
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


	public Date getAdd_timeat() {
		return add_timeat;
	}


	public void setAdd_timeat(Date add_timeat) {
		this.add_timeat = add_timeat;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public PanoVender() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PanoVender(Long sn, String name, String province, String city,
			String area, Integer adder_sn, String adder_name, Date add_timeat,
			Integer updater_sn, String updater_name, String update_time) {
		super();
		this.sn = sn;
		this.name = name;
		this.province = province;
		this.city = city;
		this.area = area;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_timeat = add_timeat;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.update_time = update_time;
	}




	@Override
	public String toString() {
		return "PanoVender [sn=" + sn + ", name=" + name + ", province="
				+ province + ", city=" + city + ", area=" + area
				+ ", adder_sn=" + adder_sn + ", adder_name=" + adder_name
				+ ", add_timeat=" + add_timeat + ", updater_sn=" + updater_sn
				+ ", updater_name=" + updater_name + ", update_time="
				+ update_time + "]";
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
		PanoVender other = (PanoVender) obj;
		if (sn == null) {
			if (other.sn != null)
				return false;
		} else if (!sn.equals(other.sn))
			return false;
		return true;
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


	/**
	 * ----------------------------
	 */
	
	
	
	
}
