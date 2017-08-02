package com.focus3d.pano.model;

import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PanoUserLongin implements CommonModel{
	
	private static final long serialVersionUID = 3618489051854302683L;
	private Long sn;
	private String nick_name;  //昵称
	private Long head_img_sn;	//头像
	private String city;  //城市
	private int is_allocate_space; //是否分配空间
	private String mobile;  //手机
	private String emale;  //邮箱
	private String wx_id; //微信ID
	private Long adder_sn; //添加人id
	private String adder_name; //添加姓名
	private Date add_time; //添加时间
	private Long updater_sn; //修改人id
	private String updater_name; //修改人姓名
	private Date update_time;  //修改时间
	private String name;   //姓名
	private int sex;  //性别
	private String cert_no; //身份证号码
	private String password; //密码
	private int status;
	private int role_user;		      //用户
	private int role_basics;		//基础信息
	private int role_product;	     //产品
	private int role_houses;		//楼盘
	private int role_role;			//权限
	private int role_order;		//订单
	public PanoUserLongin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PanoUserLongin(Long sn, String nick_name, Long head_img_sn,
			String city, int is_allocate_space, String mobile, String emale,
			String wx_id, Long adder_sn, String adder_name, Date add_time,
			Long updater_sn, String updater_name, Date update_time,
			String name, int sex, String cert_no, String password, int status,
			int role_user, int role_basics, int role_product, int role_houses,
			int role_role, int role_order) {
		super();
		this.sn = sn;
		this.nick_name = nick_name;
		this.head_img_sn = head_img_sn;
		this.city = city;
		this.is_allocate_space = is_allocate_space;
		this.mobile = mobile;
		this.emale = emale;
		this.wx_id = wx_id;
		this.adder_sn = adder_sn;
		this.adder_name = adder_name;
		this.add_time = add_time;
		this.updater_sn = updater_sn;
		this.updater_name = updater_name;
		this.update_time = update_time;
		this.name = name;
		this.sex = sex;
		this.cert_no = cert_no;
		this.password = password;
		this.status = status;
		this.role_user = role_user;
		this.role_basics = role_basics;
		this.role_product = role_product;
		this.role_houses = role_houses;
		this.role_role = role_role;
		this.role_order = role_order;
	}
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public Long getHead_img_sn() {
		return head_img_sn;
	}
	public void setHead_img_sn(Long head_img_sn) {
		this.head_img_sn = head_img_sn;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIs_allocate_space() {
		return is_allocate_space;
	}
	public void setIs_allocate_space(int is_allocate_space) {
		this.is_allocate_space = is_allocate_space;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmale() {
		return emale;
	}
	public void setEmale(String emale) {
		this.emale = emale;
	}
	public String getWx_id() {
		return wx_id;
	}
	public void setWx_id(String wx_id) {
		this.wx_id = wx_id;
	}
	public Long getAdder_sn() {
		return adder_sn;
	}
	public void setAdder_sn(Long adder_sn) {
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
	public Long getUpdater_sn() {
		return updater_sn;
	}
	public void setUpdater_sn(Long updater_sn) {
		this.updater_sn = updater_sn;
	}
	public String getUpdater_name() {
		return updater_name;
	}
	public void setUpdater_name(String updater_name) {
		this.updater_name = updater_name;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
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
	public String getCert_no() {
		return cert_no;
	}
	public void setCert_no(String cert_no) {
		this.cert_no = cert_no;
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
	public int getRole_user() {
		return role_user;
	}
	public void setRole_user(int role_user) {
		this.role_user = role_user;
	}
	public int getRole_basics() {
		return role_basics;
	}
	public void setRole_basics(int role_basics) {
		this.role_basics = role_basics;
	}
	public int getRole_product() {
		return role_product;
	}
	public void setRole_product(int role_product) {
		this.role_product = role_product;
	}
	public int getRole_houses() {
		return role_houses;
	}
	public void setRole_houses(int role_houses) {
		this.role_houses = role_houses;
	}
	public int getRole_role() {
		return role_role;
	}
	public void setRole_role(int role_role) {
		this.role_role = role_role;
	}
	public int getRole_order() {
		return role_order;
	}
	public void setRole_order(int role_order) {
		this.role_order = role_order;
	}
	@Override
	public String toString() {
		return "PanoUserLongin [sn=" + sn + ", nick_name=" + nick_name
				+ ", head_img_sn=" + head_img_sn + ", city=" + city
				+ ", is_allocate_space=" + is_allocate_space + ", mobile="
				+ mobile + ", emale=" + emale + ", wx_id=" + wx_id
				+ ", adder_sn=" + adder_sn + ", adder_name=" + adder_name
				+ ", add_time=" + add_time + ", updater_sn=" + updater_sn
				+ ", updater_name=" + updater_name + ", update_time="
				+ update_time + ", name=" + name + ", sex=" + sex
				+ ", cert_no=" + cert_no + ", password=" + password
				+ ", status=" + status + ", role_user=" + role_user
				+ ", role_basics=" + role_basics + ", role_product="
				+ role_product + ", role_houses=" + role_houses
				+ ", role_role=" + role_role + ", role_order=" + role_order
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sn == null) ? 0 : sn.hashCode());
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
		PanoUserLongin other = (PanoUserLongin) obj;
		if (sn == null) {
			if (other.sn != null)
				return false;
		} else if (!sn.equals(other.sn))
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
	public String getEncryptSn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEncryptSn(String encryptSn) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
