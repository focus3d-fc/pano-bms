package com.focus3d.pano.model;


import java.util.Date;
import java.util.List;

import com.focus3d.pano.common.model.CommonModel;

public class Paging implements CommonModel{
	 private int totalRecord;   //总记录数
	 private int pageSize = 5;  //每页显示的数
	 private int pageNum;   //当前页数
	 private int totalPages;  //	总页数计算的
	 private int startIndex;  //每页查询的索引位置
	 private List list;//存放每页查询出来的记录
	 
	 public Paging(int totalRecord,int pageNum){
		 this.totalRecord = totalRecord;
		 this.pageNum = pageNum;
		 this.totalPages = (totalRecord%pageSize==0)? totalRecord/pageSize : totalRecord/pageSize+1;
		 this.startIndex = (pageNum - 1)*pageSize;
		 
	 }
	 
	 public Paging(){}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
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
