package com.demo.bean;

import java.util.List;

public class PageBean {
	private int currentPage;//��ǰҳ��
	private int totalCount;//������
	private int totalPage;//��ҳ��
	private int currentCount;//ÿ��ҳ��
	private List<Album> ps;//ÿҳ��ʾ����������
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public List<Album> getPs() {
		return ps;
	}
	public void setPs(List<Album> ps2) {
		this.ps = ps2;
	}


}
