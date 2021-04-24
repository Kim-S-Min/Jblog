package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.CommentsVo;
import com.bitacademy.jblog.vo.PostVo;
import com.bitacademy.jblog.vo.UserVo;

public interface BlogService {
	public BlogVo getPage(String id);
	public BlogVo getBlogAdmin(String id);
	public BlogVo getBlogAdmin(Long no);
	public boolean update(BlogVo vo);
	public boolean updateLogo(BlogVo vo);
	
}
