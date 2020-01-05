package com.qfedu.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		System.out.println("出现全局异常：" + ex);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("exception", ex);
		return mv;
	}
}
