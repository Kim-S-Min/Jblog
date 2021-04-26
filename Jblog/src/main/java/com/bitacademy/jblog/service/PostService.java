package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.PostVo;

public interface PostService {
	public List<PostVo> getPost(Long no);
	public Long getPostCount(Long no);
	public boolean write(PostVo vo);
}
