package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.CategoryVo;

public interface CategoryDao {
	public int insertCate(CategoryVo vo);
	public List<CategoryVo> getCate(Long no);
	public int deleteCate(Long no);
}
