package net.javaguides.springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.AccountDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
public class UserOperationController {

	private UserService userService;
	

	public UserOperationController(UserService userService) {
		super();
		this.userService = userService;
	}
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping("payerFacture")
	public String showWillPage(HttpServletRequest request) {
		
		return "facture";
	}
	@GetMapping("demandeService")
	public String showServicePage() {
		return "service";
	}
	@PostMapping("payerFacture")
	public String payerFacture(@ModelAttribute("user") UserRegistrationDto registrationDto) 
	{	
		//String username = registrationDto.getUsername();
		//String Password = registrationDto.getPassword();
		//System.out.println(username);
		//System.out.println(userService.generatePassword(Password));
		
		userService.delete(registrationDto.getAccount().getAccountNumber());
		return "redirect:/login?deletion";
	}
	@PostMapping("demandeService")
	public String demandeService(@ModelAttribute("user") UserRegistrationDto registrationDto) 
	{	
		//String username = registrationDto.getUsername();
		//String Password = registrationDto.getPassword();
		//System.out.println(username);
		//System.out.println(userService.generatePassword(Password));
		
		userService.delete(registrationDto.getAccount().getAccountNumber());
		return "redirect:/login?deletion";
	}
	

	
	
	
	
}
