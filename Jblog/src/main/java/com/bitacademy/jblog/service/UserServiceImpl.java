package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.UserDao;
import com.bitacademy.jblog.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	// Dao연결
	@Autowired
	UserDao userDaoImpl;
	
	@Override
	public boolean createBlog(UserVo vo) {
		int insertedCount = userDaoImpl.createBlog(vo);
		return insertedCount == 1;
	}
	
	@Override
	public boolean createCategory(UserVo vo) {
		int insertedCount = userDaoImpl.createCategory(vo);
		return insertedCount == 1;
	}
	
	@Override
	public boolean join(UserVo vo) {
		int insertedCount = userDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public UserVo getUser(String id, String password) {
		UserVo vo = userDaoImpl.selectUser(id, password);
		return vo;
	}

	@Override
	public UserVo getUser(String id) {
		UserVo vo = userDaoImpl.selectUser(id);
		return vo;
	}

}
