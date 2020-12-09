package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEventActionDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Actions builder = new Actions(driver);
		
		driver.get("https://www.guru99.com/");
		
		WebElement testingTab = driver.findElement(By.xpath("//span[text()=\"Testing\"]"));
		WebElement subTestingTab = driver.findElement(By.xpath("//span[text()=\"RPA\"]"));
		
		builder.moveToElement(testingTab).click(subTestingTab).build().perform();
		Thread.sleep(3000);
		driver.quit();
	}

}
