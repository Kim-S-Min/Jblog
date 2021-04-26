package com.bitacademy.jblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus()
	@ExceptionHandler(ControllerException.class)
	public ModelAndView handleControllerException(ControllerException e) {

		e.printStackTrace();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserDaoException.class)
	public ModelAndView handleUserDaoException(UserDaoException e) {
		System.err.println("UserDaoException:" + e.getMessage());
		e.printStackTrace();
		System.err.println("UserVo:" + e.getUserVo());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
}
