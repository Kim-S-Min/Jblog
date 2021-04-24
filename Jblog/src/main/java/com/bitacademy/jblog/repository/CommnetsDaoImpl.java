package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitacademy.jblog.vo.CommentsVo;

public class CommnetsDaoImpl implements CommentsDao {
	@Autowired
	SqlSession sqlSession;
		
	@Override
	public int insertComments(CommentsVo vo) {
		int insertedCount = sqlSession.insert("blog.insertComments", vo);
		return insertedCount;
	}

	@Override
	public int deleteComments(Long no) {
		int deletedCount = sqlSession.delete("blog.deleteComments", no);
		return deletedCount;
	}

	@Override
	public List<CommentsVo> getComment(Long no) {
		List<CommentsVo> list = sqlSession.selectList("blog.getComments", no);
		return list;
	}

}
