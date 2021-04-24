package com.bitacademy.jblog.repository;

import java.util.List;

import com.bitacademy.jblog.vo.CommentsVo;

public interface CommentsDao {
	public int insertComments(CommentsVo vo);
	public int deleteComments(Long no);
	public List<CommentsVo> getComment(Long no);
}
