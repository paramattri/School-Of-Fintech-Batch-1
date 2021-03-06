package com.manipal.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		
		//First have to configure the browser on which we have to run the script.
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		
		//Checking if jar files are configured or not.
		
		WebDriver driver = new ChromeDriver();
		
		// Navigating to website
		driver.get("https://www.google.com");
		
		Thread.sleep(5000);
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Chelsea");
		searchBox.submit();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
