package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InscriptionMotDePasseNeCorrespondesPas {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\radid\\Desktop\\driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    

	    driver.get("http://localhost:8881/registration");

	   
	    //les champs
	    WebElement username = driver.findElement(By.id("username"));
	    WebElement password = driver.findElement(By.id("password"));
	    WebElement confirme = driver.findElement(By.id("confirm_password"));
	    WebElement phone = driver.findElement(By.id("phone"));
	    WebElement address = driver.findElement(By.id("address"));
	    WebElement market = driver.findElement(By.id("marketType"));
	    //button register
	    WebElement register = driver.findElement(By.id("register"));
	    
	    username.sendKeys("amine_alami");
	    password.sendKeys("123456789");
	    confirme.sendKeys("987654321");
	    phone.sendKeys("0666363636");
	    address.sendKeys("lalla yacout n°70 rue n°162");
	    //market.sendKeys("0");
	    register.click();

	}

}
