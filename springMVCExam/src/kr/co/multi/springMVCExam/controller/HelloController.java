package kr.co.multi.springMVCExam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello"; //view¿Ã∏ß
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
