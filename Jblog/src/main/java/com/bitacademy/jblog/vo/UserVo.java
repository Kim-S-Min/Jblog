package com.bitacademy.jblog.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	private Long userNo;
	
	@NotEmpty
	@Length(min=2, max=20, message= "최소 4글자부터 최대 20글자까지 입력 가능합니다.")
	private String id;
	
	@NotEmpty
	@Length(min=1, max=20, message= "최소 2글자부터 최대 20글자까지 입력 가능합니다.")
	private String userName;
	
	@NotEmpty
	@Length(min=4, max=30, message= "최소 4글자부터 최대 30글자까지 입력 가능합니다.")
	private String password;
	private Date joindate;
	
	//	Getter/Setter
	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	//	toString
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", joindate=" + joindate + "]";
	}	
}
