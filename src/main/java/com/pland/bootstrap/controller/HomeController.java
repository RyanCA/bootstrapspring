package com.pland.bootstrap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import com.pland.bootstrap.persistence.jpa.securityunit.User;
import com.pland.bootstrap.repository.UserRepository;


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

}
