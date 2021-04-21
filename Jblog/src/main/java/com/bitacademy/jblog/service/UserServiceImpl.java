package com.bitacademy.jblog.service;

import org.springframework.stereotype.Service;

import com.bitacademy.jblog.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	// Dao연결
	
	
	@Override
	public boolean join(UserVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserVo getUser(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVo getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
