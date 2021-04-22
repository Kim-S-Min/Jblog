package com.bitacademy.jblog.service;

import com.bitacademy.jblog.vo.UserVo;

public interface UserService {
	public boolean join(UserVo vo);
	public boolean createBlog(UserVo vo);
	public boolean createCategory(UserVo vo);
	public UserVo getUser(String id, String password);
	public UserVo getUser(String id);
}
