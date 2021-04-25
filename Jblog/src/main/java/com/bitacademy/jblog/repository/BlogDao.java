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
	public Long getPostCount(Long no);
	public List<PostVo> getPost(Long no);
	public List<CategoryVo> getCate(Long no);
	public int update(BlogVo vo);
	public int insertCate(CategoryVo vo);
	public int write(PostVo vo);
	public int updateLogo(BlogVo vo);
	public int deleteCate(Long no);
	public int insertComments(CommentsVo vo);
	public int deleteComments(Long no);
	public List<CommentsVo> getComments(Long no);
}
