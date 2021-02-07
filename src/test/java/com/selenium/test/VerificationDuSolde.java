package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationDuSolde {

	public static void main(String[] args) throws InterruptedException {
		
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
	    WebElement clear = driver.findElement(By.id("clear"));
	    LoginUsername.sendKeys("samir_rachidi");
	    LoginPassword.sendKeys("123456789");
	    AccoutNumber.sendKeys("966983160");
	    register.click();
	    clear.click();
	 
	    

	}

}
