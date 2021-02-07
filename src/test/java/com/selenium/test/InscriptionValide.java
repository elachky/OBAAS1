package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InscriptionValide {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\radid\\Desktop\\driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    

	    driver.get("http://localhost:8881/");

	    WebElement linkReg = driver.findElement(By.id("toregistration"));
	    linkReg.click();
	    //les champs
	    WebElement firstname = driver.findElement(By.id("firstName"));
	    WebElement lastname = driver.findElement(By.id("lastName"));
	    WebElement username = driver.findElement(By.id("username"));
	    WebElement password = driver.findElement(By.id("password"));
	    WebElement confirme = driver.findElement(By.id("confirm_password"));
	    WebElement phone = driver.findElement(By.id("phone"));
	    WebElement address = driver.findElement(By.id("address"));
	    WebElement market = driver.findElement(By.id("marketType"));
	    //button register
	    WebElement register = driver.findElement(By.id("register"));
	    
	    
	    firstname.sendKeys("samir");
	    lastname.sendKeys("rachid");
	    username.sendKeys("samir_rachidi");
	    password.sendKeys("123456789");
	    confirme.sendKeys("123456789");
	    phone.sendKeys("0666033036");
	    address.sendKeys("lalla yacout n°70 rue n°162");
	    market.sendKeys("0");
	    register.click();
	    
	    /*WebElement LoginHere = driver.findElement(By.id("loginhere"));
	    LoginHere.click();*/
	    
	    driver.get("http://localhost:8881/login");
	    
	    WebElement LoginUsername = driver.findElement(By.id("username"));
	    WebElement LoginPassword = driver.findElement(By.id("password"));
	    WebElement submitLogin = driver.findElement(By.id("login-submit"));
	    
	    LoginUsername.sendKeys("samir_rachidi");
	    LoginPassword.sendKeys("123456789");
	    submitLogin.click(); 
	    
	    
	    //Thread.sleep(50000);
	    //driver.quit();
	    
	}

}
