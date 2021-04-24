package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.vo.CommentsVo;

public interface CommentsService {
	public boolean insertComments(CommentsVo vo);
	public boolean deleteComments(Long no);
	public List<CommentsVo> getComments(Long no);
}
