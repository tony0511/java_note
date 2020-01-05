package com.qfedu.springmvc.exception;

import javax.servlet.ServletException;

public class LackParamException extends ServletException{

	private static final long serialVersionUID = 1L;

	public LackParamException() {
		super("缺少参数");
	}
	
	public LackParamException(String msg) {
		super(msg);
	}
}
