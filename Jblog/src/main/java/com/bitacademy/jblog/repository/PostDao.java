package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.PostVo;

public interface PostDao {
	public Long getPostCount(Long no);
	public List<PostVo> getPost(Long no);
	public int write(PostVo vo);
}
