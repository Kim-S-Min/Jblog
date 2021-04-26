package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryDao;
import com.bitacademy.jblog.vo.CategoryVo;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDaoImpl;
	
	@Override
	public List<CategoryVo> getCate(Long no) {
		List<CategoryVo> list = categoryDaoImpl.getCate(no);
		return list;
	}

	@Override
	public boolean insertCate(CategoryVo vo) {
		int insertedCount = categoryDaoImpl.insertCate(vo);
		return insertedCount == 1;
	}

	@Override
	public boolean deleteCate(Long no) {
		int deletedCount = categoryDaoImpl.deleteCate(no);
		return deletedCount == 1;
	}

}
