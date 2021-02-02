package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.AccountDto;
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
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) 
	{
		userService.delete(registrationDto.getAccount().getAccountNumber());
		return "redirect:/close?success";
	}
	
	
	
	
	
}
