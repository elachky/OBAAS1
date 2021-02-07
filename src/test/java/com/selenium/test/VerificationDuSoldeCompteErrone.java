package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationDuSoldeCompteErrone {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\radid\\Desktop\\driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		
 driver.get("http://localhost:8881/");
	    
	    WebElement LoginUsernamee = driver.findElement(By.id("username"));
	    WebElement LoginPassworde = driver.findElement(By.id("password"));
	    WebElement submitLogin = driver.findElement(By.id("login-submit"));
	    
	    LoginUsernamee.sendKeys("samir_rachidi");
	    LoginPassworde.sendKeys("123456789");
	    submitLogin.click();
		
		
		driver.get("http://localhost:8881/accountBalance");
	    
	    WebElement LoginUsername = driver.findElement(By.id("username"));
	    WebElement LoginPassword = driver.findElement(By.id("password"));
	    WebElement AccoutNumber = driver.findElement(By.id("accountNumber"));
	    WebElement register = driver.findElement(By.id("register"));
	   
	    
	  
	   
	    LoginUsername.sendKeys("false_username");
	    LoginPassword.sendKeys("111111111");
	    AccoutNumber.sendKeys("111111111");
	    register.click();

	}

}
