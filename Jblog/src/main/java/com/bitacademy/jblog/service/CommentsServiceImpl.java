package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CommentsDao;
import com.bitacademy.jblog.vo.CommentsVo;

@Service
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	CommentsDao commentsDaoImpl;
	
	@Override
	public boolean insertComments(CommentsVo vo) {
		int insertedCount = commentsDaoImpl.insertComments(vo);
		return insertedCount ==1;
	}

	@Override
	public boolean deleteComments(Long no) {
		int deletedCount = commentsDaoImpl.deleteComments(no);
		return deletedCount == 1;
	}

	@Override
	public List<CommentsVo> getComments(Long no) {
		List<CommentsVo> list = commentsDaoImpl.getComments(no);
		return list;
	}

}
