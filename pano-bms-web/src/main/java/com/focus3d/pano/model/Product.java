package com.focus3d.pano.model;

import java.math.BigDecimal;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;



public class Product implements CommonModel{
	  private Long sn;

	 
	    private String id;

	
	    private String name;

	  
	    private String brand;

	
	    private BigDecimal price;

	  
	    private Integer status;

	
	    private String summary;


		public Long getSn() {
			return sn;
		}


		public void setSn(Long sn) {
			this.sn = sn;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getBrand() {
			return brand;
		}


		public void setBrand(String brand) {
			this.brand = brand;
		}


		public BigDecimal getPrice() {
			return price;
		}


		public void setPrice(BigDecimal price) {
			this.price = price;
		}


		public Integer getStatus() {
			return status;
		}


		public void setStatus(Integer status) {
			this.status = status;
		}


		public String getSummary() {
			return summary;
		}


		public void setSummary(String summary) {
			this.summary = summary;
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
