package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jsbin.com/osebed/2");
		
		Select multiSelect = new Select(driver.findElement(By.id("fruits")));
		multiSelect.selectByValue("banana");
		multiSelect.selectByValue("grape");
		Thread.sleep(3000);
		multiSelect.deselectByVisibleText("Grape");
		Thread.sleep(2000);
		driver.quit();

	}

}
