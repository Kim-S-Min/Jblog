package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.CommentsVo;

@Repository
public class CommentsDaoImpl implements CommentsDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insertComments(CommentsVo vo) {
		int insertedCount = sqlSession.insert("blog.insertComment", vo);
		return insertedCount;
	}
	@Override
	public int deleteComments(Long no) {
		int deletedCount = sqlSession.delete("blog.deleteComment", no);
		return deletedCount;
	}
	@Override
	public List<CommentsVo> getComments(Long no) {
		List<CommentsVo> list = sqlSession.selectList("blog.getComment", no);
		return list;
	}

}
