package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class User implements Serializable,CommonModel{

	private static final long serialVersionUID = -1423892477614156650L;

	private long id;//1.主键，用户id--------------后台用户表
	private String nick_name;//2.昵称----------后台用户表
	private String name;//3.姓名
	private int sex;//4.性别：1-2
	private String sex_str;//4.2性别：女-男
	private String mobile;//5.手机号------------后台用户表
	private int status;//6.状态1-2
	private String status_str;//6.2状态：正常-暂停
	private String city;//7.城市----------------后台用户表
	private String email;//8.邮箱---------------后台用户表
	private String cert_no;//9.身份证
	private String role_name;//10.角色----------------角色表
	private String password;
	private long role_sn;
	/**     
	 * 其他字段
	 * --------------------------------------------------
	 */
	private long head_img_sn;//11.头像
	private int is_allocate_space;//12.是否分配空间 0-没有分配 1-分配
	private String wx_id;//13.微信id
	private long adder_sn;//14.添加人id
	private String adder_name;//15.添加人姓名
	private String add_time;//16.添加时间
	private long updater_sn;//17.修改人id
	private String updater_name;//18.修改人姓名
	private String update_time;//19.修改时间
	
/**---------分页属性-----------------------------------------*/
	private int startIndex;// 起始下标
	private int pagesize;// 当前页
/**---------分页属性-----------------------------------------*/
	
	//add by lihaijun 2017/8/17
	private Integer isAllocateSpace;//用户空间
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(long id, String nick_name, String name, int sex, String sex_str,
		String mobile, int status, String status_str, String city,
		String email, String cert_no, String role_name, String password,
		long role_sn, long head_img_sn, int is_allocate_space, String wx_id,
		long adder_sn, String adder_name, String add_time, long updater_sn,
		String updater_name, String update_time, int startIndex, int pagesize) {
	super();
	this.id = id;
	this.nick_name = nick_name;
	this.name = name;
	this.sex = sex;
	this.sex_str = sex_str;
	this.mobile = mobile;
	this.status = status;
	this.status_str = status_str;
	this.city = city;
	this.email = email;
	this.cert_no = cert_no;
	this.role_name = role_name;
	this.password = password;
	this.role_sn = role_sn;
	this.head_img_sn = head_img_sn;
	this.is_allocate_space = is_allocate_space;
	this.wx_id = wx_id;
	this.adder_sn = adder_sn;
	this.adder_name = adder_name;
	this.add_time = add_time;
	this.updater_sn = updater_sn;
	this.updater_name = updater_name;
	this.update_time = update_time;
	this.startIndex = startIndex;
	this.pagesize = pagesize;
}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNick_name() {
		return nick_name;
	}


	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getSex_str() {
		return sex_str;
	}


	public void setSex_str(String sex_str) {
		this.sex_str = sex_str;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCert_no() {
		return cert_no;
	}


	public void setCert_no(String cert_no) {
		this.cert_no = cert_no;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getRole_sn() {
		return role_sn;
	}


	public void setRole_sn(long role_sn) {
		this.role_sn = role_sn;
	}


	public long getHead_img_sn() {
		return head_img_sn;
	}


	public void setHead_img_sn(long head_img_sn) {
		this.head_img_sn = head_img_sn;
	}


	public int getIs_allocate_space() {
		return is_allocate_space;
	}


	public void setIs_allocate_space(int is_allocate_space) {
		this.is_allocate_space = is_allocate_space;
	}


	public String getWx_id() {
		return wx_id;
	}


	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
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


	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nick_name=" + nick_name + ", name=" + name
				+ ", sex=" + sex + ", sex_str=" + sex_str + ", mobile="
				+ mobile + ", status=" + status + ", status_str=" + status_str
				+ ", city=" + city + ", email=" + email + ", cert_no="
				+ cert_no + ", role_name=" + role_name + ", password="
				+ password + ", role_sn=" + role_sn + ", head_img_sn="
				+ head_img_sn + ", is_allocate_space=" + is_allocate_space
				+ ", wx_id=" + wx_id + ", adder_sn=" + adder_sn
				+ ", adder_name=" + adder_name + ", add_time=" + add_time
				+ ", updater_sn=" + updater_sn + ", updater_name="
				+ updater_name + ", update_time=" + update_time
				+ ", startIndex=" + startIndex + ", pagesize=" + pagesize + "]";
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
		User other = (User) obj;
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


	public Integer getIsAllocateSpace() {
		return isAllocateSpace;
	}


	public void setIsAllocateSpace(Integer isAllocateSpace) {
		this.isAllocateSpace = isAllocateSpace;
	}
}
