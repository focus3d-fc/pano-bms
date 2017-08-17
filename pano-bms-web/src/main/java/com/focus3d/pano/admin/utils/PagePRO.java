package com.focus3d.pano.admin.utils;

import java.util.Date;
import java.util.List;

import com.focus3d.pano.common.model.CommonModel;
import com.focus3d.pano.model.User;

public class PagePRO implements CommonModel {

	private int startIndex;// 起始下标

	private int currentPage;// 当前页

	private int pagesize = 1;// 显示几条记录

	private int count; // 总记录数

	private int totalPages;// 总页数

	private List<User> userList;

	public PagePRO() {

	}

	public PagePRO(int count, int currentPage) {

		this.count = count;// 总记录数

		this.currentPage = currentPage;// 当前页
		if (count != 1) {
			if (pagesize != 1) {
				if (count % this.pagesize == 0) {// 判断总记录书除以每页的记录数是否为0
					this.totalPages = count / this.pagesize;

				} else {
					this.totalPages = count / this.pagesize + 1;
				}
			} else {
				this.totalPages = count;
			}

		} else {
			this.totalPages = 1;
		}
		this.startIndex = (this.currentPage - 1) * this.pagesize;
	}

	@Override
	public String toString() {
		return "Page [startIndex=" + startIndex + ", currentPage="
				+ currentPage + ", pagesize=" + pagesize + ", count=" + count
				+ ", totalPages=" + totalPages + ", userList=" + userList + "]";
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * 其他方法
	 * -----------------------------------------------------------------------
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
