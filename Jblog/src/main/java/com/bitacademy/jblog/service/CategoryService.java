package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.CategoryVo;

public interface CategoryService {
	public List<CategoryVo> getCate(Long no);
	public boolean insertCate(CategoryVo vo);
	public boolean deleteCate(Long no);
}
