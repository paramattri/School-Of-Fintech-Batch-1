package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement email = driver.findElement(By.id("email"));
		js.executeScript("arguments[0].value='Hello'", email);
		
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.id("pass"));
		js.executeScript("arguments[0].value='qwerty'", password);
		
		Thread.sleep(1000);
		js.executeScript("alert('Welcome')");
		Thread.sleep(3000);
		
		System.out.println(js.executeScript("return document.title"));
		System.out.println(js.executeScript("return document.url"));
		System.out.println(js.executeScript("return document.domain"));
		
		js.executeScript("history.go(0)");
		
		Thread.sleep(3000);
		driver.quit();

	}

}
