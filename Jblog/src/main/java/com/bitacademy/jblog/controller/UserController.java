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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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

	@Autowired
	private UserService userService;
	

	@RequestMapping(value = {"", "/", "/join"}, method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo userVo) {
		return "users/joinform";
	}
	

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(
			@ModelAttribute @Valid UserVo userVo) {
		boolean success = userService.join(userVo);
		logger.debug("Form 전송된 데이터:" + userVo);
		if(success) {
			logger.debug("가입 성공!");
			UserVo vo = userService.getUser(userVo.getId());
			userService.createBlog(vo);
			userService.createCategory(vo);
			return "redirect:/users/joinsuccess/";
		}else {
			logger.error("가입 실패!");
			return "redirect:/users/";
		}
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}
	
	@ResponseBody
	@RequestMapping("/idcheck")
	public Object existsEmail(@RequestParam(value = "id", required = false, defaultValue = "") String id) {
		UserVo vo = userService.getUser(id);
		boolean exists = vo != null ? true : false;

		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);

		return map;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(@RequestParam String id, @RequestParam String password, HttpSession session, Model model) {
		UserVo authUser = userService.getUser(id, password);

		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			model.addAttribute("message", "로그인 실패");
			model.addAttribute("message", "아이디/패스워드를 확인해 주세요");
			return "redirect:/users/loginform";
		}
	}
	
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
	
}
