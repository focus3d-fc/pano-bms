package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class User_Role implements Serializable,CommonModel{

	private static final long serialVersionUID = 6579493678862074610L;

	private long sn;
	private long user_sn;
	private long role_sn;
	private long adder_sn;
	private String adder_name;
	private String add_time;
	private long updater_sn;
	private String updater_name;
	private String updater_time;
	public User_Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
public User_Role(long sn, long user_sn, long role_sn, long adder_sn,
			String adder_name, String add_time, long updater_sn,
			String updater_name, String updater_time) {
		super();
		this.sn = sn;
		this.user_sn = user_sn;
		this.role_sn = role_sn;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_time = add_time;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.updater_time = updater_time;
	}






public long getUser_sn() {
	return user_sn;
}

public void setUser_sn(long user_sn) {
	this.user_sn = user_sn;
}

public long getRole_sn() {
	return role_sn;
}

public void setRole_sn(long role_sn) {
	this.role_sn = role_sn;
}

public long getAdder_sn() {
	return adder_sn;
}

public void setAdder_sn(long adder_sn) {
	this.adder_sn = adder_sn;
}

public String getAdder_name() {
	return adder_name;
}

public void setAdder_name(String adder_name) {
	this.adder_name = adder_name;
}

public String getAdd_time() {
	return add_time;
}

public void setAdd_time(String add_time) {
	this.add_time = add_time;
}

public long getUpdater_sn() {
	return updater_sn;
}

public void setUpdater_sn(long updater_sn) {
	this.updater_sn = updater_sn;
}

public String getUpdater_name() {
	return updater_name;
}

public void setUpdater_name(String updater_name) {
	this.updater_name = updater_name;
}

public String getUpdater_time() {
	return updater_time;
}

public void setUpdater_time(String updater_time) {
	this.updater_time = updater_time;
}

public void setSn(long sn) {
	this.sn = sn;
}

@Override
public String toString() {
	return "User_Role [sn=" + sn + ", user_sn=" + user_sn + ", role_sn="
			+ role_sn + ", adder_sn=" + adder_sn + ", adder_name=" + adder_name
			+ ", add_time=" + add_time + ", updater_sn=" + updater_sn
			+ ", updater_name=" + updater_name + ", updater_time="
			+ updater_time + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (sn ^ (sn >>> 32));
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
	User_Role other = (User_Role) obj;
	if (sn != other.sn)
		return false;
	return true;
}

/**
 * 其他方法
 * --------------------------------------------------------------------------------------
 */
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














