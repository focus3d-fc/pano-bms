package com.focus3d.pano.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class AddToCar implements Serializable,CommonModel{

	private static final long serialVersionUID = -2328171769486985929L;

	private String style_name;
	private long package_sn;
	private String package_name;
	private long package_img_sn;
	private BigDecimal package_price;
	private BigDecimal package_discount_price;
	private String house_name;
	private long house_package_sn;
	
	
	
	public AddToCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public AddToCar(String style_name, long package_sn, String package_name,
			long package_img_sn, BigDecimal package_price,
			BigDecimal package_discount_price, String house_name,
			long house_package_sn) {
		super();
		this.style_name = style_name;
		this.package_sn = package_sn;
		this.package_name = package_name;
		this.package_img_sn = package_img_sn;
		this.package_price = package_price;
		this.package_discount_price = package_discount_price;
		this.house_name = house_name;
		this.house_package_sn = house_package_sn;
	}



	@Override
	public String toString() {
		return "AddToCar [style_name=" + style_name + ", package_sn="
				+ package_sn + ", package_name=" + package_name
				+ ", package_img_sn=" + package_img_sn + ", package_price="
				+ package_price + ", package_discount_price="
				+ package_discount_price + ", house_name=" + house_name
				+ ", house_package_sn=" + house_package_sn + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((house_name == null) ? 0 : house_name.hashCode());
		result = prime * result
				+ (int) (house_package_sn ^ (house_package_sn >>> 32));
		result = prime
				* result
				+ ((package_discount_price == null) ? 0
						: package_discount_price.hashCode());
		result = prime * result
				+ (int) (package_img_sn ^ (package_img_sn >>> 32));
		result = prime * result
				+ ((package_name == null) ? 0 : package_name.hashCode());
		result = prime * result
				+ ((package_price == null) ? 0 : package_price.hashCode());
		result = prime * result + (int) (package_sn ^ (package_sn >>> 32));
		result = prime * result
				+ ((style_name == null) ? 0 : style_name.hashCode());
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
		AddToCar other = (AddToCar) obj;
		if (house_name == null) {
			if (other.house_name != null)
				return false;
		} else if (!house_name.equals(other.house_name))
			return false;
		if (house_package_sn != other.house_package_sn)
			return false;
		if (package_discount_price == null) {
			if (other.package_discount_price != null)
				return false;
		} else if (!package_discount_price.equals(other.package_discount_price))
			return false;
		if (package_img_sn != other.package_img_sn)
			return false;
		if (package_name == null) {
			if (other.package_name != null)
				return false;
		} else if (!package_name.equals(other.package_name))
			return false;
		if (package_price == null) {
			if (other.package_price != null)
				return false;
		} else if (!package_price.equals(other.package_price))
			return false;
		if (package_sn != other.package_sn)
			return false;
		if (style_name == null) {
			if (other.style_name != null)
				return false;
		} else if (!style_name.equals(other.style_name))
			return false;
		return true;
	}



	public String getStyle_name() {
		return style_name;
	}



	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}



	public long getPackage_sn() {
		return package_sn;
	}



	public void setPackage_sn(long package_sn) {
		this.package_sn = package_sn;
	}



	public String getPackage_name() {
		return package_name;
	}



	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}



	public long getPackage_img_sn() {
		return package_img_sn;
	}



	public void setPackage_img_sn(long package_img_sn) {
		this.package_img_sn = package_img_sn;
	}



	public BigDecimal getPackage_price() {
		return package_price;
	}



	public void setPackage_price(BigDecimal package_price) {
		this.package_price = package_price;
	}



	public BigDecimal getPackage_discount_price() {
		return package_discount_price;
	}



	public void setPackage_discount_price(BigDecimal package_discount_price) {
		this.package_discount_price = package_discount_price;
	}



	public String getHouse_name() {
		return house_name;
	}



	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}



	public long getHouse_package_sn() {
		return house_package_sn;
	}



	public void setHouse_package_sn(long house_package_sn) {
		this.house_package_sn = house_package_sn;
	}



	/**
	 * --------------------------------------------------------------------------
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
