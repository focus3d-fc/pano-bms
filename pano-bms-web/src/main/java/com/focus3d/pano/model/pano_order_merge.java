package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class pano_order_merge implements Serializable,CommonModel{

	private static final long serialVersionUID = 8805185573494261408L;
	
	private long SN;
	private String MERGE_ORDER_NUM;
	private String ORDER_NUM;
	
	
	public pano_order_merge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public pano_order_merge(long sN, String mERGE_ORDER_NUM, String oRDER_NUM) {
		super();
		SN = sN;
		MERGE_ORDER_NUM = mERGE_ORDER_NUM;
		ORDER_NUM = oRDER_NUM;
	}



	@Override
	public String toString() {
		return "pano_order_merge [SN=" + SN + ", MERGE_ORDER_NUM="
				+ MERGE_ORDER_NUM + ", ORDER_NUM=" + ORDER_NUM + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((MERGE_ORDER_NUM == null) ? 0 : MERGE_ORDER_NUM.hashCode());
		result = prime * result
				+ ((ORDER_NUM == null) ? 0 : ORDER_NUM.hashCode());
		result = prime * result + (int) (SN ^ (SN >>> 32));
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
		pano_order_merge other = (pano_order_merge) obj;
		if (MERGE_ORDER_NUM == null) {
			if (other.MERGE_ORDER_NUM != null)
				return false;
		} else if (!MERGE_ORDER_NUM.equals(other.MERGE_ORDER_NUM))
			return false;
		if (ORDER_NUM == null) {
			if (other.ORDER_NUM != null)
				return false;
		} else if (!ORDER_NUM.equals(other.ORDER_NUM))
			return false;
		if (SN != other.SN)
			return false;
		return true;
	}



	public long getSN() {
		return SN;
	}



	public void setSN(long sN) {
		SN = sN;
	}



	public String getMERGE_ORDER_NUM() {
		return MERGE_ORDER_NUM;
	}



	public void setMERGE_ORDER_NUM(String mERGE_ORDER_NUM) {
		MERGE_ORDER_NUM = mERGE_ORDER_NUM;
	}



	public String getORDER_NUM() {
		return ORDER_NUM;
	}



	public void setORDER_NUM(String oRDER_NUM) {
		ORDER_NUM = oRDER_NUM;
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
