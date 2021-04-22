package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitacademy.jblog.repository.BlogDao;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.PostVo;

public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogDao blogDaoImpl;
	
	@Override
	public BlogVo getPage(String id) {
		BlogVo vo = blogDaoImpl.getPage(id);
		return vo;
	}

	@Override
	public List<PostVo> getPost(Long no) {
		List<PostVo> list = blogDaoImpl.getPost(no);
		return list;
	}

	@Override
	public List<CategoryVo> getCate(Long no) {
		List<CategoryVo> list = blogDaoImpl.getCate(no);
		return list;
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
		int updatedCount = blogDaoImpl.update(vo);
		return updatedCount == 1;
	}

	@Override
	public boolean insertCate(CategoryVo vo) {
		int insertedCount = blogDaoImpl.insertCate(vo);
		return insertedCount == 1;
	}

	@Override
	public boolean write(PostVo vo) {
		int writedCount = blogDaoImpl.write(vo);
		return writedCount == 1;
	}

}