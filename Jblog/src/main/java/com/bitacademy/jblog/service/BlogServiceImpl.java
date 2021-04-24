package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.UserVo;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogDao blogDaoImpl;
	
	@Override
	public BlogVo getPage(String id) {
		BlogVo vo = blogDaoImpl.getPage(id);
		return vo;
	}

	@Override
	public BlogVo getBlogAdmin(String id) {
		BlogVo vo = blogDaoImpl.getBlogAdmin(id);
		return vo;
	}

	@Override
	public BlogVo getBlogAdmin(Long no) {
		BlogVo vo = blogDaoImpl.getBlogAdmin(no);
		return vo;
	}

	@Override
	public boolean update(BlogVo vo) {
		int updatedCount =blogDaoImpl.update(vo);
		return updatedCount == 1;
	}

	@Override
	public boolean updateLogo(BlogVo vo) {
		int updatedCount = blogDaoImpl.updateLogo(vo);
		return updatedCount == 1;
	}



}
