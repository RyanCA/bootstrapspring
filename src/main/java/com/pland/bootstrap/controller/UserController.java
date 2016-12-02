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
@RequestMapping("/user")
public class UserController {
	
	@Autowired 
	private UserRepository userRepository;
	

	public UserController(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	
	/**
	 * Following code are two /signup links, one for GET request, one for POST request;
	 * which page will showup defined in tiles.xml
	 */
	
	@RequestMapping(value="/signup", method= RequestMethod.GET)
	public String goToSignup(Model model){
		//In signup.jsp, you must define the commandName="user" in "spring form jsp tag"
		model.addAttribute("user", new User());
		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method= RequestMethod.POST)
	public String signup(
			@Valid User user, 
			Errors errors){
		
		/**
		 * this block should be executed first if want to verify the forms from client
		 */
		if(errors.hasErrors()){
			return "signup"; 
		}
		
		userRepository.createAccount(user);
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@This is in HomeController.java");
		System.out.println("userId="+user.getId());
		
		return "home";
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
