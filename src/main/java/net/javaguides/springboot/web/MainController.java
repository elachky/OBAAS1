package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		model.addAttribute("username",username);
		model.addAttribute("accountNumber",userService.getUserByUserName(username).getAccount().getAccountNumber());
		return "index";
	}
	@PostMapping()
	public String afficherPageAccuiel() 
	{	
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(principal);
				return "redirect:/?ac="+principal;
	}
	

}
