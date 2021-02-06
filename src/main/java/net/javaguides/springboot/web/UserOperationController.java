package net.javaguides.springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.service.UserService;
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
	public String payerFacture(HttpServletRequest request) {
		
		return "facture";
	}
	@GetMapping("demandeService")
	public String showServicePage() {
		return "service";
	}
	@GetMapping("accountBalance")
	public String accountBalance(HttpServletRequest request) {
		
		return "balance";
	}
	@GetMapping("transferArgent")
	public String transferArgent(HttpServletRequest request) {
		
		return "transfere";
	}
	@PostMapping("accountBalance")
	public String accountBalance(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("accountN") int accountN) 
	{	
		if (userService.existUser(username)!= 0) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(password,userService.loadUserByUsername(username).getPassword())) {
				double s=userService.demandeBalance(username, accountN);
				if(s!=-1) {
					return "redirect:/accountBalance?servir="+s;
				}else {
					return "redirect:/accountBalance?servfErr";
				}
			}
			}
				return "redirect:/accountBalance?error";
	}
	@PostMapping("payerFacture")
	public String payerFacture(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("accountN") int accountN,@RequestParam("amount") double amount,@RequestParam("service") String service) 
	{	
		if (userService.existUser(username)!= 0) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(password,userService.loadUserByUsername(username).getPassword())) {
				double s=userService.payerFacture(username, accountN,amount);
				if(s>-1) {
					return "redirect:/payerFacture?payer="+amount+"&&s="+service;
				}else if(s==-2){
					return "redirect:/payerFacture?soldeInsuf";
				}
			}
			}
				return "redirect:/payerFacture?invalid";
	}
    
	@PostMapping("demandeService")
	public String demandeService(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("service") String service,@RequestParam("accountN") int accountN) 
	{	
		if (userService.existUser(username)!= 0) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(password,userService.loadUserByUsername(username).getPassword())) {
			int s=userService.demandeService(username, service, accountN);
			if(s==1) {
				return "redirect:/demandeService?servir";
			}else if(s==0){
				return "redirect:/demandeService?soldeInsuf";
			}else {
				return "redirect:/demandeService?servfErr";
			}
		}
		}
			return "redirect:/demandeService?error";

	}
	
	@PostMapping("transferArgent")
	public String transferArgent(@RequestParam("username") String username,@RequestParam("fromAccount") int fromAccount,@RequestParam("toAccount") int toAccount,@RequestParam("balance") double balance,@RequestParam("password") String password) 
	{	
		if (userService.existUser(username)!= 0) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(password,userService.loadUserByUsername(username).getPassword())) {
			int s=userService.transfer(username, fromAccount, toAccount, balance);
			if(s==1) {
				return "redirect:/transferArgent?transfer="+balance+"&&to="+toAccount;
			}else if(s==0) {
				return "redirect:/transferArgent?soldeInsuf";
			}else {
				return "redirect:/transferArgent?transfErr";
			}
		}
		}
		return "redirect:/transferArgent?error";
	}
	

}
