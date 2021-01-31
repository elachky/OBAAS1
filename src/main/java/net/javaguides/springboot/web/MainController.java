package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.springboot.service.AccountService;
import net.javaguides.springboot.service.UserService;

@Controller
public class MainController

{
	
	@Autowired
	UserService userService;
	

	
	
	//Return Login Page
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	//Return User page
	@GetMapping()
	public String home(Model model) 
	{
		model.addAttribute("number");
		return "index";
	}
	
	

}
