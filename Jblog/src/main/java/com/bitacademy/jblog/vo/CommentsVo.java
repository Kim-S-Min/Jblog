package com.bitacademy.jblog.vo;

import java.util.Date;

public class CommentsVo {
	private Long commentsNo;
	private Long postNo;
	private Long userNo;
	private String commentsContent;
	private Date regDate;
	private String userName;
	
	//	Getter/Setter
	public Long getCommentsNo() {
		return commentsNo;
	}
	public void setCommenstNo(Long commentNo) {
		this.commentsNo = commentNo;
	}
	public Long getPostNo() {
		return postNo;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getCommentsContent() {
		return commentsContent;
	}
	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//	toString
	@Override
	public String toString() {
		return "CommentsVo [commentsNo=" + commentsNo + ", postNo=" + postNo + ", userNo=" + userNo + ", commentsContent="
				+ commentsContent + ", regDate=" + regDate + ", userName=" + userName + "]";
	}
	
	
}
