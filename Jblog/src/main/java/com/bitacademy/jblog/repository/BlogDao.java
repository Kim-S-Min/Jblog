package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.CommentsVo;
import com.bitacademy.jblog.vo.PostVo;

public interface BlogDao {
	public BlogVo getBlogAdmin(String id);
	public BlogVo getBlogAdmin(Long no);
	public BlogVo getPage(String id);
	public int update(BlogVo vo);	
	public int updateLogo(BlogVo vo);

}
