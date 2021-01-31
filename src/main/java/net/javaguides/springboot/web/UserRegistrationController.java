package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.AccountDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;
	

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@ModelAttribute("account")
    public AccountDto accountDto() {
        return new AccountDto();
    }
	
	/*
	 * @PostMapping public String registerAccount(@ModelAttribute("account")
	 * AccountDto accountDto) { userService.addAccount(accountDto);
	 * 
	 * return "redirect:/registration?success"; }
	 */
	@GetMapping
	public String showWelcomePage() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, @ModelAttribute("account") AccountDto accountDto) 
	{
		userService.save(registrationDto);
	
		
		return "redirect:/registration?success";
	}
	
	
	
	
	
	
}
