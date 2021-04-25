package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.CommentsVo;
import com.bitacademy.jblog.vo.PostVo;

public interface BlogService {
	public BlogVo getPage(String id);
	public List<PostVo> getPost(Long no);
	public List<CategoryVo> getCate(Long no);
	public BlogVo getBlogAdmin(String id);
	public BlogVo getBlogAdmin(Long no);
	public Long getPostCount(Long no);
	public boolean update(BlogVo vo);
	public boolean insertCate(CategoryVo vo);
	public boolean write(PostVo vo);
	public boolean updateLogo(BlogVo vo);
	public boolean deleteCate(Long no);
	public boolean insertComments(CommentsVo vo);
	public boolean deleteComments(Long no);
	public List<CommentsVo> getComments(Long no);
	
}
