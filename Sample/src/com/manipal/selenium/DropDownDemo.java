package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByValue("INDIA");
		Thread.sleep(2000);
		
		drpCountry.selectByVisibleText("ITALY");
		Thread.sleep(2000);
		
		drpCountry.selectByIndex(1);
		Thread.sleep(2000);
		
		driver.quit();
		

	}

}
