package com.qianfeng.auction.util;

import java.math.BigDecimal;
import java.util.List;

public class PageVO<T> {
	List<T> list;
	BigDecimal pageIndex;
	BigDecimal pageNumber;
	BigDecimal total;
	BigDecimal endPage;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public BigDecimal getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
	}

	public BigDecimal getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(BigDecimal pageNumber) {
		this.pageNumber = pageNumber;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getEndPage() {
		return endPage;
	}

	public void setEndPage(BigDecimal endPage) {
		this.endPage = endPage;
	}

}
