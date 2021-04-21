package com.bitacademy.jblog.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping("/users")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	//	서비스 연결
	@Autowired
	private UserService userService;
	
	//	가입폼
	@RequestMapping(value = {"", "/", "/join"}, method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo userVo) {
		return "users/joinform";
	}
	
	//	가입 처리
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(
			@ModelAttribute @Valid UserVo userVo,
			BindingResult result,
			Model model
			) {
		logger.debug("Form 전송된 데이터:" + userVo);
		
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e: errors) {
				logger.error("Valid Error:" + e);
			}
			logger.debug("result:" + result.getModel());
			model.addAllAttributes(result.getModel());
			return "users/joinform";
		}
		boolean success = userService.join(userVo);
		if (success) { // insert 성공
			logger.debug("가입 성공!");
			return "redirect:/users/joinsuccess";
		} else {
			logger.error("가입 실패!");
			return "redirect:/users/"; // 가입 폼으로 다시 돌려보냄
		}
	}
	
	// 성공 화면
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}
	
	// JSON 매핑 확인
	@ResponseBody
	@RequestMapping("/show")
	public Object showUserByEmail(@RequestParam String id) {
		UserVo vo = userService.getUser(id);
		return vo;
	}
	
	// 중복 아이디 체크
	@ResponseBody
	@RequestMapping("/emailcheck")
	public Object existsEmail(@RequestParam(value = "id", required = false, defaultValue = "") String id) {
		UserVo vo = userService.getUser(id);
		boolean exists = vo != null ? true : false;

		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);

		return map;
	}
	
	// 로그인 폼 처리
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";
	}

	// 로그인 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(@RequestParam String id, @RequestParam String password, HttpSession session) {
		UserVo authUser = userService.getUser(id, password);

		// 만약에 찾는 유저가 없으면 login 폼으로 되돌려보냄
		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			// 로그인 실패
			return "redirect:/users/login";
		}
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		// 세션 지우기
		session.removeAttribute("authUser");
		// 세션 무효화
		session.invalidate();
		return "redirect:/";
	}
	
	
}
