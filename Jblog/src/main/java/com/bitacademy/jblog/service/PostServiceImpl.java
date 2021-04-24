package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.PostDao;
import com.bitacademy.jblog.vo.PostVo;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDaoImpl;
	
	@Override
	public List<PostVo> getPost(Long no) {
		List<PostVo> list = postDaoImpl.getPost(no);
		return list;
	}

	@Override
	public Long getPostCount(Long no) {
		Long count = postDaoImpl.getPostCount(no);
		return count;
	}

	@Override
	public boolean write(PostVo vo) {
		int writedCount = postDaoImpl.write(vo);
		return writedCount == 1;
	}

}
