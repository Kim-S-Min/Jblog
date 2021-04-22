package com.bitacademy.jblog.vo;

public class BlogVo {
	private Long userNo;
	private String blogTitle;
	
	//	Getter/Setter
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	
	//	toString
	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", blogTitle=" + blogTitle + "]";
	}
}