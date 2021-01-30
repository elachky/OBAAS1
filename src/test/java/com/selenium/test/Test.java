package com.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\radid\\Desktop\\driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("http://localhost:3360/");
	    System.out.println("OBAAS a été lancé avec succés!");
	    Thread.sleep(5000);
	    driver.quit();
	    //System.out.println(driver.getTitle());
	    //driver.navigate().to("http://localhost:3360/registration");
	}

}
