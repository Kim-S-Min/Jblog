package com.bitacademy.jblog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.CommentsService;
import com.bitacademy.jblog.service.FileUploadService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.PostVo;
import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping("/")
public class BlogController {
	@Autowired
	BlogService blogService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CommentsService commentsService;
	
	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping("{userpage}")
	public String view(@PathVariable("userpage") String id, HttpSession session, Model model) {
		BlogVo vo = blogService.getPage(id);
		model.addAttribute("vo", vo);
		List<PostVo> postList = postService.getPost(vo.getUserNo());
		model.addAttribute("postList", postList);
		List<CategoryVo> cateList = categoryService.getCate(vo.getUserNo());
		model.addAttribute("cateList", cateList);
		
		return "blog/home";
	}
	
	@RequestMapping(value="{userpage}", method=RequestMethod.POST)
	public String loginAction(
			@PathVariable("sitename") String id, 
			@RequestParam(value="cateNo",  required=false, defaultValue="")
			Long cateNo, HttpSession session, Model model) {
		BlogVo vo = blogService.getPage(id);
		model.addAttribute("vo", vo);
		
		List<PostVo> postList = postService.getPost(vo.getUserNo());
		List<PostVo> newList = new ArrayList<>();
		
		for(PostVo e : postList) {
			if(e.getCateNo() == cateNo) {
				newList.add(e);
			}
		}
		
		model.addAttribute("postList", newList);
		List<CategoryVo> list = categoryService.getCate(vo.getUserNo());
		model.addAttribute("cateList", list);
		
		return "blog/home";
	}
	
	@RequestMapping("{userpage}/admin/basic")
	public String adminbasic(
			@PathVariable("userpage")
			String id, HttpSession session, Model model) {
		BlogVo vo = blogService.getBlogAdmin(id);
		model.addAttribute("vo", vo);
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if (authUser == null ) {
			return "redirect:/";
		} else if (authUser.getUserNo() != vo.getUserNo()) {
			return "redirect:/";
		}
		return "blog/basic";
	}
	
	@RequestMapping(value="{userblog}/admin/basic", method = RequestMethod.POST)
	public String adminCategory(@PathVariable("sitename") String id, HttpSession session, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		BlogVo vo = blogService.getBlogAdmin(id);
		model.addAttribute("vo", vo);
		List<CategoryVo> list = categoryService.getCate(authUser.getUserNo());
		model.addAttribute("list", list);
		
		return "blog/category";
	}
	
	@RequestMapping(value="{userblog}/admin/category", method = RequestMethod.POST)
	public String categoryAction(@ModelAttribute CategoryVo insertVo, HttpSession session, Model model) {
		UserVo vo = (UserVo)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		boolean success = categoryService.insertCate(insertVo);

		return "redirect:/{sitename}";
	}
	
	@RequestMapping(value="{userblog}/admin/write", method=RequestMethod.GET)
	public String writeForm(@PathVariable("userblog") String id, HttpSession session, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		BlogVo vo = blogService.getBlogAdmin(id);
		model.addAttribute("vo",vo);
		if (authUser == null) {
			return "redirect:/";
		}
		List<CategoryVo> list = categoryService.getCate(authUser.getUserNo());
		model.addAttribute("list", list);

		return "blog/write";
	}
	
	@RequestMapping(value = "{userblog}/admin/write", method =RequestMethod.POST)
	public String writeAction(@ModelAttribute PostVo vo, HttpSession session, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/{userblog}";
		}		
		boolean success = postService.write(vo);
		if(success) {
			return "redirect:/{userblog}";
		} else {
			return "redirect:/";
		}
	}
	
	@ResponseBody
	@RequestMapping("/show")
	public Object existEmail(
			@RequestParam(value = "no", required=false, defaultValue="") Long no){
		List<PostVo> list = postService.getPost(no);
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		
		return map;
	}
}
