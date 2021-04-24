package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitacademy.jblog.vo.PostVo;

public class PostDaoImpl implements PostDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<PostVo> getPost(Long no) {
		List<PostVo> list = sqlSession.selectList("blog.getPost", no);
		return list;
	}

	@Override
	public int write(PostVo vo) {
		int writedCount = sqlSession.insert("blog.wirte", vo);
		return writedCount;
	}

	@Override
	public Long getPostCount(Long no) {
		long count = sqlSession.selectOne("blog.getPostCount", no);
		return count;
	}

}
