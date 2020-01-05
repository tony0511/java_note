package com.qfedu.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String home(HttpSession session) {
		
		System.out.println(session.getId());
		return "home";
	}
}
