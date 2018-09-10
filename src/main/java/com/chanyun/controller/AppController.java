package com.chanyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@RequestMapping("/")
@ApiIgnore
public class AppController {

	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "hello word";
	}
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
