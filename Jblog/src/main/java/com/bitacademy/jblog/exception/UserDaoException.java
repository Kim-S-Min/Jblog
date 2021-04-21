package com.bitacademy.jblog.exception;

import com.bitacademy.jblog.vo.UserVo;

public class UserDaoException extends RuntimeException {
	private UserVo userVo = null;
	
	public UserDaoException() {
		
	}
	
	public UserDaoException(String id) {
		super(id);
	}
	
	public UserDaoException(String message, UserVo userVo) {
		super(message);
		this.userVo = userVo;
	}

	//	Getter/Setter
	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
}