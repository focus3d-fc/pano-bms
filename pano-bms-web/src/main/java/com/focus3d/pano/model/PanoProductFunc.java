package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PanoProductFunc implements Serializable, CommonModel{
	private Long sn;         //序列号
	private String name;     //名称
	private Integer status;  //状态
	private Long adderSn;    //添加人id
	private String adderName; //添加人姓名
	private Date addTime;     //添加时间
	private Long updaterSn;   //修改人id
	private String updaterName; //修改人姓名
	private Date  updateTime;   //修改时间
	
	
	
	
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
		PanoProductFunc other = (PanoProductFunc) obj;
		if (sn == null) {
			if (other.sn != null)
				return false;
		} else if (!sn.equals(other.sn))
			return false;
		return true;
	}
	public PanoProductFunc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PanoProductFunc(Long sn, String name, Integer status, Long adderSn,
			String adderName, Date addTime, Long updaterSn, String updaterName,
			Date updateTime) {
		super();
		this.sn = sn;
		this.name = name;
		this.status = status;
		this.adderSn = adderSn;
		this.adderName = adderName;
		this.addTime = addTime;
		this.updaterSn = updaterSn;
		this.updaterName = updaterName;
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "PanoProductFunc [sn=" + sn + ", name=" + name + ", status="
				+ status + ", adderSn=" + adderSn + ", adderName=" + adderName
				+ ", addTime=" + addTime + ", updaterSn=" + updaterSn
				+ ", updaterName=" + updaterName + ", updateTime=" + updateTime
				+ "]";
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
