/*
 * Copyright 2011 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.focus3d.pano.admin.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 * *
 * @author lihaijun
 *
 */
public class PageInfo implements Serializable {
	private static final long serialVersionUID = -553736326800368491L;
	private Integer currentPage = 1;
	/** 每页显示的条数 */
	private Integer perPageInt = 10;
	/** 查询数据库开始记录数 */
	private Integer startRecord = 0;
	/** 查询数据库结束记录数 */
	private Integer endRecord = 0;
	/** 总记录数 */
	private Integer totalRecords = 0;
	/** 总页数 */
	private Integer totalPage = 0;
	/** 访问路径 */
	private String linkUrl;
	/** 数据list */
	private List<Object> dataList;

	public List<Object> getDataList() {
		if (null == this.dataList) {
			return new ArrayList<Object>();
		}
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public PageInfo setCurrentPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		this.currentPage = currentPage < 1 ? 1 : currentPage;
		calcSplitPage();
		return this;
	}

	public Integer getPerPageInt() {
		return perPageInt;
	}

	public PageInfo setPerPageInt(Integer perPageInt) {
		if (perPageInt == null) {
			perPageInt = 0;
		}
		this.perPageInt = perPageInt < 1 ? 10 : perPageInt;
		calcSplitPage();
		calcTotalPage();
		return this;
	}

	/** 计算分页信息 */
	private void calcSplitPage() {
		startRecord = ((currentPage - 1) < 0 ? 0 : (currentPage - 1))
				* perPageInt;
		// Deleted by wangliang for MySQL at 2011/6/28 begin
		// startRecord = startRecord + 1;
		// Deleted by wangliang for MySQL at 2011/6/28 end
		endRecord = currentPage * perPageInt;
	}

	public Integer getStartRecord() {
		return startRecord;
	}

	public Integer getEndRecord() {
		return endRecord;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		if (totalRecords == null) {
			totalRecords = 0;
		}
		this.totalRecords = totalRecords;
		calcTotalPage();
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 计算总页数信息
	 */
	private void calcTotalPage() {
		totalPage = totalRecords / perPageInt
				+ (totalRecords % perPageInt > 0 ? 1 : 0);
		totalPage = totalPage < 1 ? 1 : totalPage;
	}

	/**
	 * 对分页信息进行处理：<br>
	 * 1，对记录总数进行赋值。<br>
	 * 2，每页显示条数处理：如果页面中没有赋值入口，则重新设置值。<br>
	 * 3，当前页值合理性处理：如果当前页大于总页数，则当前页值等于总页数
	 *
	 * @param totalRecords
	 *            记录总数
	 * @param perPageInt
	 *            每页显示条数
	 */
	public void pageInfoInvoke(Integer totalRecords, Integer perPageInt) {
		if (getPerPageInt() == 0) {
			setPerPageInt(perPageInt);
		}
		setTotalRecords(totalRecords);
		if (getCurrentPage() > getTotalPage()) {
			setCurrentPage(getTotalPage());
		}
	}
}
