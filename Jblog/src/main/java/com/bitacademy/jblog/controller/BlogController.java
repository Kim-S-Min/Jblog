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
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.CommentsService;
import com.bitacademy.jblog.service.FileUploadService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.CommentsVo;
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
	public String view(
			@PathVariable("userpage") 
			String id, HttpSession session, Model model) {
		BlogVo vo = blogService.getPage(id);
		
		UserVo pageId = userService.getUser(id);
		model.addAttribute("pageId", pageId);
		model.addAttribute("vo", vo);
		List<PostVo> postList = postService.getPost(vo.getUserNo());
		model.addAttribute("postList", postList);
		List<CategoryVo> cateList = categoryService.getCate(vo.getUserNo());
		model.addAttribute("cateList", cateList);
		return "blog/home";
	}
	
	@RequestMapping(value="{userpage}", method=RequestMethod.POST)
	public String loginAction(
			@PathVariable("userpage") String id, 
			@RequestParam(value="cateNo",  required=false, defaultValue="")
			Long cateNo, HttpSession session, Model model) {
		BlogVo vo = blogService.getPage(id);
		model.addAttribute("vo", vo);
		
		UserVo pageId= userService.getUser(id);  
		model.addAttribute("pageId", pageId);
		
		List<PostVo> postList = postService.getPost(vo.getUserNo());
		List<PostVo> newList = new ArrayList<>();
		
		for(PostVo e : postList) {
			if(e.getCateNo() == cateNo) {
				newList.add(e);
			}
		}
		
		List<CommentsVo> l = new ArrayList<>();
		System.out.println(newList.toString());
		if(!newList.isEmpty()) {
			l = commentsService.getComments(newList.get(0).getPostNo());
			for(CommentsVo e : l) {
				String x = userService.selectUserName(e.getUserNo());
				e.setUserName(x);
			}
			model.addAttribute("commentList", l);
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
	
	@RequestMapping(value="{userpage}/admin/category")
	public String adminCategory(@PathVariable("userpage") String id, HttpSession session, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		BlogVo vo = blogService.getBlogAdmin(id);
		model.addAttribute("vo", vo);
		List<CategoryVo> list = categoryService.getCate(authUser.getUserNo());
		model.addAttribute("list", list);
		
		return "blog/category";
	}
	
	@RequestMapping(value="{userpage}/admin/category", method = RequestMethod.POST)
	public String categoryAction(@ModelAttribute CategoryVo insertVo, HttpSession session, Model model) {
		UserVo vo = (UserVo)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		boolean success = categoryService.insertCate(insertVo);

		return "redirect:/{userpage}";
	}
	
	@RequestMapping(value="{userpage}/admin/write", method=RequestMethod.GET)
	public String writeForm(@PathVariable("userpage") String id, HttpSession session, Model model) {
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
	
	@RequestMapping(value = "{userpage}/admin/write", method =RequestMethod.POST)
	public String writeAction(@ModelAttribute PostVo vo, HttpSession session, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/{userpage}";
		}		
		boolean success = postService.write(vo);
		if(success) {
			return "redirect:/{userpage}";
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
	
	@RequestMapping(value="{userpage}/insertcomments", method=RequestMethod.POST)
	public String commentsAction(
			@ModelAttribute CommentsVo commentsVo, 
			@PathVariable("userpage") 
			String id, Model model, HttpSession session) {
		boolean success = commentsService.insertComments(commentsVo);
		UserVo pageId=userService.getUser(id);
		model.addAttribute("pageId", pageId);
		
		if(success) {
			return "redirect:/{userpage}";
		} else {
			return "redirect:{userpage}";
		}
	}
	
	@RequestMapping(value = "{userpage}/deletecomments", method = RequestMethod.POST)
	public String deleteAction(
			@RequestParam("no") Long no,
			@PathVariable("userpage")
			String id, Model model, HttpSession session) {
		UserVo vo = (UserVo)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		boolean success = commentsService.deleteComments(no);
		
		if (success) {
			return "redirect:/{userpage}";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "{userpage}/admin/update", method = RequestMethod.GET)
	public String basicAction(
			@ModelAttribute BlogVo updatedVo, 
			@RequestParam("file") MultipartFile uploadfile, Model model) {
		BlogVo vo = blogService.getBlogAdmin(updatedVo.getUserNo());
		vo.setBlogTitle(updatedVo.getBlogTitle());
		
		if(!uploadfile.getOriginalFilename().equals("")) {
			String saveFileName = fileUploadService.store(uploadfile);
			String urlImage = "upload-images/" + saveFileName;
			
			vo.setLogoFile(urlImage);
		}
		
		
		boolean success = blogService.update(vo);
		
		if(success) {
			return "redirect:/{userpage}";
		}else {
			return "redirect:{userpage}/admin/basic";
		}

	}
}
