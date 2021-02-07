package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemandeDeService {

	public static void main(String[] args) {
		


		System.setProperty("webdriver.chrome.driver","C:\\Users\\radid\\Desktop\\driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    

	    driver.get("http://localhost:8881/");
	    
	    WebElement LoginUsername = driver.findElement(By.id("username"));
	    WebElement LoginPassword = driver.findElement(By.id("password"));
	    WebElement submitLogin = driver.findElement(By.id("login-submit"));
	    
	    LoginUsername.sendKeys("samir_rachidi");
	    LoginPassword.sendKeys("123456789");
	    submitLogin.click();
	    

	    driver.get("http://localhost:8881/demandeService");
	    
	    WebElement LoginUsername1 = driver.findElement(By.id("username"));
	    WebElement LoginPassword1 = driver.findElement(By.id("password"));
	    WebElement AccountNumber1 = driver.findElement(By.id("fromAccount"));
	    WebElement chèque = driver.findElement(By.id("browser"));
	    WebElement submitLogin1 = driver.findElement(By.id("register"));
	    
	    
	    
	    
	    LoginUsername1.sendKeys("samir_rachidi");
	    LoginPassword1.sendKeys("123456789");
	    AccountNumber1.sendKeys("891344215");
	    chèque.sendKeys("Request for a new cheque book");

	    
	    submitLogin1.click();

		
		
	}

}
