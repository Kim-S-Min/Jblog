package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.exception.UserDaoException;
import com.bitacademy.jblog.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
	//	Logger
	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(UserVo vo) {
		int insertedCount = 0;
		
		try {
			insertedCount = sqlSession.insert("users.insert", vo);
			logger.debug("sqlSession:" + insertedCount);
		} catch (Exception e) {
			logger.error("exception:" + e.getMessage());
			throw new UserDaoException("회원 가입 중 오류 발생", vo);
		}
		return insertedCount;
	}
	
	@Override
	public int createBlog(UserVo vo) {
		int insertedCount = 0;
		try {
			insertedCount = sqlSession.insert("users.createblog", vo);
		} catch(Exception e) {
			throw new UserDaoException("createBlog exception");
		}
		return insertedCount;
	}
	
	@Override
	public int createCategory(UserVo vo) {
		int insertedCount = 0;
		try {
			insertedCount = sqlSession.insert("users.createcategory", vo);
		} catch(Exception e) {
			throw new UserDaoException("createBlog exception");
		}
		return insertedCount;
	}

	@Override
	public UserVo selectUser(String id, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("id", id);
		userMap.put("password", password);
		
		UserVo vo = null;
		
		try {
			vo = sqlSession.selectOne("users.selectUserByIDAndPassword", userMap);
		}catch(Exception e){
			throw new UserDaoException("selectUser By id and password exception");
		}
		
		return vo;
	}

	@Override
	public UserVo selectUser(String id) {
		UserVo vo = null; 
		
		try {
			vo = sqlSession.selectOne("users.selectUserByID", id);
		}catch(Exception e){
			throw new UserDaoException("selectUser By ID exception");
		}	
		
		return vo;
	}
	
	@Override
	public String selectUserName(Long no) {
		String name = "";
		try {
			name = sqlSession.selectOne("users.selectUserByNo", no);
		} catch(Exception e) {
			throw new UserDaoException("selectUserName exception");
		}
		return name;
	}

}
