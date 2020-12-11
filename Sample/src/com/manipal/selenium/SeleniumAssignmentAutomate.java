package com.manipal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAssignmentAutomate {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("u_0_2")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeHolder='First name']")).sendKeys("Param");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Attri");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("param@gmail.com");
		
		//Using Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement passElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		js.executeScript("arguments[0].value='qwerty'", passElement);
		//driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("qwerty");
		
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("11");
		
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("7");
		
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1998");
		
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
