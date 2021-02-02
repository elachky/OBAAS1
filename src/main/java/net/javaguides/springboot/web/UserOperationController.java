package net.javaguides.springboot.web;

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
@RequestMapping("/transfer")
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
	
	@GetMapping
	public String showWelcomePage() {
		return "transfere";
	}
	/*@RequestMapping(value="/transfer", method=RequestMethod.PUT)
	public void requestBalance(@RequestParam("balance") String balance) {
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		
		System.out.println(balance);

		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");

		
	}*/
	@PostMapping
	public String registerUserAccount(@RequestParam("username") String username,@RequestParam("fromAccount") int fromAccount,@RequestParam("toAccount") int toAccount,@RequestParam("balance") double balance) 
	{			
		//System.out.println(registrationDto.getAccount().getAccountNumber());

		//String username = registrationDto.getUsername();
		//String Password = registrationDto.getPassword();
		//System.out.println(username);
		//System.out.println(userService.generatePassword(Password));
		int s=userService.transfer(username, fromAccount, toAccount, balance);
		if(s==1) {
			return "redirect:/transfer?transfer";
		}else if(s==0) {
			return "redirect:/transfer?soldeInsuf";
		}else {
			return "redirect:/transfer?transfErr";
		}
		//userService.delete(registrationDto.getAccount().getAccountNumber());
		
	}
	
	
	
	
}
