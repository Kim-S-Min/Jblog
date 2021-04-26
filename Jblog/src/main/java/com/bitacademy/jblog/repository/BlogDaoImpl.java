package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.BlogVo;


@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public BlogVo getPage(String id) {
		BlogVo vo = sqlSession.selectOne("blog.adminBlog", id);
		return vo;
	}
		
	@Override
	public BlogVo getBlogAdmin(String id) {
		BlogVo vo = sqlSession.selectOne("blog.adminBlog",id);
		return vo;
	}
	@Override
	public BlogVo getBlogAdmin(Long no) {
		BlogVo vo = sqlSession.selectOne("blog.adminBlog1",no);
		return vo;
	}
	@Override
	public int update(BlogVo vo) {
		int updatedCount = sqlSession.update("blog.update", vo);
		return updatedCount;
	}
	
	@Override
	public int updateLogo(BlogVo vo) {
		int updatedCount = sqlSession.update("blog.updateLogo", vo);
		return updatedCount;
	}
}