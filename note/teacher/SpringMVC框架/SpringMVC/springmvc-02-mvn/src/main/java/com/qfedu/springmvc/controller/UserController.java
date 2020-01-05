package com.qfedu.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.qfedu.springmvc.dao.UserDao;
import com.qfedu.springmvc.exception.LackParamException;
import com.qfedu.springmvc.pojo.User;

@Controller
//@RequestMapping("/user")
//@SessionAttributes(value= {"user"}, types= {String.class})
public class UserController {

	@Autowired
	private UserDao userDao;
	
	/////////////////////// 异常处理 //////////////////////////////////
	@ExceptionHandler(LackParamException.class)
	public ModelAndView handleException(Exception ex) {
		System.out.println("出现异常：" + ex);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("exception", ex);
		return mv;
	}
	
	@RequestMapping("test_exception")
	public String testException(String str) throws LackParamException {
		if(StringUtils.isEmpty(str)) {
			throw new LackParamException();
		}
		return "success";
	}
/*	@ExceptionHandler
	public String handleException(Exception ex, Map<String, Exception> map) {
		System.out.println("出现异常：" + ex);
		
		map.put("exception", ex);
		return "error";
	} */
	
	/////////////////////// 类型转换 //////////////////////////////////
	/*	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}*/
	/////////////////////// RESTful //////////////////////////////////
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String list(Model model) {

		System.out.println("users");
		//int a = 9/0;
		//Integer.parseInt("abc");
		//显示列表
		Collection<User> userList = userDao.getAll();
		model.addAttribute("userList", userList);
		
		return "user/list";
	}

	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable(value="id") Integer id) throws LackParamException {
		
		//执行删除
		System.out.println("delete" + id);
		userDao.delete(id);
		
		return "redirect:/users";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String add() {
		//打开增加页面
		System.out.println("add");
		return "user/add";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String save(User user) {
		System.out.println(user);
		//执行插入
		System.out.println("save");
		userDao.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable(value="id") Integer id, Model model) {
		//打开回回显页面
		System.out.println("edit");
		User user = userDao.get(id);
		
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable(value="id") Integer id, User user) {
		//执行更新
		System.out.println("update");
		user.setId(id);
		userDao.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public String saveuser(User user) {
		System.out.println(user);
		//执行插入
		System.out.println("saveuser");
		userDao.save(user);
		return "redirect:/users";
	}
	
	/////////////////////// JSON和JSONP //////////////////////////////////
	
	@ResponseBody
	@RequestMapping(value="/users-json", method=RequestMethod.GET)
	public Collection<User> listjson() {
		//显示列表
		return userDao.getAll();
	}
	
	
	@RequestMapping(value="/users-jsonp", method=RequestMethod.GET)
	public void listjson(String callback, HttpServletResponse response) throws IOException {
		//显示列表
		Collection<User> list = userDao.getAll();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.getWriter().println(callback + "(" + json + ")");
	}
	
	@RequestMapping(value="/user-json", method=RequestMethod.POST)
	public String savejson(@RequestBody User user) {
		System.out.println(user);
		//执行插入
		System.out.println("save");
		userDao.save(user);
		return "redirect:/users";
	}
	
	/////////////////////// 文件上传 //////////////////////////////////
	
	@RequestMapping("/fileupload")
	public String fileupload(String desc, MultipartFile file, Model model) throws IllegalStateException, IOException {
		
		System.out.println(desc);
		System.out.println(file);
		System.out.println(file.getOriginalFilename());
		
		if(file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
			
			String filepath = "D:\\upload\\";
			String origName = file.getOriginalFilename();
			
			//扩展名
			String extendsName = origName.substring(origName.lastIndexOf("."));
			//文件名
			String newFilename = UUID.randomUUID().toString() + extendsName;
			//文件
			File uploadFile = new File(filepath + newFilename);
			file.transferTo(uploadFile);
			
			System.out.println(newFilename);
			model.addAttribute("filepath", "/file/" + newFilename);
		}
		
		return "success";
	}
}
