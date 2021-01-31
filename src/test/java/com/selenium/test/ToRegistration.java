package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToRegistration {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\radid\\Desktop\\driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    

	    driver.get("http://localhost:3360/");

	    WebElement linkReg = driver.findElement(By.id("toregistration"));
	    linkReg.click();
	    
	    WebElement firstname = driver.findElement(By.id("firstName"));
	    WebElement lastname = driver.findElement(By.id("lastName"));
	    WebElement email = driver.findElement(By.id("email"));
	    WebElement password = driver.findElement(By.id("password"));
	    WebElement market = driver.findElement(By.id("marketType"));
	    WebElement register = driver.findElement(By.id("register"));
	    
	    firstname.sendKeys("samir");
	    lastname.sendKeys("rachidi");
	    email.sendKeys("radid@gmail.com");
	    password.sendKeys("123456789");
	    
	    register.click();
	    
	    WebElement LoginHere = driver.findElement(By.id("loginhere"));
	    LoginHere.click();
	    
	    WebElement LoginUsername = driver.findElement(By.id("username"));
	    WebElement LoginPassword = driver.findElement(By.id("password"));
	    WebElement submitLogin = driver.findElement(By.id("login-submit"));
	    
	    LoginUsername.sendKeys("radid@gmail.com");
	    LoginPassword.sendKeys("123456789");
	    submitLogin.click();
	    
	    Thread.sleep(5000);
	    driver.quit();
	    
	}

}
