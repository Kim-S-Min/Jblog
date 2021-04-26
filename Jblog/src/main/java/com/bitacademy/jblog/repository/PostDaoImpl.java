package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.PostVo;

@Repository
public class PostDaoImpl implements PostDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public Long getPostCount(Long no) {
		long count = sqlSession.selectOne("blog.getPostCount", no);
		return count;
	}

	@Override
	public List<PostVo> getPost(Long no) {
		List<PostVo> list = sqlSession.selectList("blog.getPost",no);
		return list;
	}

	@Override
	public int write(PostVo vo) {
		int writedCount = sqlSession.insert("blog.write", vo);
		return writedCount;
	}

}
