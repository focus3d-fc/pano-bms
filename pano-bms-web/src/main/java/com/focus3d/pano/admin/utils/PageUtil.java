package com.focus3d.pano.admin.utils;

import java.util.List;

public class PageUtil {
	 private int allPageSize;// 数据库总条数(外部传入)
	    private int pageNum=1;// 当前第几页(外部传入)
	    private int pageShowSize = 5;// 每页多少条数据
	    private int allPageNum;// 一共多少页
	    private int selectStart;// 数据库的起始搜索位置
	    private int indexStart;// 前台页面的起始索引
	    private int indexEnd;// 前台页面的结束索引
	    private List<Object> pageInfo;// 从数据库查询出来的数据

	    public PageUtil() {
	    }

	    public PageUtil(int allPageSize, int pageNum,int pageShowSize) {
	        this.allPageSize = allPageSize;
	        this.pageNum = pageNum;
	        this.pageShowSize = pageShowSize;
	        if (allPageSize % pageShowSize == 0) {
	            this.allPageNum = this.allPageSize / this.pageShowSize;
	        } else {
	            this.allPageNum = this.allPageSize / this.pageShowSize + 1;
	        }
	        this.selectStart = (this.pageNum - 1) * this.pageShowSize;
	        if (this.allPageNum < 3) {
	            this.indexStart = 1;
	            this.indexEnd = this.allPageNum;
	        } else {
	            this.indexStart = this.pageNum - 2;// 前台页面的起始页是当前页数-2  要和前台的第一页控制一样第一页控制大于多少,这里就得减去多少
	            this.indexEnd = this.pageNum + 2;// 前台页面的结束页是当前页数+2
	            if (this.indexStart < 1) {
	                this.indexStart = 1;
	                this.indexEnd = 5;
	            } else if (this.indexEnd > this.allPageNum) {
	                this.indexStart = this.allPageNum - 5;
	                this.indexEnd = this.allPageNum;
	            }
	        }
	    }

	    public int getAllPageSize() {
	        return allPageSize;
	    }

	    public void setAllPageSize(int allPageSize) {
	        this.allPageSize = allPageSize;
	    }

	    public int getPageNum() {
	        return pageNum;
	    }

	    public void setPageNum(int pageNum) {
	        this.pageNum = pageNum;
	    }

	    public int getPageShowSize() {
	        return pageShowSize;
	    }

	    public void setPageShowSize(int pageShowSize) {
	        this.pageShowSize = pageShowSize;
	    }

	    public int getAllPageNum() {
	        return allPageNum;
	    }

	    public void setAllPageNum(int allPageNum) {
	        this.allPageNum = allPageNum;
	    }

	    public int getSelectStart() {
	        return selectStart;
	    }

	    public void setSelectStart(int selectStart) {
	        this.selectStart = selectStart;
	    }

	    public int getIndexStart() {
	        return indexStart;
	    }

	    public void setIndexStart(int indexStart) {
	        this.indexStart = indexStart;
	    }

	    public int getIndexEnd() {
	        return indexEnd;
	    }

	    public void setIndexEnd(int indexEnd) {
	        this.indexEnd = indexEnd;
	    }

		public List<Object> getPageInfo() {
			return pageInfo;
		}

		public void setPageInfo(List<Object> pageInfo) {
			this.pageInfo = pageInfo;
		}

	
}
