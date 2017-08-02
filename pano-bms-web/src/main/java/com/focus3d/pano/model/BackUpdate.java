package com.focus3d.pano.model;

import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;
/**
 * 
 * @author 权限管理修改 role  resource合并使用类
 *
 */
public class BackUpdate implements CommonModel{
	private Long sn;
	private String role_name;
	private int role_basics;
	private int role_houses;
	private int role_product;
	private int role_user;
	private int role_role;
	private int role_order;
	
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
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getRole_basics() {
		return role_basics;
	}
	public void setRole_basics(int role_basics) {
		this.role_basics = role_basics;
	}
	public int getRole_houses() {
		return role_houses;
	}
	public void setRole_houses(int role_houses) {
		this.role_houses = role_houses;
	}
	public int getRole_product() {
		return role_product;
	}
	public void setRole_product(int role_product) {
		this.role_product = role_product;
	}
	public int getRole_user() {
		return role_user;
	}
	public void setRole_user(int role_user) {
		this.role_user = role_user;
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
