package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAccountTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\radid\\Desktop\\driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    

	    driver.get("http://localhost:8888/");
	    
	    WebElement LoginUsername = driver.findElement(By.id("username"));
	    WebElement LoginPassword = driver.findElement(By.id("password"));
	    WebElement submitLogin = driver.findElement(By.id("login-submit"));
	    
	    LoginUsername.sendKeys("samir_rachidi");
	    LoginPassword.sendKeys("123456789");
	    submitLogin.click();
	    
	    driver.get("http://localhost:8888/");
	    WebElement closeUsername = driver.findElement(By.id("username"));
	    WebElement closePassword = driver.findElement(By.id("password"));
	    WebElement closeAccountNumber = driver.findElement(By.id("accountNumber"));
	    WebElement closeSubmit= driver.findElement(By.id("register"));
	    
	    closeUsername.sendKeys("samir_rachidi");
	    closePassword.sendKeys("123456789");
	    closeAccountNumber.sendKeys("xxxxxxxx");

	    closeSubmit.click();

	}

}
