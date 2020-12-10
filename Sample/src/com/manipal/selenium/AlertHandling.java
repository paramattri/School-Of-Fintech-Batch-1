package com.manipal.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\School_Of_Fintech\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.name("cusid")).sendKeys("10100");
		driver.findElement(By.name("submit")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertMessage = alert.getText();
		
		if(alertMessage.equals("Do you really want to delete this Customer?"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
		
		

	}

}
