package com.focus3d.pano.model;

import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

public class PanoBmRoleResource implements CommonModel{
		private Long sn;		//序列
		private Long role_sn;		//角色编号
		private Long resource_sn;		//资源编号
		private Long adder_sn;
		private String adder_name;
		private Date add_time;
		private Long updater_sn;
		private String updater_name;
		private Long updater_time;
		private int role_user;		//用户
		private int role_basics;		//基础信息
		private int role_product;	     //产品
		private int role_houses;		//楼盘
		private int role_role;			//权限
		private int role_order;		//订单
		
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
		public Long getRole_sn() {
			return role_sn;
		}
		public void setRole_sn(Long role_sn) {
			this.role_sn = role_sn;
		}
		public Long getResource_sn() {
			return resource_sn;
		}
		public void setResource_sn(Long resource_sn) {
			this.resource_sn = resource_sn;
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
		public Long getUpdater_time() {
			return updater_time;
		}
		public void setUpdater_time(Long updater_time) {
			this.updater_time = updater_time;
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
