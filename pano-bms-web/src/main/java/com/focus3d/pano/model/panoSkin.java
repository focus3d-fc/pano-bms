package com.focus3d.pano.model;

import java.io.Serializable;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;

/**
 * 基础信息的导航图标
 * @author Administrator
 *
 */
public class panoSkin implements  CommonModel{
		
	private static final long serialVersionUID = 2988752298777022811L;
		private Long sn;
		private long SN;
		private String name;  //名称
		private Long img_sn;	//图片
		private String css;
		private String js;
		private Long adder_sn; // 添加人ID
		private String adder_name; //添加人姓名
		private Date add_time;  // 添加时间
		private Long updater_sn; //修改人Id
		private String updater_name; //修改人姓名
		private String update_time;  //修改时间
		public Long getSn() {
			return sn;
		}
		public void setSn(Long sn) {
			this.sn = sn;
		}
		public long getSN() {
			return SN;
		}
		public void setSN(long sN) {
			SN = sN;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getImg_sn() {
			return img_sn;
		}
		public void setImg_sn(Long img_sn) {
			this.img_sn = img_sn;
		}
		public String getCss() {
			return css;
		}
		public void setCss(String css) {
			this.css = css;
		}
		public String getJs() {
			return js;
		}
		public void setJs(String js) {
			this.js = js;
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
		public String getUpdate_time() {
			return update_time;
		}
		public void setUpdate_time(String update_time) {
			this.update_time = update_time;
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
