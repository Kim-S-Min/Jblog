package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.CategoryVo;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int deleteCate(Long no) {
		int deletedCount = sqlSession.update("blog.deleteCate", no);
		return deletedCount;
	}

	@Override
	public int insertCate(CategoryVo vo) {
		int insertedCount = sqlSession.insert("blog.insertCate", vo);
		return insertedCount;
	}

	@Override
	public List<CategoryVo> getCate(Long no) {
		List<CategoryVo> list = sqlSession.selectList("blog.selectCategory", no);
		return list;
	}

}
