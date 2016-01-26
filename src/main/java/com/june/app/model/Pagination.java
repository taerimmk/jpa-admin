package com.june.app.model;

public class Pagination {
	private long pageIndex = 1;
	private long totalCnt = 0;
	private int pagePerUnit = 10;
	private int pageSize = 10;
	private long totalPageUnit;
	private int firstIndex;
	private String searchKey;
	private String searchVal;

	public long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(long pageIndex) {
		this.pageIndex = pageIndex;
	}

	public long getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(long totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPagePerUnit() {
		return pagePerUnit;
	}

	public void setPagePerUnit(int pagePerUnit) {
		this.pagePerUnit = pagePerUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalPageUnit() {
		if (this.totalCnt > 0) {
			this.totalPageUnit = this.totalCnt / this.pageSize + (this.totalCnt % this.pageSize > 0 ? 1 : 0);
		} else {
			totalPageUnit = 1;
		}
		return totalPageUnit;
	}

	public void setTotalPageUnit(long totalPageUnit) {
		this.totalPageUnit = totalPageUnit;
	}

	public int getFirstIndex() {
		firstIndex = (int) ((this.pageIndex - 1) * this.pageSize);
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchVal() {
		return searchVal;
	}

	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}

	@Override
	public String toString() {
		return "Pagination [pageIndex=" + pageIndex + ", totalCnt=" + totalCnt + ", pagePerUnit=" + pagePerUnit
				+ ", pageSize=" + pageSize + ", totalPageUnit=" + totalPageUnit + ", firstIndex=" + firstIndex
				+ ", searchKey=" + searchKey + ", searchVal=" + searchVal + "]";
	}

}