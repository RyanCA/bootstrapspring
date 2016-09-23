package com.pland.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//@Controller is a stereotype annotation, based on the @Component annotation
public class HomeController {
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="/home", method= RequestMethod.GET)
	public String home1(){
		return "home";
	}
	
	@RequestMapping(value="/signup", method= RequestMethod.GET)
	public String signup(){
		return "signup";
	}
	
	@RequestMapping(value="/signin", method= RequestMethod.GET)
	public String signin(){
		return "signin";
	}
	
	@RequestMapping(value="/user", method= RequestMethod.GET)
	public String user(){
		return "user";
	}

}
