package com.qfedu.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorld {

	@RequestMapping(value="/world", method=RequestMethod.GET)
	public String helloworld() {
		
		System.out.println("hello world");
		return "helloworld";
	}
	
	@RequestMapping("/loginform")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="realname") String username, String password) {
		System.out.println("执行登录");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		return "redirect:world";
	}
	
	@RequestMapping("/testcookie")
	public String testCookie(@CookieValue("JSESSIONID") String sessionId) {
		
		System.out.println(sessionId);
		
		return "success";
	}
	
	@RequestMapping("/testheader")
	public String testHeader(@RequestHeader(value="Accept-Language") String header) {
		System.out.println(header);
		return "success";
	}
	
	@RequestMapping(value="/testparam", params= {"username", "age!=10"}, headers= {"Accept-Language=zh-CN,zh;q=0.8"})
	public String testParam(String username, Integer age) {
		System.out.println(username + " " + age);
		return "success";
	}
	
	@RequestMapping("/testantpath/*/helen")
	public String testAntpath() {
		System.out.println("antpath");
		return "success";
	}
}
