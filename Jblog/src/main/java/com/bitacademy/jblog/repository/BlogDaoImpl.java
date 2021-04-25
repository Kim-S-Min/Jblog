package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.CommentsVo;
import com.bitacademy.jblog.vo.PostVo;

@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public BlogVo getPage(String id) {
		BlogVo vo = sqlSession.selectOne("blog.adminBlog", id);
		return vo;
	}
	@Override
	public List<PostVo> getPost(Long no) {
		List<PostVo> list = sqlSession.selectList("blog.getPost",no);
		return list;
	}
	
	@Override
	public List<CategoryVo> getCate(Long no) {
		List<CategoryVo> list = sqlSession.selectList("blog.selectCategory", no);
		return list;
	}
	
	@Override
	public BlogVo getBlogAdmin(String id) {
		BlogVo vo = sqlSession.selectOne("blog.adminBlog",id);
		return vo;
	}
	@Override
	public BlogVo getBlogAdmin(Long no) {
		BlogVo vo = sqlSession.selectOne("blog.adminBlog1",no);
		return vo;
	}
	@Override
	public int update(BlogVo vo) {
		int updatedCount = sqlSession.update("blog.update", vo);
		return updatedCount;
	}
	
	@Override
	public int updateLogo(BlogVo vo) {
		int updatedCount = sqlSession.update("blog.updateLogo", vo);
		return updatedCount;
	}
	
	
	@Override
	public int insertCate(CategoryVo vo) {
		int insertedCount = sqlSession.insert("blog.insertCate", vo);
		return insertedCount;
	}
	@Override
	public int write(PostVo vo) {
		int writedCount = sqlSession.insert("blog.write", vo);
		return writedCount;
	}
	@Override
	public Long getPostCount(Long no) {
		long count = sqlSession.selectOne("blog.getPostCount", no);
		return count;
	}
	@Override
	public int deleteCate(Long no) {
		int deletedCount = sqlSession.update("blog.deleteCate", no);
		return deletedCount;
	}
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
