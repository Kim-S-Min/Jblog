package com.bitacademy.jblog.vo;

public class BlogVo {
	private Long userNo;
	private String blogTitle;
	private String logoFile;
	
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
	
	public String getLogoFile() {
		return logoFile;
	}
	
	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	
	//	toString
	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + "]";
	}
}