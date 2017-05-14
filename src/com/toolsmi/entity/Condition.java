package com.toolsmi.entity;

import java.util.List;
import java.util.Map;

public class Condition {
	private Integer currentPage = 1;
	private Integer pageSize = 1;
	private Integer totalCount;
	private Integer totalPage;

	private String realname;
	private String phone;
	
	private Map<String, Object> emailParams;

	public Map<String, Object> getEmailParams() {
		return emailParams;
	}

	public void setEmailParams(Map<String, Object> emailParams) {
		this.emailParams = emailParams;
	}

	public String getRealname() {
		return realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			if (this.totalCount % this.pageSize == 0) {
				this.totalPage = this.totalCount / this.pageSize;
			} else {
				this.totalPage = this.totalCount / this.pageSize + 1;
			}
		}
	}

	public Integer getTotalPage() {
		return totalPage;
	}

}
