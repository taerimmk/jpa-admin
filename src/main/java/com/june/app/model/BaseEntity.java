package com.june.app.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Simple JavaBean domain object with an id property. Used as a base class for
 * objects needing this property.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 */
@MappedSuperclass
public class BaseEntity {

	@Transient
	private int pageIndex = 1;
	@Transient
	private int totalCnt = 0;
	@Transient
	private int pagePerUnit = 10;
	@Transient
	private int pageSize = 10;
	@Transient
	private int totalPageUnit;
	@Transient
	private int firstIndex;
	@Transient
	private String searchKey;
	@Transient
	private String searchVal;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
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

	public void setTotalPageUnit(int totalPageUnit) {
		this.totalPageUnit = totalPageUnit;
	}

	public int getFirstIndex() {
		firstIndex = (this.pageIndex - 1) * this.pageSize;
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

}
