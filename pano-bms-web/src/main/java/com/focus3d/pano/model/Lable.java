package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class Lable implements Serializable,CommonModel{

	private static final long serialVersionUID = -7953345685065443073L;
	private long id;
	private String name;
	private int type;
	private long style_sn;
	private long adder_sn;
	private String adder_name;
	private String add_time;
	private long updater_sn;
	private String updater_name;
	private String update_time;
	
	
	public Lable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lable(long id, String name, int type, long style_sn, long adder_sn,
			String adder_name, String add_time, long updater_sn,
			String updater_name, String update_time) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.style_sn = style_sn;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_time = add_time;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "Lable [id=" + id + ", name=" + name + ", type=" + type
				+ ", style_sn=" + style_sn + ", adder_sn=" + adder_sn
				+ ", adder_name=" + adder_name + ", add_time=" + add_time
				+ ", updater_sn=" + updater_sn + ", updater_name="
				+ updater_name + ", update_time=" + update_time + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Lable other = (Lable) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getStyle_sn() {
		return style_sn;
	}

	public void setStyle_sn(long style_sn) {
		this.style_sn = style_sn;
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
