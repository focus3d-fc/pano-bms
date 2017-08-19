package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.focus3d.pano.common.model.CommonModel;
/**
 *  套餐类型表
 */
public class PanoProjectPackageType implements Serializable,CommonModel{
	
	private static final long serialVersionUID = 4021637771102978484L;
	private Long SN;		// 序列号
	private String name;		//类型名称
	private Long space_sn;		//空间SN
	private Long house_package_sn; //套餐SN
	private Integer adder_sn; // 添加人ID
	private String adder_name; //添加人姓名
	private Date add_time;  // 添加时间
	private Integer updater_sn; //修改人Id
	private String updater_name; //修改人姓名
	private String update_time;  //修改时间
	//新增字段--------------------------------------
	private List<Product> productList;//套餐类型下面对应的产品集合
	private long house_style_sn;//户型风格sn
	
	public PanoProjectPackageType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PanoProjectPackageType(Long sN, String name, Long space_sn,
			Long house_package_sn, Integer adder_sn, String adder_name,
			Date add_time, Integer updater_sn, String updater_name,
			String update_time, List<Product> productList) {
		super();
		SN = sN;
		this.name = name;
		this.space_sn = space_sn;
		this.house_package_sn = house_package_sn;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_time = add_time;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.update_time = update_time;
		this.productList = productList;
	}


	@Override
	public String toString() {
		return "PanoProjectPackageType [SN=" + SN + ", name=" + name
				+ ", space_sn=" + space_sn + ", house_package_sn="
				+ house_package_sn + ", adder_sn=" + adder_sn + ", adder_name="
				+ adder_name + ", add_time=" + add_time + ", updater_sn="
				+ updater_sn + ", updater_name=" + updater_name
				+ ", update_time=" + update_time + ", productList="
				+ productList + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SN == null) ? 0 : SN.hashCode());
		result = prime * result
				+ ((add_time == null) ? 0 : add_time.hashCode());
		result = prime * result
				+ ((adder_name == null) ? 0 : adder_name.hashCode());
		result = prime * result
				+ ((adder_sn == null) ? 0 : adder_sn.hashCode());
		result = prime
				* result
				+ ((house_package_sn == null) ? 0 : house_package_sn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
		result = prime * result
				+ ((space_sn == null) ? 0 : space_sn.hashCode());
		result = prime * result
				+ ((update_time == null) ? 0 : update_time.hashCode());
		result = prime * result
				+ ((updater_name == null) ? 0 : updater_name.hashCode());
		result = prime * result
				+ ((updater_sn == null) ? 0 : updater_sn.hashCode());
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
		PanoProjectPackageType other = (PanoProjectPackageType) obj;
		if (SN == null) {
			if (other.SN != null)
				return false;
		} else if (!SN.equals(other.SN))
			return false;
		if (add_time == null) {
			if (other.add_time != null)
				return false;
		} else if (!add_time.equals(other.add_time))
			return false;
		if (adder_name == null) {
			if (other.adder_name != null)
				return false;
		} else if (!adder_name.equals(other.adder_name))
			return false;
		if (adder_sn == null) {
			if (other.adder_sn != null)
				return false;
		} else if (!adder_sn.equals(other.adder_sn))
			return false;
		if (house_package_sn == null) {
			if (other.house_package_sn != null)
				return false;
		} else if (!house_package_sn.equals(other.house_package_sn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (space_sn == null) {
			if (other.space_sn != null)
				return false;
		} else if (!space_sn.equals(other.space_sn))
			return false;
		if (update_time == null) {
			if (other.update_time != null)
				return false;
		} else if (!update_time.equals(other.update_time))
			return false;
		if (updater_name == null) {
			if (other.updater_name != null)
				return false;
		} else if (!updater_name.equals(other.updater_name))
			return false;
		if (updater_sn == null) {
			if (other.updater_sn != null)
				return false;
		} else if (!updater_sn.equals(other.updater_sn))
			return false;
		return true;
	}


	public Long getSN() {
		return SN;
	}


	public void setSN(Long sN) {
		SN = sN;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getSpace_sn() {
		return space_sn;
	}


	public void setSpace_sn(Long space_sn) {
		this.space_sn = space_sn;
	}


	public Long getHouse_package_sn() {
		return house_package_sn;
	}


	public void setHouse_package_sn(Long house_package_sn) {
		this.house_package_sn = house_package_sn;
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


	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
		this.productList = productList;
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
