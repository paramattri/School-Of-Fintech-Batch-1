package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAutomate {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("param@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("qwerty");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
