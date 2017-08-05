package com.focus3d.pano.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.focus3d.pano.common.model.CommonModel;

public class Style implements Serializable,CommonModel{

	private static final long serialVersionUID = -2064134309695560645L;
	private long id;
	private String name;
	private long img_sn;
	private BigDecimal start_price;
	private BigDecimal end_price;
	private long adder_sn;
	private String adder_name;
	private String add_time;
	private long updater_sn;
	private String updater_name;
	private String update_time;
	private long project_sn;
	
	//其他字段----------------------------------------
	private String project_name;
	private List<Lable> lableList;
	//方法-------------------------------------------
	public Style() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Style(long id, String name, long img_sn, BigDecimal start_price,
			BigDecimal end_price, long adder_sn, String adder_name,
			String add_time, long updater_sn, String updater_name,
			String update_time, long project_sn, String project_name,
			List<Lable> lableList) {
		super();
		this.id = id;
		this.name = name;
		this.img_sn = img_sn;
		this.start_price = start_price;
		this.end_price = end_price;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_time = add_time;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.update_time = update_time;
		this.project_sn = project_sn;
		this.project_name = project_name;
		this.lableList = lableList;
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

	public long getImg_sn() {
		return img_sn;
	}

	public void setImg_sn(long img_sn) {
		this.img_sn = img_sn;
	}

	public BigDecimal getStart_price() {
		return start_price;
	}

	public void setStart_price(BigDecimal start_price) {
		this.start_price = start_price;
	}

	public BigDecimal getEnd_price() {
		return end_price;
	}

	public void setEnd_price(BigDecimal end_price) {
		this.end_price = end_price;
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

	public long getProject_sn() {
		return project_sn;
	}

	public void setProject_sn(long project_sn) {
		this.project_sn = project_sn;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public List<Lable> getLableList() {
		return lableList;
	}

	public void setLableList(List<Lable> lableList) {
		this.lableList = lableList;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", name=" + name + ", img_sn=" + img_sn
				+ ", start_price=" + start_price + ", end_price=" + end_price
				+ ", adder_sn=" + adder_sn + ", adder_name=" + adder_name
				+ ", add_time=" + add_time + ", updater_sn=" + updater_sn
				+ ", updater_name=" + updater_name + ", update_time="
				+ update_time + ", project_sn=" + project_sn
				+ ", project_name=" + project_name + ", lableList=" + lableList
				+ "]";
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
		Style other = (Style) obj;
		if (id != other.id)
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


















