package net.javaguides.springboot.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/close")
public class UserDeletionController {

	private UserService userService;
	

	public UserDeletionController(UserService userService) {
		super();
		this.userService = userService;
	}
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showWelcomePage() {
		return "close";
	}
	@PostMapping
	public String registerUserAccount(@RequestParam("username") String username,@RequestParam("accountN") int accountN,@RequestParam("password") String password) 
	{	
		
		if (userService.existUser(username)!= 0) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(password,userService.loadUserByUsername(username).getPassword())) {
				int s = userService.delete(username, accountN);
				if(s==0) {
					return "redirect:/login?deletion";
				}
			}
		}
		return "redirect:/close?invalid";
	}
	
	
	
	
	
}
