package cn.xiedacon.bar.util;

import java.util.List;

public class PageBean<T> {

	// 每页个数
	private Integer limit;
	// 总个数
	private Integer totalCount;
	// 第几页
	private Integer page;
	// 总页数
	private Integer totalPage;
	// 数据集
	private List<T> beanList;
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	@Override
	public String toString() {
		return "PageBean [limit=" + limit + ", totalCount=" + totalCount + ", page=" + page + ", totalPage=" + totalPage + ", beanList=" + beanList + "]";
	}
	
}
