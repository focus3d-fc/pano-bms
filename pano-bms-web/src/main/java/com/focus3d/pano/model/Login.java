package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;


public class Login implements Serializable,CommonModel{

	private static final long serialVersionUID = 8110300682689883710L;

	private long sn;
	private String login_name;//登录名，用昵称
	private String password;
	private int status;
	private String status_str;
	private long user_sn;
	private int login_times;//登陆次数
	private String summary;//简介
	private String last_login_time;//最后登录时间
	private long adder_sn;
	private String adder_name;
	private String add_time;
	private long updater_sn;
	private String updater_name;
	private String update_time;
	private String cert_no;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Login(long sn, String login_name, String password, int status,
			String status_str, long user_sn, int login_times, String summary,
			String last_login_time, long adder_sn, String adder_name,
			String add_time, long updater_sn, String updater_name,
			String update_time, String cert_no) {
		super();
		this.sn = sn;
		this.login_name = login_name;
		this.password = password;
		this.status = status;
		this.status_str = status_str;
		this.user_sn = user_sn;
		this.login_times = login_times;
		this.summary = summary;
		this.last_login_time = last_login_time;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_time = add_time;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.update_time = update_time;
		this.cert_no = cert_no;
	}


	public String getLogin_name() {
		return login_name;
	}


	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getStatus_str() {
		return status_str;
	}


	public void setStatus_str(String status_str) {
		this.status_str = status_str;
	}


	public long getUser_sn() {
		return user_sn;
	}


	public void setUser_sn(long user_sn) {
		this.user_sn = user_sn;
	}


	public int getLogin_times() {
		return login_times;
	}


	public void setLogin_times(int login_times) {
		this.login_times = login_times;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getLast_login_time() {
		return last_login_time;
	}


	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
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


	public String getCert_no() {
		return cert_no;
	}


	public void setCert_no(String cert_no) {
		this.cert_no = cert_no;
	}


	public void setSn(long sn) {
		this.sn = sn;
	}


	@Override
	public String toString() {
		return "Login [sn=" + sn + ", login_name=" + login_name + ", password="
				+ password + ", status=" + status + ", status_str="
				+ status_str + ", user_sn=" + user_sn + ", login_times="
				+ login_times + ", summary=" + summary + ", last_login_time="
				+ last_login_time + ", adder_sn=" + adder_sn + ", adder_name="
				+ adder_name + ", add_time=" + add_time + ", updater_sn="
				+ updater_sn + ", updater_name=" + updater_name
				+ ", update_time=" + update_time + ", cert_no=" + cert_no + "]";
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
		Login other = (Login) obj;
		if (sn != other.sn)
			return false;
		return true;
	}


	/**
	 * 其他方法
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






















