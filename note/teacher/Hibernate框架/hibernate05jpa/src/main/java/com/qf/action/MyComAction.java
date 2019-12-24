package com.qf.action;

import com.qf.pojo.MyComputer;
import com.qf.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Thanks for Everything.
 */
@Controller
public class MyComAction {

	@Autowired
	private MyService myService;

	@ResponseBody
	@RequestMapping("/addCom.do")
	public String add(){
		MyComputer computer = new MyComputer();
		computer.setComName("test");
		computer.setComDesc("test");
		myService.addCom(computer);

		return "ok";
	}
}
