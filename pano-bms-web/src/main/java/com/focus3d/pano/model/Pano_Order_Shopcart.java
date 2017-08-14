package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class Pano_Order_Shopcart  implements Serializable,CommonModel{

	private static final long serialVersionUID = -2772227929374002762L;

	private long SN;
	private long USER_SN;
	private long HOUSE_PACKAGE_SN;
	private int PURCHASE_NUM;
	private long ADDER_SN;
	private String ADDER_NAME;
	private String ADD_TIME;
	private long UPDATER_SN;
	private String UPDATER_NAME;
	private String UPDATE_TIME;
	
	public Pano_Order_Shopcart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pano_Order_Shopcart(long sN, long uSER_SN, long hOUSE_PACKAGE_SN,
			int pURCHASE_NUM, long aDDER_SN, String aDDER_NAME,
			String aDD_TIME, long uPDATER_SN, String uPDATER_NAME,
			String uPDATE_TIME) {
		super();
		SN = sN;
		USER_SN = uSER_SN;
		HOUSE_PACKAGE_SN = hOUSE_PACKAGE_SN;
		PURCHASE_NUM = pURCHASE_NUM;
		ADDER_SN = aDDER_SN;
		ADDER_NAME = aDDER_NAME;
		ADD_TIME = aDD_TIME;
		UPDATER_SN = uPDATER_SN;
		UPDATER_NAME = uPDATER_NAME;
		UPDATE_TIME = uPDATE_TIME;
	}

	@Override
	public String toString() {
		return "Pano_Order_Shopcart [SN=" + SN + ", USER_SN=" + USER_SN
				+ ", HOUSE_PACKAGE_SN=" + HOUSE_PACKAGE_SN + ", PURCHASE_NUM="
				+ PURCHASE_NUM + ", ADDER_SN=" + ADDER_SN + ", ADDER_NAME="
				+ ADDER_NAME + ", ADD_TIME=" + ADD_TIME + ", UPDATER_SN="
				+ UPDATER_SN + ", UPDATER_NAME=" + UPDATER_NAME
				+ ", UPDATE_TIME=" + UPDATE_TIME + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ADDER_NAME == null) ? 0 : ADDER_NAME.hashCode());
		result = prime * result + (int) (ADDER_SN ^ (ADDER_SN >>> 32));
		result = prime * result
				+ ((ADD_TIME == null) ? 0 : ADD_TIME.hashCode());
		result = prime * result
				+ (int) (HOUSE_PACKAGE_SN ^ (HOUSE_PACKAGE_SN >>> 32));
		result = prime * result + PURCHASE_NUM;
		result = prime * result + (int) (SN ^ (SN >>> 32));
		result = prime * result
				+ ((UPDATER_NAME == null) ? 0 : UPDATER_NAME.hashCode());
		result = prime * result + (int) (UPDATER_SN ^ (UPDATER_SN >>> 32));
		result = prime * result
				+ ((UPDATE_TIME == null) ? 0 : UPDATE_TIME.hashCode());
		result = prime * result + (int) (USER_SN ^ (USER_SN >>> 32));
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
		Pano_Order_Shopcart other = (Pano_Order_Shopcart) obj;
		if (ADDER_NAME == null) {
			if (other.ADDER_NAME != null)
				return false;
		} else if (!ADDER_NAME.equals(other.ADDER_NAME))
			return false;
		if (ADDER_SN != other.ADDER_SN)
			return false;
		if (ADD_TIME == null) {
			if (other.ADD_TIME != null)
				return false;
		} else if (!ADD_TIME.equals(other.ADD_TIME))
			return false;
		if (HOUSE_PACKAGE_SN != other.HOUSE_PACKAGE_SN)
			return false;
		if (PURCHASE_NUM != other.PURCHASE_NUM)
			return false;
		if (SN != other.SN)
			return false;
		if (UPDATER_NAME == null) {
			if (other.UPDATER_NAME != null)
				return false;
		} else if (!UPDATER_NAME.equals(other.UPDATER_NAME))
			return false;
		if (UPDATER_SN != other.UPDATER_SN)
			return false;
		if (UPDATE_TIME == null) {
			if (other.UPDATE_TIME != null)
				return false;
		} else if (!UPDATE_TIME.equals(other.UPDATE_TIME))
			return false;
		if (USER_SN != other.USER_SN)
			return false;
		return true;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sN) {
		SN = sN;
	}

	public long getUSER_SN() {
		return USER_SN;
	}

	public void setUSER_SN(long uSER_SN) {
		USER_SN = uSER_SN;
	}

	public long getHOUSE_PACKAGE_SN() {
		return HOUSE_PACKAGE_SN;
	}

	public void setHOUSE_PACKAGE_SN(long hOUSE_PACKAGE_SN) {
		HOUSE_PACKAGE_SN = hOUSE_PACKAGE_SN;
	}

	public int getPURCHASE_NUM() {
		return PURCHASE_NUM;
	}

	public void setPURCHASE_NUM(int pURCHASE_NUM) {
		PURCHASE_NUM = pURCHASE_NUM;
	}

	public long getADDER_SN() {
		return ADDER_SN;
	}

	public void setADDER_SN(long aDDER_SN) {
		ADDER_SN = aDDER_SN;
	}

	public String getADDER_NAME() {
		return ADDER_NAME;
	}

	public void setADDER_NAME(String aDDER_NAME) {
		ADDER_NAME = aDDER_NAME;
	}

	public String getADD_TIME() {
		return ADD_TIME;
	}

	public void setADD_TIME(String aDD_TIME) {
		ADD_TIME = aDD_TIME;
	}

	public long getUPDATER_SN() {
		return UPDATER_SN;
	}

	public void setUPDATER_SN(long uPDATER_SN) {
		UPDATER_SN = uPDATER_SN;
	}

	public String getUPDATER_NAME() {
		return UPDATER_NAME;
	}

	public void setUPDATER_NAME(String uPDATER_NAME) {
		UPDATER_NAME = uPDATER_NAME;
	}

	public String getUPDATE_TIME() {
		return UPDATE_TIME;
	}

	public void setUPDATE_TIME(String uPDATE_TIME) {
		UPDATE_TIME = uPDATE_TIME;
	}

	/***
	 * ---------------------------------------------------------------
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
