package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.guru99.com/");
		
		Actions builder = new Actions(driver);
		
		WebElement searchIcon = driver.findElement(By.xpath("//button[@class=\"gsc-search-button gsc-search-button-v2\"][1]"));
		
		builder.keyDown(Keys.SHIFT).sendKeys(searchIcon,"guru99").keyUp(Keys.SHIFT).build().perform();
		
		Thread.sleep(3000);
		builder.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(2000);
		driver.quit();

	}

}
