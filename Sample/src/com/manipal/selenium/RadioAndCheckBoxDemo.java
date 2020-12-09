package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckBoxDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/radio.html");
		WebElement element = driver.findElement(By.xpath("//input[@id=\"vfb-7-2\"]"));
		element.click();
		
		if(element.isSelected())
			System.out.println("Radio Button is selected");
		else
			System.out.println("Radio Button is not selected");
		
		WebElement element1 = driver.findElement(By.xpath("//input[@id=\"vfb-6-1\"]"));
		element1.click();
		
		if(element1.isSelected())
			System.out.println("Check Box is selected");
		else
			System.out.println("Check Box is not selected");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
