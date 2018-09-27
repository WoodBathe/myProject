package com.qst.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qst.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@RequestMapping("/login.do")
	public String login(String username,String userpass){
		System.out.println("登录进来了");
		int a = 10/0;
		System.out.println("name:"+username);
		System.out.println("pass:"+userpass);
		
		System.out.println("-------------");
		
		System.out.println("登录出去了");
		return "success";
	}
	
	@RequestMapping("/login1.do")
	public String login1(@RequestParam("username")String name,String userpass){
		System.out.println("登录进来了");
		
		System.out.println("name:"+name);
		System.out.println("pass:"+userpass);
		
		return "success";
	}
	
	@RequestMapping("/login2.do")
	public String login2(User user){
		System.out.println("登录进来了");
		
		System.out.println(user);
	
		
		return "success";
	}
	
	@RequestMapping(value="/login3.do",method={RequestMethod.POST})
	public String login3(User user){
		System.out.println("登录进来了");
		
		System.out.println(user);
	
		//user作为参数时，可以直接在请求转发的下一个页面使用
		
		return "success";
	}
	
	
	@RequestMapping("/login4.do")
	public String login4(User user,HttpServletRequest request){
		System.out.println("登录进来了");
		
		System.out.println(user);
		
		request.setAttribute("username", "test");
		
		return "success";
	}
	
	
	@RequestMapping("/login5.do")
	public ModelAndView login5(HttpServletRequest request){
		System.out.println("登录进来了");
		
		User user = new User();
		user.setUsername("zhangsan");
		user.setUserpass("456");
		request.setAttribute("username", "test");
		//return new ModelAndView("success","user",user);
		Map map = new HashMap();
		map.put("user", user);
		
		return new ModelAndView("success",map);
	}
	
	@RequestMapping("/login6.do")
	public String login6(Model model){
		System.out.println("登录进来了");
		
		User user = new User();
		user.setUsername("zhangsan");
		user.setUserpass("456");

		model.addAttribute("user", user);
		return "success";
	}
	
	@RequestMapping("/ajaxLogin.do")
	public void ajaxLogin(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("<script>alert('登录失败');history.go(-1);</script>");
	}
	
	@RequestMapping("/jsonLogin.do")
	@ResponseBody
	public User jsonLogin(HttpServletResponse response) {
		User user = new User();
		user.setUsername("zhangsan");
		user.setUserpass("456");
		return user;
	}
	
	
	@RequestMapping("/redirectLogin.do")
	public String redirectLogin(Model model){
		
		User user = new User();
		user.setUsername("zhangsan");
		user.setUserpass("456");

		model.addAttribute("user", user);
		//return "redirect:/jsp/success.jsp";
		return "forward:/user/login.do";

	}
	
	
	@RequestMapping("upload.do")//文件上传
	public String upload(String desc,MultipartFile upload) throws Exception{
		System.out.println("上传描述："+desc);
		if(upload != null){
			String fileName = upload.getOriginalFilename();
			upload.transferTo(new File("D:\\upload\\"+fileName));
		}
		return "success";
	}
	
	@RequestMapping("uploadPath.do")//文件上传到工程目录
	public String uploadPath(String desc,MultipartFile upload,HttpSession session) throws Exception{
		System.out.println("session："+session);
		System.out.println("name："+upload.getName());
		if(upload != null){
			String fileName = upload.getOriginalFilename();
			String path = session.getServletContext().getRealPath("/upload/");
			upload.transferTo(new File(path+fileName));
		}
		return "success";
	}
	
	@RequestMapping("uploadMulti.do")//多文件上传
	public String uploadMulti(String desc,MultipartFile[] upload) throws Exception{
		System.out.println("上传描述："+desc);
		for(MultipartFile up:upload){
			String fileName = up.getOriginalFilename();
			
			up.transferTo(new File("D:\\upload\\"+fileName));
		}

		
		return "success";
	}
	
	
	@ExceptionHandler
	public ModelAndView myException(Exception e){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", e.getMessage());
		return mv;
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,/*"date",*/ new CustomDateEditor(dateFormat, true));
	}
}
